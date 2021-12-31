package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;
import org.jetbrains.annotations.NotNull;

public class Player {

    private int id;
    private String name;
    private int number;
    private String pos;
    private String grid;
    private String firstname;
    private String lastname;
    private int age;
    private String nationality;
    private String photo;

    public Player(int id, String name, int number, String pos, String grid, String firstname, String lastname, int age, String nationality, String photo) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.pos = pos;
        this.grid = grid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.nationality = nationality;
        this.photo = photo;
    }

    public Player(@NotNull JsonNode json) {
        this.id = json.get("id").asInt();
        if(json.get("name")!=null)
            this.name = json.get("name").asText();
        if(json.get("firstname")!=null)
            this.firstname = json.get("firstname").asText();
        if(json.get("lastname")!=null)
            this.lastname = json.get("lastname").asText();
        if(json.get("photo")!=null)
            this.photo = json.get("photo").asText();
        if(json.get("nationality")!=null)
            this.nationality = json.get("nationality").asText();
        if(json.get("age")!=null)
            this.age = json.get("age").asInt();
        if(json.get("number")!=null)
            this.number = json.get("number").asInt();
        if(json.get("pos")!=null)
            this.pos = json.get("pos").asText();
        if(json.get("grid")!=null)
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



}
