package com.mini_project.foo1.Services.API;
import com.mini_project.foo1.Models.Country;
import com.mini_project.foo1.Models.League;
import com.mini_project.foo1.Models.Team;
import com.mini_project.foo1.Services.Utils.Convertion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Api_Football_Beta {

    //Informations utiles que nous allons les utiliser dans nos appels
    private final String key="ee61458eeemsh49db22f0a6b3aa8p146ab4jsn92d4b24bd4a0";
    private final String apiUrl="https://api-football-beta.p.rapidapi.com/";
    private final String host="api-football-beta.p.rapidapi.com";
    ///
    private Convertion convertion = new Convertion();

    //Fonction qui prend l'endpoint et ses parametres en parametres
    //Elle fait l'appel vers l'api et retourne le resultat
    //Renvoie un type Map composé de l'headers et le body
    public String request(String endpoint, String param){
        //La construction de la requeste
        java.net.http.HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl+endpoint+param))
                .header("x-rapidapi-host", host)
                .header("x-rapidapi-key", key)
                //HttpRequest.BodyPublishers.noBody() Pour mentionner qu'on a pas de body.
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response;
        try {
            //L'appel
         response = HttpClient.newHttpClient()
                 .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            return null;
        }
        return response.body();
    }

    ///////////////////////////////////
    //////////////////////////////////

    ///Country
    public List<Country> getCountries(String name,String search){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();
        if(name!=null) params.put("name",name);
        if(search!=null) params.put("search",search);

        List<Country> countries=new ArrayList<>();
        convertion.toJson(request("countries",convertion.toString(params))).get("response").elements().forEachRemaining(json->countries.add(new Country(json)));
        return countries;
    }


    //Team
    public List<Team> getTeams(String id,String name,String search,String country,String season,String league){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();
        if(name!=null) params.put("name",name);
        if(search!=null) params.put("search",search);
        if(id!=null) params.put("id",id);
        if(country!=null) params.put("country",country);
        if(season!=null) params.put("season",season);
        if(league!=null) params.put("league",league);

        List<Team> teams=new ArrayList<>();
        convertion.toJson(request("teams",convertion.toString(params)))
                .get("response")
                .elements().
                forEachRemaining(json->teams.add(new Team(json)));
        return teams;
    }

    //Leagues
    public List<League> getLeagues(String id,String name,String search,String country, String season,String type, String current,String team){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();
        if(name!=null) params.put("name",name);
        if(search!=null) params.put("search",search.replaceAll(" ","%20"));
        if(id!=null) params.put("id",id);
        if(country!=null) params.put("country",country);
        if(season!=null) params.put("season",season);
        if(team!=null) params.put("team",team);
        if(type!=null) params.put("type",type);
        if(current!=null) params.put("current",current);

        List<League> leagues=new ArrayList<>();
        convertion.toJson(request("leagues",convertion.toString(params)))
                .get("response")
                .elements().
                forEachRemaining(json->leagues.add(new League(json)));
        return leagues;
    }

}
