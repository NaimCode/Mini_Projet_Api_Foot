package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Trophie {
    private String league;
    private String place;
    private String season;

    public Trophie(String league, String place, String season) {
        this.league = league;
        this.place = place;
        this.season = season;
    }
    public Trophie(JsonNode json) {
        this.league = json.get("league").asText();
        this.place = json.get("place").asText();
        this.season = json.get("season").asText();
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
