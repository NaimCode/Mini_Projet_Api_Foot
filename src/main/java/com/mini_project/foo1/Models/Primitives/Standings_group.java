package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class Standings_group {
    List<Standing_v1> standing_v1s;

    public Standings_group(List<Standing_v1> standing_v1s) {
        this.standing_v1s = standing_v1s;
    }
    public Standings_group(JsonNode json) {
        List<Standing_v1> standing_v1s=new ArrayList<>();
        json.elements().forEachRemaining(jso -> standing_v1s.add(new Standing_v1(jso)));
        this.standing_v1s = standing_v1s;
    }



    public List<Standing_v1> getStanding_v1s() {
        return standing_v1s;
    }

    public void setStanding_v1s(List<Standing_v1> standing_v1s) {
        this.standing_v1s = standing_v1s;
    }
}
