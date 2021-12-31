package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class League_v1 {
    protected int id;
    protected String name;
    protected String type;
    protected String logo;

    public League_v1(int id, String name, String type, String logo) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.logo = logo;
    }

    //
    public League_v1(JsonNode json) {
        this.id = json.get("id").asInt();
        if(json.get("name")!=null)
        this.name = json.get("name").asText();
        if(json.get("type")!=null) {
            this.type = json.get("type").asText();
        }
        if(json.get("logo")!=null)
        this.logo = json.get("logo").asText();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
