package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Primitives.League_v2;
import com.mini_project.foo1.Models.Primitives.Standing_v1;
import com.mini_project.foo1.Models.Primitives.Standings_group;

import java.util.ArrayList;
import java.util.List;

public class Standing {
    private League_v2 league_v2;
    private List<Standings_group> standings_groups;

    public List<Standings_group> getStandings_groups() {
        return standings_groups;
    }

    public void setStandings_groups(List<Standings_group> standings_groups) {
        this.standings_groups = standings_groups;
    }

    public Standing(JsonNode json) {
        if(json.get("league")!=null)
        this.league_v2 = new League_v2(json.get("league"));

        List<Standings_group> standinss=new ArrayList<>();
        json.get("league").get("standings").elements().forEachRemaining(jsonNode -> standinss.add(new Standings_group(jsonNode)));

        this.standings_groups = standinss;
    }

    public League_v2 getLeague_v2() {
        return league_v2;
    }

    public void setLeague_v2(League_v2 league_v2) {
        this.league_v2 = league_v2;
    }


}
