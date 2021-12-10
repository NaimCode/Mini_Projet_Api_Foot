package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Venue {
    private int id;
    private String name;
    private String address;
    private int capacity;
    private String city;
    private String image;
    private String surface;

    public Venue(int id, String name, String address, int capacity, String city, String image, String surface) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.city = city;
        this.image = image;
        this.surface = surface;
    }

    public Venue(JsonNode json) {
        this.id = json.get("id").asInt();
        this.name = json.get("name").asText();
        this.address = json.get("address").asText();
        this.capacity = json.get("capacity").asInt();
        this.city = json.get("city").asText();
        this.image = json.get("image").asText();
        this.surface = json.get("surface").asText();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }
}
