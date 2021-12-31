package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class NumberStatistique {
    private int home;
    private int away;

    private int total;

    public NumberStatistique(int home, int away, int total) {
        this.home = home;
        this.away = away;
        this.total = total;
    }
    public NumberStatistique(JsonNode json) {
        if(json.get("home")!=null)
        this.home = json.get("home").asInt();
        this.away = json.get("away").asInt();
        this.total = json.get("total").asInt();
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getAway() {
        return away;
    }

    public void setAway(int away) {
        this.away = away;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
