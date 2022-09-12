package com.fourh.sample;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Team {
    public String color;
    public String name;
    public Player[] players;
    public int lives;

    public Team(String name, String color){
        this.color = color;
        this.name = name;
        this.players = new Player[4];
        this.lives = 3;
    }

    public void add(Player usr){
        for (int x = 0 ; x < this.players.length; x++){
            if ( players[x] == null){
                this.players[x] = usr;
            }
        }
    }

    @Override
    public String toString() {
        String team = null;
        for (Player i : players){
            if (i != null){
                team = team + ", " + i.getName();
            }
        }
        return team;
    }
}
