package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Career {
    private Team_v1 team;
    private String start;
    //Can be null
    private String end;

    public Career(Team_v1 team, String start, String end) {
        this.team = team;
        this.start = start;
        this.end = end;
    }
    public Career(JsonNode jsonNode) {
        if(jsonNode.get("team")!=null)
        this.team = new Team_v1(jsonNode.get("team"));
        if(jsonNode.get("start")!=null)
        this.start = jsonNode.get("start").asText();
        if(jsonNode.get("end")!=null)
        this.end = jsonNode.get("end").asText();
    }

    public Team_v1 getTeam() {
        return team;
    }

    public void setTeam(Team_v1 team) {
        this.team = team;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
