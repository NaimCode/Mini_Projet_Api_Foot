package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Primitives.Team_v2;
import com.mini_project.foo1.Models.Primitives.Venue;

public class Team {
    private Team_v2 team_v2;
    private Venue venue;

    public Team(Team_v2 team_v2, Venue venue) {
        this.team_v2 = team_v2;
        this.venue = venue;
    }
    public Team(JsonNode json) {
        this.team_v2 = new Team_v2(json.get("team"));
        this.venue = new Venue(json.get("venue"));
    }


    public Team_v2 getTeam_v2() {
        return team_v2;
    }

    public void setTeam_v2(Team_v2 team_v2) {
        this.team_v2 = team_v2;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
