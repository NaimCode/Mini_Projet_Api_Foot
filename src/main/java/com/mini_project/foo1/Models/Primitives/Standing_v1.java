package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Standing_v1 {
    private int rank;
    private Team_v1 team_v1;
    private int points;
    private int goalsDiff;
    private String group;
    private String form;
    private String description;
    private int wins;
    private int loses;
    private int draws;
    private int goalFor;
    private int goalAgainst;

    public Standing_v1(int rank, Team_v1 team_v1, int points, int goalsDiff, String group, String form, String description, int wins, int loses, int draws, int goalFor, int goalAgainst) {
        this.rank = rank;
        this.team_v1 = team_v1;
        this.points = points;
        this.goalsDiff = goalsDiff;
        this.group = group;
        this.form = form;
        this.description = description;
        this.wins = wins;
        this.loses = loses;
        this.draws = draws;
        this.goalFor = goalFor;
        this.goalAgainst = goalAgainst;
    }
    public Standing_v1(JsonNode json) {
        this.rank = json.get("rank").asInt();
        this.team_v1 = new Team_v1(json.get("team"));
        this.points = json.get("points").asInt();
        this.goalsDiff = json.get("goalsDiff").asInt();
        this.group = json.get("group").asText();
        this.form = json.get("form").asText();
        this.description = json.get("description").asText();
        this.wins = json.get("all").get("win").asInt();
        this.loses = json.get("all").get("lose").asInt();
        this.draws =  json.get("all").get("draw").asInt();
        this.goalFor =  json.get("all").get("goals").get("for").asInt();
        this.goalAgainst = json.get("all").get("goals").get("against").asInt();
    }
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Team_v1 getTeam_v1() {
        return team_v1;
    }

    public void setTeam_v1(Team_v1 team_v1) {
        this.team_v1 = team_v1;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getGoalFor() {
        return goalFor;
    }

    public void setGoalFor(int goalFor) {
        this.goalFor = goalFor;
    }

    public int getGoalAgainst() {
        return goalAgainst;
    }

    public void setGoalAgainst(int goalAgainst) {
        this.goalAgainst = goalAgainst;
    }
}
