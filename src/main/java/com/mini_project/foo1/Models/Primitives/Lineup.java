package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Lineup {
    private String formation;
    private int played;

    public Lineup(String formation, int played) {
        this.formation = formation;
        this.played = played;
    }
    public Lineup(JsonNode json) {
        this.formation = json.get("formation").asText();
        this.played = json.get("played").asInt();
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }
}
