package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Coach;

import java.util.ArrayList;
import java.util.List;

public class FixtureLineup {
    private Coach coach;
    private String formation;
    private List<Player> startIX;
    private List<Player> substitutes;

    public FixtureLineup(Coach coach, String formation, List<Player> startIX, List<Player> substitutes) {
        this.coach = coach;
        this.formation = formation;
        this.startIX = startIX;
        this.substitutes = substitutes;
    }
    public FixtureLineup(JsonNode json) {
        this.coach = new Coach(json.get("coach"));
        this.formation = json.get("formation").asText();
        List<Player> players=new ArrayList<>();
        json.get("startIX").elements().forEachRemaining(jsonNode -> players.add(new Player(jsonNode.get("player"))));
        this.startIX = players;
        players.clear();
        json.get("substitutes").elements().forEachRemaining(jsonNode -> players.add(new Player(jsonNode.get("player"))));
        this.substitutes = players;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public List<Player> getStartIX() {
        return startIX;
    }

    public void setStartIX(List<Player> startIX) {
        this.startIX = startIX;
    }

    public List<Player> getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(List<Player> substitutes) {
        this.substitutes = substitutes;
    }
}
