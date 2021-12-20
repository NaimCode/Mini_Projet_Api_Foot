package com.mini_project.foo1.Services.API;
import com.mini_project.foo1.Models.*;
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
        if(search!=null) params.put("search",search.replaceAll(" ","%20"));
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

    //TeamStatistique
    public List<Team_statistique> getTeamStatistique(String team, String season, String league){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();

        if(season!=null) params.put("season",season);
        if(team!=null) params.put("team",team);
        if(league!=null) params.put("league",league);

        List<Team_statistique> team_statistiques=new ArrayList<>();
        convertion.toJson(request("teams/statistics",convertion.toString(params)))
                .get("response")
                .elements().
                forEachRemaining(json->team_statistiques.add(new Team_statistique(json)));
        return team_statistiques;
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

    //Fixtures
    public List<Fixture> getFixtures(String id, String status, String from, String to, String date, String live, String last, String round, String season, String league, String team){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();
        if(status!=null) params.put("status",status);
        if(from!=null) params.put("from",from);
        if(id!=null) params.put("id",id);
        if(to!=null) params.put("to",to);
        if(season!=null) params.put("season",season);
        if(team!=null) params.put("team",team);
        if(league!=null) params.put("league",league);
        if(date!=null) params.put("date",date);
        if(live!=null) params.put("live",live);
        if(round!=null) params.put("round",round);
        if(last!=null) params.put("last",last);

        List<Fixture> fixtures=new ArrayList<>();
        convertion.toJson(request("fixtures",convertion.toString(params)))
                .get("response")
                .elements().
                forEachRemaining(json->fixtures.add(new Fixture(json)));
        return fixtures;
    }
}
