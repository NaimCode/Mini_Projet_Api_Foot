package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public class Country{
    private String name;
    private String code;
    private String flag;

    public Country(String name, String code, String flag) {
        this.name = name;
        this.code = code;
        this.flag = flag;
    }

    //A partir d'un json
    public Country(JsonNode json) {
       this.name=json.get("name").asText();
       this.code=json.get("code").asText();
       this.flag=json.get("flag").asText();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


}
