package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class FixtureStatistic_v1 {
    private Team_v1 team;
    private List<Statistic> statistics;

    public FixtureStatistic_v1(Team_v1 team, List<Statistic> statistics) {
        this.team = team;
        this.statistics = statistics;
    }
    public FixtureStatistic_v1(JsonNode json) {
        this.team = new Team_v1(json.get("team"));
        List<Statistic> statistics=new ArrayList<>();
        json.get("statistics").elements().forEachRemaining(jsonNode -> statistics.add(new Statistic(jsonNode)));
        this.statistics=statistics;
    }


    public Team_v1 getTeam() {
        return team;
    }

    public void setTeam(Team_v1 team) {
        this.team = team;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }
}
