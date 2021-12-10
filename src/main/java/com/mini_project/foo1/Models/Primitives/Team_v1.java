package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Team_v1 {
    protected int id;
    protected String name;
    protected String logo;

    public Team_v1(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }
    public Team_v1(JsonNode json) {
        this.id = json.get("id").asInt();
        this.name = json.get("name").asText();;
        this.logo = json.get("logo").asText();;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
