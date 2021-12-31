package com.mini_project.foo1.Models.Primitives;

import com.fasterxml.jackson.databind.JsonNode;

public class Goal {
    private NumberStatistique against;
    private NumberStatistique forr;

    public Goal(NumberStatistique against, NumberStatistique forr) {
        this.against = against;
        this.forr = forr;
    }
    public Goal(JsonNode json) {
        if(json.get("against")!=null && json.get("against").get("total")!=null)
        this.against = new NumberStatistique(json.get("against").get("total"));
        if(json.get("for")!=null && json.get("against").get("total")!=null)
        this.forr = new NumberStatistique(json.get("for").get("total"));;
    }

    public NumberStatistique getAgainst() {
        return against;
    }

    public void setAgainst(NumberStatistique against) {
        this.against = against;
    }

    public NumberStatistique getForr() {
        return forr;
    }

    public void setForr(NumberStatistique forr) {
        this.forr = forr;
    }
}
