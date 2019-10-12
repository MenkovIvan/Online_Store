package store.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestConnectionController {

    @RequestMapping(value = "/test",
            method = RequestMethod.POST,
            headers = {"Content-type=application/json"})
    @ResponseBody
    public String test(@RequestBody String testJson){
        System.out.println(testJson);
        String test;
        Gson gson = new Gson();

        try{
             test = gson.fromJson(testJson,String.class);
             System.out.println(test);
        } catch( Exception f){
            System.out.println("obrabotka "+ f);
        }


        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String message;

        try{
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("test","nikita lox");
            message = gson.toJson(jsonObject);
            return message;
        }catch(Exception e){
            System.out.println("otpravka "+ e);
        }

        return "error";
    }

}