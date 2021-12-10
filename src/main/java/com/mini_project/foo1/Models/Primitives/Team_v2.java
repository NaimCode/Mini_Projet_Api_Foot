package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Team_v2 extends Team_v1{
    private int founded;
    private String country;
    private Boolean national;

    public Team_v2(int id, String name, String logo, int founded, String country, Boolean national) {
        super(id, name, logo);
        this.founded = founded;
        this.country = country;
        this.national = national;
    }

    public Team_v2(JsonNode json) {
        super(json);
        this.founded = json.get("founded").asInt();
        this.country = json.get("country").asText();
        this.national = json.get("national").asBoolean();
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean isNational() {
        return national;
    }

    public void setNational(Boolean national) {
        this.national = national;
    }
}
