package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Primitives.League_v2;
import com.mini_project.foo1.Models.Primitives.Team_v1;


import java.security.Timestamp;
import java.util.Date;

public class Fixture {
    private int id;
    private String referee;
    private int timestamp;
    private int halfTime;
    private int fullTime;
    private String date;

    private int venueID;
    //Besoinn de traduction
    private String status;
    private int elapse;
    private League_v2 league_v2;
    private Team_v1 homeTeam;
    private Team_v1 awayTeam;
    private int homeGoal;
    private int awayGoal;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Fixture(int id, String referee,
                   int timestamp,
                   int halfTime,int fullTime,
                   int venueID, String status, int elapse,
                   League_v2 league_v2, Team_v1 homeTeam,String date,
                   Team_v1 awayTeam, int homeGoal, int awayGoal) {
        this.date=date;
        this.id = id;
        this.referee = referee;
        this.timestamp = timestamp;
        this.halfTime = halfTime;
        this.fullTime = fullTime;
        this.venueID = venueID;
        this.status = status;
        this.elapse = elapse;
        this.league_v2 = league_v2;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoal = homeGoal;
        this.awayGoal = awayGoal;
    }
    public Fixture(JsonNode json) {
        if(json.get("fixture").get("id")!=null)
        this.id = json.get("fixture").get("id").asInt();
        if(json.get("fixture").get("referee")!=null)
        this.referee = json.get("fixture").get("referee").asText();
        this.date = json.get("fixture").get("date").asText();
        if(json.get("fixture").get("timestamp")!=null)
        this.timestamp = json.get("fixture").get("timestamp").asInt();
        if(json.get("fixture").get("periods").get("first")!=null)
        this.halfTime = json.get("fixture").get("periods").get("first").asInt();
        if(json.get("fixture").get("periods").get("second")!=null)
        this.fullTime =  json.get("fixture").get("periods").get("second").asInt();
        this.venueID =json.get("fixture").get("venue").get("id").asInt();
        this.status = json.get("fixture").get("status").get("long").asText();
        this.elapse = json.get("fixture").get("status").get("elapsed").asInt();
        this.league_v2 = new League_v2(json.get("league"));
        this.homeTeam = new Team_v1(json.get("teams").get("home"));
        this.awayTeam = new Team_v1(json.get("teams").get("away"));;
        if(json.get("goals").get("home")!=null)
        this.homeGoal = json.get("goals").get("home").asInt();
        if(json.get("goals").get("away")!=null)
        this.awayGoal = json.get("goals").get("away").asInt();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getHalfTime() {
        return halfTime;
    }

    public void setHalfTime(int halfTime) {
        this.halfTime = halfTime;
    }

    public int getFullTime() {
        return fullTime;
    }

    public void setFullTime(int fullTime) {
        this.fullTime = fullTime;
    }

    public int getVenueID() {
        return venueID;
    }

    public void setVenueID(int venueID) {
        this.venueID = venueID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getElapse() {
        return elapse;
    }

    public void setElapse(int elapse) {
        this.elapse = elapse;
    }

    public League_v2 getLeague_v2() {
        return league_v2;
    }

    public void setLeague_v2(League_v2 league_v2) {
        this.league_v2 = league_v2;
    }

    public Team_v1 getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team_v1 homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team_v1 getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team_v1 awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoal() {
        return homeGoal;
    }

    public void setHomeGoal(int homeGoal) {
        this.homeGoal = homeGoal;
    }

    public int getAwayGoal() {
        return awayGoal;
    }

    public void setAwayGoal(int awayGoal) {
        this.awayGoal = awayGoal;
    }
    //    "referee":"R. Rivero"
//            "timezone":"UTC"
//            "date":"2020-02-06T00:00:00+00:00"
//            "timestamp":1580947200
}
