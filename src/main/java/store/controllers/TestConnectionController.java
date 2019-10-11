package store.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConnectionController {

    @PostMapping("/test")
    public String test(@RequestBody String testJson){
        Gson gson = new Gson();
        String test = gson.fromJson(testJson,String.class);
        System.out.println(testJson);

        System.out.println(test);

        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String message;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("test","nikita lox");
        message = gson.toJson(jsonObject);
        return message;
    }
}