package com.mini_project.foo1.Models;

import com.mini_project.foo1.Models.Primitives.FixtureEvent;
import com.mini_project.foo1.Models.Primitives.FixtureLineup;
import com.mini_project.foo1.Models.Primitives.FixtureStatistic_v1;
import com.mini_project.foo1.Models.Primitives.Venue;

import java.util.ArrayList;
import java.util.List;

public class FixtureStatistic {
    private List<FixtureStatistic_v1> fixtureStatistic_v1s;
    private Venue venue;
    private FixtureLineup fixtureLineup;
    private FixtureEvent fixtureEvent;

    public FixtureStatistic(List<FixtureStatistic_v1> fixtureStatistic_v1s, Venue venue, FixtureLineup fixtureLineup, FixtureEvent fixtureEvent) {
        this.fixtureStatistic_v1s = fixtureStatistic_v1s;
        this.venue = venue;
        this.fixtureLineup = fixtureLineup;
        this.fixtureEvent = fixtureEvent;
    }

    public List<FixtureStatistic_v1> getFixtureStatistic_v1s() {
        return fixtureStatistic_v1s;
    }

    public void setFixtureStatistic_v1s(List<FixtureStatistic_v1> fixtureStatistic_v1s) {
        this.fixtureStatistic_v1s = fixtureStatistic_v1s;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public FixtureLineup getFixtureLineup() {
        return fixtureLineup;
    }

    public void setFixtureLineup(FixtureLineup fixtureLineup) {
        this.fixtureLineup = fixtureLineup;
    }

    public FixtureEvent getFixtureEvent() {
        return fixtureEvent;
    }

    public void setFixtureEvent(FixtureEvent fixtureEvent) {
        this.fixtureEvent = fixtureEvent;
    }
}
