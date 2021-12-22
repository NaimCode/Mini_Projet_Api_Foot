package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Statistic {
    //Need traduction
    private String type;
    private int value;

    public Statistic(String type, int value) {
        this.type = type;
        this.value = value;
    }
    public Statistic(JsonNode json) {
        this.type = json.get("type").asText();
        this.value = json.get("value").asInt();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
