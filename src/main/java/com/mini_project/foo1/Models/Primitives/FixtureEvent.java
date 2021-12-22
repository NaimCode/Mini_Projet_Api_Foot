package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class FixtureEvent {
    private int elapse;
    private Team_v1 team;
    private Player player;
    private Player assist;

    //need traduction
    private String type;
    //need traduction
    private String detail;
    //need traduction
    private String comments;

    public FixtureEvent(int elapse, Team_v1 team, Player player, Player assist, String type, String detail, String comments) {
        this.elapse = elapse;
        this.team = team;
        this.player = player;
        this.assist = assist;
        this.type = type;
        this.detail = detail;
        this.comments = comments;
    }

    public FixtureEvent(JsonNode node) {
        this.elapse = node.get("time").get("elapsed").asInt();
        this.team = new Team_v1(node.get("team"));
        this.player = new Player(node.get("player"));
        this.assist = new Player(node.get("assist"));
        this.type = node.get("type").asText();
        this.detail = node.get("detail").asText();
        this.comments = node.get("comments").asText();
    }

    public int getElapse() {
        return elapse;
    }

    public void setElapse(int elapse) {
        this.elapse = elapse;
    }

    public Team_v1 getTeam() {
        return team;
    }

    public void setTeam(Team_v1 team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getAssist() {
        return assist;
    }

    public void setAssist(Player assist) {
        this.assist = assist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
