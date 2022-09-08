package com.fourh.sample;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class SideBar {
    public void setScoreBoard(Player p) {

        Location location = p.getLocation();
        int yLocation = (int) location.getY();
        int sbIndex = 15;
        int numTeams = 2;

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective obj = board.registerNewObjective("Rising Lava", "dummy", ChatColor.GOLD + "       Rising Lava       ");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score yLevel = obj.getScore("Y level: " + yLocation);
        yLevel.setScore(sbIndex);
        sbIndex--;
        Score blank1 = obj.getScore("");
        blank1.setScore(sbIndex);
        sbIndex--;
        Score teams = obj.getScore(ChatColor.WHITE + "Teams");
        teams.setScore(sbIndex);
        sbIndex--;

        p.setScoreboard(board);
    }
    public void updateScoreBoard(Player p) {
        Scoreboard board = p.getScoreboard();
    }
}
