package com.mini_project.foo1.Models;

import com.mini_project.foo1.Models.Primitives.FixtureEvent;
import com.mini_project.foo1.Models.Primitives.FixtureLineup;
import com.mini_project.foo1.Models.Primitives.FixtureStatistic_v1;
import com.mini_project.foo1.Models.Primitives.Venue;

import java.util.List;

public class FixtureStatistic {
    private List<FixtureStatistic_v1> fixtureStatistic_v1s;
    private Venue venue=null;
    private List<FixtureLineup> fixtureLineups;
    private List<FixtureEvent> fixtureEvents;

    public FixtureStatistic(List<FixtureStatistic_v1> fixtureStatistic_v1s, List<FixtureLineup> fixtureLineups, List<FixtureEvent> fixtureEvents) {
        this.fixtureStatistic_v1s = fixtureStatistic_v1s;

        this.fixtureLineups = fixtureLineups;
        this.fixtureEvents = fixtureEvents;
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

    public List<FixtureLineup> getFixtureLineups() {
        return fixtureLineups;
    }

    public void setFixtureLineups(List<FixtureLineup> fixtureLineups) {
        this.fixtureLineups = fixtureLineups;
    }

    public List<FixtureEvent> getFixtureEvents() {
        return fixtureEvents;
    }

    public void setFixtureEvents(List<FixtureEvent> fixtureEvents) {
        this.fixtureEvents = fixtureEvents;
    }
}
