package com.fourh.sample;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class SideBar {
    public void setScoreBoard(Player p) {

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective obj = board.registerNewObjective("Rising Lava", "dummy", ChatColor.GOLD + "   Rising Lava   ");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score hi = obj.getScore(ChatColor.YELLOW + "HI!!!");
        hi.setScore(1);
        Score bad = obj.getScore(ChatColor.RED + "UR BAD");
        bad.setScore(0);
        p.setScoreboard(board);
    }
    public void updateScoreBoard(Player p) {

        Scoreboard board = p.getScoreboard();
    }
}
