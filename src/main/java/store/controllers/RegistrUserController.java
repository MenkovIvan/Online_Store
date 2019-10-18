package store.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import store.domain.User;
import store.repository.UserRepository;

@RestController
public class RegistrUserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/registr",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String registr(@RequestBody String testJson){

        System.out.println(testJson);
        Gson gson = new Gson();


        User userReg = gson.fromJson(testJson,User.class);
        System.out.println(userReg.toString());
        String messageReg;

        User userInDb = userRepository.findByUsername(userReg.getUsername());
        if(userInDb == null) {
            JsonObject jsonObject = new JsonObject();

            userRepository.save(userReg);

            jsonObject.addProperty("status", "yes");
            jsonObject.addProperty("errorMessage", "ok");

            messageReg = gson.toJson(jsonObject);
            return messageReg;
        }
        else{
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("status", "no");
            jsonObject.addProperty("errorMessage", "Пользователя с таким логином уже существует");
            messageReg = gson.toJson(jsonObject);
            return messageReg;
        }
    }

}
