package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Team_v1 {
    protected int id;
    protected String name;
    protected String logo;
    protected Boolean winner;

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }

    public Team_v1(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }
    public Team_v1(JsonNode json) {
        if(json.get("id")!=null)
        this.id = json.get("id").asInt();
        if(json.get("name")!=null)
        this.name = json.get("name").asText();
        if(json.get("logo")!=null)
        this.logo = json.get("logo").asText();
        if(json.get("winner")!=null)
            this.winner=json.get("winner").asBoolean();
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
