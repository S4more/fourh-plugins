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
        ChatColor locationColor;

        if (yLocation > 20) {
            locationColor = ChatColor.WHITE;
        } else if (yLocation > 10) {
            locationColor = ChatColor.YELLOW;
        } else if (yLocation > 5) {
            locationColor = ChatColor.GOLD;
        } else if (yLocation > 1) {
            locationColor = ChatColor.RED;
        } else {
            locationColor = ChatColor.DARK_RED;
        }

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective obj = board.registerNewObjective("Rising Lava", "dummy", ChatColor.GOLD + "" + ChatColor.BOLD + "       Rising Lava       ");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score playerLevel = obj.getScore("Distance from the void : " + locationColor + yLocation + "");
        playerLevel.setScore(14);
        Score blank1 = obj.getScore(ChatColor.BLACK + "");
        blank1.setScore(13);

        Score playerTeam = obj.getScore("Red Team");
        playerTeam.setScore(12);
        Score teamLive = obj.getScore("3 Lives left");
        teamLive.setScore(11);
        Score blank2 = obj.getScore("");
        blank2.setScore(10);

        Score timer = obj.getScore("Time : PAUSE");
        timer.setScore(2);

        Score blank3 = obj.getScore(" ");
        blank3.setScore(1);
        Score pluginInfo = obj.getScore(ChatColor.GRAY + "Rising Lava " + Main.PLUGIN_VERSION);
        pluginInfo.setScore(0);

        p.setScoreboard(board);
    }
    public void updateScoreBoard(Player p) {
        Scoreboard board = p.getScoreboard();
    }
}
