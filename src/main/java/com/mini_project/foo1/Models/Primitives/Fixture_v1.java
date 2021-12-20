package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Fixture_v1 {
    private NumberStatistique played;
    private NumberStatistique wins;
    private NumberStatistique draws;
    private NumberStatistique loses;

    public Fixture_v1(NumberStatistique played, NumberStatistique wins, NumberStatistique draws, NumberStatistique loses) {
        this.played = played;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
    }
    public Fixture_v1(JsonNode json) {
        this.played = new NumberStatistique(json.get("played"));
        this.wins = new NumberStatistique(json.get("wins"));
        this.draws = new NumberStatistique(json.get("draws")) ;
        this.loses = new NumberStatistique(json.get("loses"));
    }

    public NumberStatistique getPlayed() {
        return played;
    }

    public void setPlayed(NumberStatistique played) {
        this.played = played;
    }

    public NumberStatistique getWins() {
        return wins;
    }

    public void setWins(NumberStatistique wins) {
        this.wins = wins;
    }

    public NumberStatistique getDraws() {
        return draws;
    }

    public void setDraws(NumberStatistique draws) {
        this.draws = draws;
    }

    public NumberStatistique getLoses() {
        return loses;
    }

    public void setLoses(NumberStatistique loses) {
        this.loses = loses;
    }
}
