package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Sidelined {
    private String type;
    private String start;
    private String end;

    public Sidelined(String type, String start, String end) {
        this.type = type;
        this.start = start;
        this.end = end;
    }
    public Sidelined(JsonNode json) {
        this.type = json.get("type").asText();
        this.start = json.get("start").asText();
        this.end = json.get("end").asText();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
