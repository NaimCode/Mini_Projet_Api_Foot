package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class StatisticPlayer {
    private Team_v1 team_v1;
    private League_v2 league_v2;
    private int appearences;
    private int shootTotal;
    private int shootOn;
    private int goal;
    private int assist;
    private int passe;
    private int tacle;
    private int dribleAttempts;
    private int dribleReussi;
    private int yellow;
    private int red;

    public StatisticPlayer(Team_v1 team_v1, League_v2 league_v2, int appearences, int shootTotal, int shootOn, int goal, int assist, int passe, int tacle, int dribleAttempts, int dribleReussi, int yellow, int red) {
        this.team_v1 = team_v1;
        this.league_v2 = league_v2;
        this.appearences = appearences;
        this.shootTotal = shootTotal;
        this.shootOn = shootOn;
        this.goal = goal;
        this.assist = assist;
        this.passe = passe;
        this.tacle = tacle;
        this.dribleAttempts = dribleAttempts;
        this.dribleReussi = dribleReussi;
        this.yellow = yellow;
        this.red = red;
    }
    public StatisticPlayer(JsonNode json) {
        if(json.get("team")!=null)
        this.team_v1 = new Team_v1(json.get("team"));
        if(json.get("league")!=null)
        this.league_v2 = new League_v2(json.get("league"));
        if(json.get("games").get("appearences")!=null)
        this.appearences = json.get("games").get("appearences").asInt();
        if(json.get("shots").get("total")!=null)
        this.shootTotal = json.get("shots").get("total").asInt();
        if(json.get("shots").get("on")!=null)
        this.shootOn = json.get("shots").get("on").asInt();
        if(json.get("goals").get("total")!=null)
        this.goal = json.get("goals").get("total").asInt();
        if(json.get("goals").get("assists")!=null)
        this.assist =json.get("goals").get("assists").asInt();
        if(json.get("passes").get("total")!=null)
        this.passe =json.get("passes").get("total").asInt();
        if(json.get("tackles").get("total")!=null)
        this.tacle =json.get("tackles").get("total").asInt();
        if(json.get("dribbles").get("attempts")!=null)
        this.dribleAttempts = json.get("dribbles").get("attempts").asInt();
        if(json.get("dribbles").get("success")!=null)
        this.dribleReussi =json.get("dribbles").get("success").asInt();
        if(json.get("cards").get("yellow")!=null)
        this.yellow = json.get("cards").get("yellow").asInt();
        if(json.get("cards").get("red")!=null)
        this.red = json.get("cards").get("red").asInt();
    }
    public Team_v1 getTeam_v1() {
        return team_v1;
    }

    public void setTeam_v1(Team_v1 team_v1) {
        this.team_v1 = team_v1;
    }

    public League_v2 getLeague_v2() {
        return league_v2;
    }

    public void setLeague_v2(League_v2 league_v2) {
        this.league_v2 = league_v2;
    }

    public int getAppearences() {
        return appearences;
    }

    public void setAppearences(int appearences) {
        this.appearences = appearences;
    }

    public int getShootTotal() {
        return shootTotal;
    }

    public void setShootTotal(int shootTotal) {
        this.shootTotal = shootTotal;
    }

    public int getShootOn() {
        return shootOn;
    }

    public void setShootOn(int shootOn) {
        this.shootOn = shootOn;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public int getTacle() {
        return tacle;
    }

    public void setTacle(int tacle) {
        this.tacle = tacle;
    }

    public int getDribleAttempts() {
        return dribleAttempts;
    }

    public void setDribleAttempts(int dribleAttempts) {
        this.dribleAttempts = dribleAttempts;
    }

    public int getDribleReussi() {
        return dribleReussi;
    }

    public void setDribleReussi(int dribleReussi) {
        this.dribleReussi = dribleReussi;
    }

    public int getYellow() {
        return yellow;
    }

    public void setYellow(int yellow) {
        this.yellow = yellow;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }
}
