package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Player {

    private int id;
    private String name;
    private int number;
    private String pos;
    private String grid;

    public Player(int id, String name, int number, String pos, String grid) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.pos = pos;
        this.grid = grid;
    }
    public Player(JsonNode json) {
        this.id = json.get("id").asInt();
        this.name = json.get("name").asText();
        this.number = json.get("number").asInt();
        this.pos = json.get("pos").asText();
        this.grid = json.get("grid").asText();
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }
}
