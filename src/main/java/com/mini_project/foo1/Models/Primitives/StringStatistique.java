package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class StringStatistique {
    private String home;
    private String away;

    private String total;

    public StringStatistique(String home, String away, String total) {
        this.home = home;
        this.away = away;
        this.total = total;
    }
    public StringStatistique(JsonNode json) {
        this.home = json.get("home").asText();
        this.away = json.get("away").asText();
        this.total = json.get("total").asText();
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
