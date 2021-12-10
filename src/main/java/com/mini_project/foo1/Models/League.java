package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Primitives.League_v1;
import com.mini_project.foo1.Models.Primitives.Season;

import java.util.ArrayList;
import java.util.List;

public class League {
    private League_v1 league_v1;
    private Country country;
    private List<Season> seasons;

    public League(League_v1 league_v1, Country country,List<Season> seasons) {
        this.league_v1 = league_v1;
        this.country = country;
        this.seasons=seasons;
    }

    //
    public League(JsonNode json) {
        this.league_v1 = new League_v1(json.get("league"));
        this.country = new Country(json.get("country"));
        List<Season> seasons= new ArrayList<>();
                json.get("seasons").elements().forEachRemaining(s->seasons.add(new Season(s)));
        this.seasons =seasons;

    }

    public League_v1 getLeague_v1() {
        return league_v1;
    }

    public void setLeague_v1(League_v1 league_v1) {
        this.league_v1 = league_v1;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }
}
