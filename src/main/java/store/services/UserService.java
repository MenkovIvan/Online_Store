package store.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.model.User;
import store.helper.RequestStatus;
import store.repository.UserRepository;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private Gson gson = new Gson();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String loginUser(String inputJson){

        User userFromClient = gson.fromJson(inputJson, User.class);
        User userInDB = userRepository.findByUsername(userFromClient.getUsername());

        String message;
        Integer status;

        if (userRepository.existsUserByEmailAndPassword(userFromClient.getEmail(),userFromClient.getPassword())) {
            message = "OK";
            status = RequestStatus.OK_STATUS.getStatus();
            log.info("login is true");
        }
        else if(userInDB != null){
            log.info("false password");
            message = "Password for this User is incorrect";
            status = RequestStatus.BAD_STATUS.getStatus();
        }
        else{
            log.info("false email");
            message = "User with this email is not exist";
            status = RequestStatus.BAD_STATUS.getStatus();
        }
        return getJsonString(message,status);
    }

    public String registrUser(String inputJson){
        User userFromClient = gson.fromJson(inputJson, User.class);
        User userInDB = userRepository.findByUsername(userFromClient.getUsername());

        String message;
        Integer status;

        if (userInDB == null){
            log.info("add user to database");
            userRepository.save(userFromClient);
            message = "OK";
            status = RequestStatus.OK_STATUS.getStatus();
        } else{
            message = "User with this email is exist, change email";
            status = RequestStatus.BAD_STATUS.getStatus();
        }
        return getJsonString(message,status);
    }

    public String getInfoUser(String inputJson){
        User userFromClient = gson.fromJson(inputJson, User.class);
        User userInDb = userRepository.findByUsername(userFromClient.getUsername());

        String message;
        Integer status;

        if (userInDb != null ){
            log.info("user exist");
            message = "OK";
            status = RequestStatus.OK_STATUS.getStatus();
        } else{
            log.info("user is not exist");
            message = "user is not exist";
            status = RequestStatus.BAD_STATUS.getStatus();
        }
        return getJsonStringWithUser(userInDb,message,status);
    }

    private String getJsonString(String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);
        String jsonToClient = jsonObject.toString();

        log.info("return to client={}", jsonToClient);
        return jsonToClient;
    }

    private String getJsonStringWithUser(User user, String message, Integer status) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("status",status);
        jsonObject.addProperty("message",message);

        jsonObject.add("user",gson.toJsonTree(user));
        String jsonToClient = jsonObject.toString();
        log.info("return to client={}", jsonToClient);

        return jsonToClient;
    }
}
