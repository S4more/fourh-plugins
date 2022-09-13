package com.fourh.sample.listener;

import com.fourh.sample.SideBar;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        SideBar sb = new SideBar();
        sb.setScoreBoard(e.getPlayer());
    }
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
//        SideBar sb = new SideBar();
//        sb.setScoreBoard(e.getPlayer());
    }
}
