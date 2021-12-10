package com.mini_project.foo1.Services.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class Convertion {
    ObjectMapper mapper = new ObjectMapper();

    //Methode qui convertit un string en json
    public JsonNode toJson(String string) {
        try {
            return mapper.readTree(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

    }

    //Methode qui convertit une map en json
    public JsonNode toJson(Map<String,String> map)  {
        return toJson("{ \"headers\": \""+map.get("headers").toString()+"\", \"body\": \""+map.get("body")+"\"}");
    }

    //Converti a partir d'un mao
    public String toString(Map<String,String> map){
        final String[] param = {""};
        final int[] index = {0};
        //Constitution des parametres
        map.forEach((key,value)->{
            if(index[0] ==0)
                param[0] +="?"+key+"="+value;
            else
                param[0] +="&"+key+"="+value;
            index[0]++;
        });
        return param[0];
    }
}