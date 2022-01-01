package com.mini_project.foo1.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.mini_project.foo1.Models.Primitives.Player;
import com.mini_project.foo1.Models.Primitives.StatisticPlayer;

import java.util.ArrayList;
import java.util.List;

public class PlayerStatistic {
    private Player player;
    List<StatisticPlayer> statisticPlayers;

    public PlayerStatistic(Player player, List<StatisticPlayer> statisticPlayers) {
        this.player = player;
        this.statisticPlayers = statisticPlayers;
    }
    public PlayerStatistic(JsonNode json) {
        this.player = new Player(json.get("player"));
        List<StatisticPlayer> statisticPlayers=new ArrayList<>();
        json.get("statistics").elements().forEachRemaining(jsonNode -> statisticPlayers.add(new StatisticPlayer(jsonNode)));
        this.statisticPlayers = statisticPlayers;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<StatisticPlayer> getStatisticPlayers() {
        return statisticPlayers;
    }

    public void setStatisticPlayers(List<StatisticPlayer> statisticPlayers) {
        this.statisticPlayers = statisticPlayers;
    }
}
