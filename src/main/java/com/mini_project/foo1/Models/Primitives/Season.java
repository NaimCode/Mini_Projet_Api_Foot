package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Season {
    private int year;
    private String start;
    private String end;
    private Boolean current;

    public Season(int year, String start, String end, Boolean current) {
        this.year = year;
        this.start = start;
        this.end = end;
        this.current = current;
    }

    //
    public Season(JsonNode json) {
        this.year = json.get("year").asInt();
        this.start = json.get("start").asText();
        this.end = json.get("end").asText();
        this.current = json.get("current").asBoolean();
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }
}
