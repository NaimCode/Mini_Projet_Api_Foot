package com.mini_project.foo1.Models.Primitives;

import java.util.List;

public class PlayerPagination {
    private List<Player> players;
    private int page;

    public PlayerPagination(List<Player> players, int page) {
        this.players = players;
        this.page = page;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
