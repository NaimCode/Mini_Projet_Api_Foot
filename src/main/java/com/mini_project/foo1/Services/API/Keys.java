package com.mini_project.foo1.Services.API;


import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class Keys {
    public static List<Key> keys= Arrays.asList(
            //naim.magnus@gmail.com
           // new Key("7a993e4f8emshb10196fe71115b3p11e37bjsn7c10e43834bb"),
            //naimzeroab@gmail.com
           // new Key("f506d0c807msh552ad2ae43900d6p1fa805jsnb7cfc3b04537"),
            //Ob2a-officiel@gmail.com
           // new Key("4b64943bfdmsh881c078232483f0p1eef98jsnd454af5e8bc5"),
            //hawa key
          //  new Key("5c68e4155bmshacdd4ece7352afep11f7cfjsn80d476d01f78"),
            //aya key
            new Key("d560e412ffmsh2e521a76f1abf27p126933jsn18a435ec2b29"),
            //naimdevelopper@gmail.com
            new Key("ee61458eeemsh49db22f0a6b3aa8p146ab4jsn92d4b24bd4a0")
            );


    public static String getKey() {
        for (Key model : keys) {
            if (model.getLeftRequest() >= 90) {
                return model.getKey();

            }
        }
        return null;
    }
    public static String resetKey() {
        for (Key model : keys) {
            if (model.getSecondReset()== 0) {
                return model.getKey();

            }
        }
        return null;
    }

    public static void setValueKey(HttpResponse<String> response, String key){
        for (Key model:keys) {
            if(model.getKey()==key
                    && response.headers().map().get("x-ratelimit-requests-remaining")!=null
                    && response.headers().map().get("X-RateLimit-Requests-Reset")!=null){

                model.setLeftRequest( Integer.parseInt(response.headers().map().get("x-ratelimit-requests-remaining").get(0)));
                model.setSecondReset( Integer.parseInt(response.headers().map().get("X-RateLimit-Requests-Reset").get(0)));
                System.out.println(model.getLeftRequest());
            }
        }
    }
}
