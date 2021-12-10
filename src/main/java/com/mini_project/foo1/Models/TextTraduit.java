package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;

public class TextTraduit {
    private String text;
    private String from;
    private String to;

    public TextTraduit(String text, String from, String to) {
        this.text = text;
        this.from = from;
        this.to = to;
    }
    //Constructeur a partir d'un noeud de json
    public TextTraduit(JsonNode json){
        this.text = json.get("translatedText").asText();
        this.from = json.get("fromLang").asText();
        this.to = json.get("to").asText();
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
