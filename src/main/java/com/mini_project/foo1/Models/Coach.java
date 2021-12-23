package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Primitives.Career;
import com.mini_project.foo1.Models.Primitives.Team_v1;

import java.util.ArrayList;
import java.util.List;

//"id":40
//        "name":"T. Tuchel"
//        "firstname":"Thomas"
//        "lastname":"Tuchel"
//        "age":48
//        "birth":{...}3 items
//        "nationality":"Germany"
//        "height":"192 cm"
//"date":"1973-08-29"
//"place":"Krumbach"
//"country":"Germany"
//        "weight":"85 kg"
//        "photo":"https://media.api-sports.io/football/coachs/40.png"
public class Coach {
    private int id;
    private String name;
    private String firstName;
    private String lastName;
    private int age;
    //Need translation
    private String nationality;
    private String height;
    private String weight;
    private String photo;
    private String dateNaissance;
    private String lieuNaissance;
   private Team_v1 team;
   private List<Career> careers;

    public Coach(int id, String name,
                 String firstName, String lastName,
                 int age, String nationality,
                 String height, String weight,
                 String photo, String dateNaissance,
                 String lieuNaissance, Team_v1 team,
                 List<Career> careers) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.photo = photo;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.team = team;
        this.careers = careers;
    }
    public Coach(JsonNode json) {
        this.id = json.get("id").asInt();
        if(json.get("name")!=null)
        this.name = json.get("name").asText();
        if(json.get("firstname")!=null)
        this.firstName = json.get("firstname").asText();
        if(json.get("lastname")!=null)
        this.lastName = json.get("lastname").asText();
        if(json.get("age")!=null)
        this.age = json.get("age").asInt();
        if(json.get("nationality")!=null)
        this.nationality = json.get("nationality").asText();
        if(json.get("height")!=null)
        this.height = json.get("height").asText();
        if(json.get("weight")!=null)
        this.weight = json.get("weight").asText();
        if(json.get("photo")!=null)
        this.photo = json.get("photo").asText();
        if(json.get("birth")!=null) {
            if (json.get("birth").get("date") != null)
                this.dateNaissance = json.get("birth").get("date").asText();
            if (json.get("birth").get("place") != null)
                this.lieuNaissance = json.get("birth").get("place").asText();
        }
        if(json.get("team")!=null)
        this.team = new Team_v1(json.get("team"));
        if(json.get("career")!=null){
        List<Career> careers=new ArrayList<>();
        json.get("career").elements().forEachRemaining(jsonNode -> careers.add(new Career(jsonNode)));
        this.careers = careers;}
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Team_v1 getTeam() {
        return team;
    }

    public void setTeam(Team_v1 team) {
        this.team = team;
    }

    public List<Career> getCareers() {
        return careers;
    }

    public void setCareers(List<Career> careers) {
        this.careers = careers;
    }
}
