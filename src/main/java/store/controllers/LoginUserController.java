package store.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;
import store.domain.User;
import store.repository.UserRepository;

import java.util.Iterator;

@RestController
public class LoginUserController {

    private UserRepository userRepository;

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String login(@RequestBody String testJson){

        System.out.println(testJson);
        Gson gson = new Gson();


        User user = gson.fromJson(testJson,User.class);
        System.out.println(user.toString());


        Iterable<User> userIterable = userRepository.findAll();
        for ( Iterator<User> iterator = userIterable.iterator(); iterator.hasNext();){
            System.out.println(iterator.next().getUsername());
        }


        User userInDB = userRepository.findByUsername(user.getUsername());
        String message;

        if (userInDB!=null && user.getUsername().equals(userInDB.getUsername())){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", "no");
            jsonObject.addProperty("errorMessage", "Пользователя с таким логином не существует");
            message = gson.toJson(jsonObject);
            return message;
        } else {
            if (userInDB != null && user.getPassword().equals(userInDB.getPassword())) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "yes");
                jsonObject.addProperty("errorMessage", "ok");
                message = gson.toJson(jsonObject);
                return message;
            } else {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("status", "no");
                jsonObject.addProperty("errorMessage", "Неправильно введен пароль");
                message = gson.toJson(jsonObject);
                return message;
            }
        }
    }
}
