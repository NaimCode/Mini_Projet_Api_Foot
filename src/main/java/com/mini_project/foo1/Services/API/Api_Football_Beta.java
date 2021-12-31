package com.mini_project.foo1.Services.API;
import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.*;
import com.mini_project.foo1.Models.Primitives.*;
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
    private final String key="7a993e4f8emshb10196fe71115b3p11e37bjsn7c10e43834bb";//"ee61458eeemsh49db22f0a6b3aa8p146ab4jsn92d4b24bd4a0";//"5c68e4155bmshacdd4ece7352afep11f7cfjsn80d476d01f78";//"d560e412ffmsh2e521a76f1abf27p126933jsn18a435ec2b29";// ""7a993e4f8emshb10196fe71115b3p11e37bjsn7c10e43834bb"; //"ee61458eeemsh49db22f0a6b3aa8p146ab4jsn92d4b24bd4a0";
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
    public List<Country> getCountries(String name,String search,String code){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();
        if(name!=null) params.put("name",name);
        if(search!=null) params.put("search",search);
        if(code!=null) params.put("code",code);

        List<Country> countries=new ArrayList<>();
        String requet=request("countries",convertion.toString(params));
        JsonNode jsonNode=convertion.toJson(requet);
        jsonNode.get("response").elements().forEachRemaining(json->countries.add(new Country(json)));
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
    public Team_statistique getTeamStatistique(String team, String season, String league){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();

        if(season!=null) params.put("season",season);
        if(team!=null) params.put("team",team);
        if(league!=null) params.put("league",league);

        return new Team_statistique(convertion.toJson(request("teams/statistics",convertion.toString(params)))
                .get("response"));
    }

    //TeamStatistique
    public PlayerPagination getPlayers(String team, String season, String league,String id,String page){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();

        if(season!=null) params.put("season",season);
        if(team!=null) params.put("team",team);
        if(league!=null) params.put("league",league);
        if(id!=null) params.put("id",id);
        if(league!=null) params.put("league",league);
        if(page!=null) params.put("page",page);
List<Player> players=new ArrayList<>();
JsonNode json=convertion.toJson(request("players",convertion.toString(params)));
json.get("response").elements().forEachRemaining(jsonNode -> players.add(new Player(jsonNode.get("player"))));

return new PlayerPagination(players,json.get("paging").get("total").asInt());
  }
    //Coach
    public List<Coach> getCoach(String id,String team,String search){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();
        if(search!=null) params.put("search",search);
        if(team!=null) params.put("team",team);
        if(id!=null) params.put("id",id);

        List<Coach> coaches=new ArrayList<>();
        convertion.toJson(request("coachs",convertion.toString(params)))
                .get("response")
                .elements().
                forEachRemaining(json->coaches.add(new Coach(json)));
        return coaches;
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
    //FixtureStatistics
    public FixtureStatistic getFixtureStatistic(String id,String venueID) throws InterruptedException {


        List<Venue> venue=new ArrayList<>();
        List<FixtureEvent> fixtureEvents=new ArrayList<>();
        List<FixtureStatistic_v1> fixtureStatistic_v1s=new ArrayList<>();
        List<FixtureLineup> fixtureLineups=new ArrayList<>();

        Runnable runnable=()->{

        convertion.toJson(request("fixtures/events","?fixture="+id))
                .get("response")
                .elements().
                forEachRemaining(json->fixtureEvents.add(new FixtureEvent(json)));



        };  Runnable runnable2=()->{
            convertion.toJson(request("fixtures/lineups","?fixture="+id))
                    .get("response")
                    .elements().
                    forEachRemaining(json->fixtureLineups.add(new FixtureLineup(json)));

        };  Runnable runnable4=()->{
            convertion.toJson(request("fixtures/statistics","?fixture="+id))
                    .get("response")
                    .elements().
                    forEachRemaining(json->fixtureStatistic_v1s.add(new FixtureStatistic_v1(json)));

        };
//        Runnable runnable3=()->{
//            convertion.toJson(request("venues","?id="+venueID))
//                    .get("response")
//                    .elements().
//                    forEachRemaining(json->venue.add(new Venue(json)));
//
//        };
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable2);
       // Thread thread3=new Thread(runnable3);
        Thread thread4=new Thread(runnable4);


        List<Thread> threads=new ArrayList<>();
        threads.add(thread1); threads.add(thread2);/* threads.add(thread3)*/; threads.add(thread4);
        for (Thread thread : threads) {
            thread.start();
            thread.join();
        }

        return new FixtureStatistic(fixtureStatistic_v1s,fixtureLineups,fixtureEvents);


    }
    //Standing
    public Standing  getStanding(String team,String season,String league){
        //Construction des parametres
        Map<String,String> params=new HashMap<>();

        if(season!=null) params.put("season",season);
        if(team!=null) params.put("team",team);
        if(league!=null) params.put("league",league);




        return new Standing(convertion.toJson(request("standings",convertion.toString(params)))
                .get("response").get(0));
    }


}
