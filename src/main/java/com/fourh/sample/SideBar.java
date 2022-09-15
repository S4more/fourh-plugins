package com.fourh.sample;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.bukkit.WorldBorder;

import javax.swing.border.Border;

public class SideBar {
    private int tick = 0;
    private int second = 0;
    private int minute = 0;

    public int getTick() {
        return this.tick;
    }
    public int getSecond() {
        return this.second;
    }
    public int getMinute() {
        return this.minute;
    }

    public void setScoreBoard(Player p) {

        // Get the player y level
        Location location = p.getLocation();
        int yLocation = (int) location.getY();
        ChatColor locationColor;

        // Color the y level
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

        // World border size
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        int borderSizeInt = (int) border.getSize();

        // Timer
        if (this.tick >= 20) {
            this.second += 1;
            this.tick = 0;
        }
        if (this.second >= 60) {
            this.minute += 1;
            this.second = 0;
        }

        // Team lives
        int lives = 3;

        // Create the Leaderboard and give all the value
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective obj = board.registerNewObjective("Rising Lava", "dummy", ChatColor.GOLD + "" + ChatColor.BOLD + "       Rising Lava       ");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score playerLevel = obj.getScore("Distance from the void : " + locationColor + yLocation);
        playerLevel.setScore(14);
        Score blank1 = obj.getScore("");
        blank1.setScore(13);
        Score borderSize = obj.getScore("Border " + borderSizeInt + " x " + borderSizeInt);
        borderSize.setScore(12);
        Score blank4 = obj.getScore(" ");
        blank4.setScore(11);

//        if (p.getTeam() == null) {
//            Score playerTeam = obj.getScore("No Team");
//            playerTeam.setScore(10);
//            Score teamLive = obj.getScore("        ");
//            teamLive.setScore(9);
//        } else {
            Score playerTeam = obj.getScore("Red Team");
            playerTeam.setScore(10);
            Score teamLive = obj.getScore(lives + " Lives left");
            teamLive.setScore(9);
//        }

        Score blank2 = obj.getScore("  ");
        blank2.setScore(8);

        Score timer = obj.getScore("Time : " + this.minute + ":" + this.second);
        timer.setScore(2);

        Score blank3 = obj.getScore("   ");
        blank3.setScore(1);
        Score pluginInfo = obj.getScore(ChatColor.GRAY + "Rising Sky " + Main.PLUGIN_VERSION);
        pluginInfo.setScore(0);

        // Give the player the Leaderboard
        p.setScoreboard(board);
    }

    public void addTicks() {
        this.tick += 5;
    }
}
