package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Primitives.*;

import java.util.ArrayList;
import java.util.List;

public class Team_statistique {
    private League_v2 league_v2;
    private String form;
    private Team_v1 team_v1;
    private Goal goal;
    private Fixture_v1 fixture_v1;
    private List<Lineup> lineup;

    public Team_statistique(League_v2 league_v2, String form, Team_v1 team_v1, Goal goal, Fixture_v1 fixture_v1, List<Lineup> lineup) {
        this.league_v2 = league_v2;
        this.form = form;
        this.team_v1 = team_v1;
        this.goal = goal;
        this.fixture_v1 = fixture_v1;
        this.lineup = lineup;
    }public Team_statistique(JsonNode json) {
        this.league_v2 = new League_v2(json.get("league"));
        this.form = json.get("form").asText();
        this.team_v1 = new Team_v1(json.get("team"));
        this.goal = new Goal(json.get("goals"));
        this.fixture_v1 =new Fixture_v1(json.get("fixtures"));
        List<Lineup> lineups= new ArrayList<>();
                json.get("lineups").elements().forEachRemaining(jsonNode -> lineups.add(new Lineup(jsonNode)));
        this.lineup =lineups;

    }

    public League_v2 getLeague_v2() {
        return league_v2;
    }

    public void setLeague_v2(League_v2 league_v2) {
        this.league_v2 = league_v2;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Team_v1 getTeam_v1() {
        return team_v1;
    }

    public void setTeam_v1(Team_v1 team_v1) {
        this.team_v1 = team_v1;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Fixture_v1 getFixture_v1() {
        return fixture_v1;
    }

    public void setFixture_v1(Fixture_v1 fixture_v1) {
        this.fixture_v1 = fixture_v1;
    }

    public List<Lineup> getLineup() {
        return lineup;
    }

    public void setLineup(List<Lineup> lineup) {
        this.lineup = lineup;
    }
}
