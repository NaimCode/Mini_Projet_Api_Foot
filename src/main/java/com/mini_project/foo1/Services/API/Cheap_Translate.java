package com.mini_project.foo1.Services.API;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.TextTraduit;
import com.mini_project.foo1.Services.Utils.Convertion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cheap_Translate {

    //Informations utiles que nous allons les utiliser dans nos appels
    private final String key="ee61458eeemsh49db22f0a6b3aa8p146ab4jsn92d4b24bd4a0";
    private final String apiUrl="https://cheap-translate.p.rapidapi.com/";
    private final String host="cheap-translate.p.rapidapi.com";

    //
    private Convertion convertion=new Convertion();
    //Methode qui prend la langue et le mot en parametres
    //Et le traduit, puis elle le renvoie
    public String request(String lang,String mot) {

        String endpoint = "translate";
        //Constitution de l'appel
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl + endpoint))
                .header("content-type", "application/json")
                .header("x-rapidapi-host", host)
                .header("x-rapidapi-key", key)
                .method("POST", HttpRequest.BodyPublishers.ofString(
                        "{ \"fromLang\": \"auto-detect\", \"text\": \"" + mot + "\", \"to\": \"" + lang + "\"}")).build();

        HttpResponse<String> response;
        //L'envoi
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            e.printStackTrace();
            return mot;
        } catch (InterruptedException e) {
            return mot;
        }

        JsonNode body = convertion.toJson(response.body());
        if (body.get("status") != null)
            if (body.get("status").asInt() == 200)
                return body.get("translatedText").asText();
            else
                return mot;
        else
            return mot;
    }
}