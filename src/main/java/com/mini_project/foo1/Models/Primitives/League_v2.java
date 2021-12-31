package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class League_v2 extends League_v1{
    private int season;
    private String country;
    private String flag;

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    private String round;

    public League_v2(int id, String name, String type, String logo, int season, String country, String flag,String round) {
        super(id, name, type, logo);
        this.season = season;
        this.country = country;
        this.flag = flag;
        this.round=round;
    }

    public League_v2(JsonNode json) {
        super(json);
        this.season = json.get("season").asInt();
        if(json.get("country")!=null)
        this.country = json.get("country").asText();
        this.flag = json.get("flag").asText();
        if(json.get("round")!=null)
        this.round= json.get("round").asText();
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
