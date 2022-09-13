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

        Score playerTeam = obj.getScore("Red Team");
        playerTeam.setScore(10);
        Score teamLive = obj.getScore("3 Lives left");
        teamLive.setScore(9);
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
    public static void editScoreboard(Objective obj, int line, String text) {
        Score score = obj.getScore(Bukkit.getServer().getOfflinePlayer(text));

        score.setScore(line);
    }

    public int getSecond() {
        return second;
    }
    public int getMinute() {
        return minute;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void addTicks() {
        this.tick += 5;
    }
}
