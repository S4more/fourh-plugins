package com.fourh.sample;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.Bukkit.getLogger;

public class JoinListenner implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        SideBar sb = new SideBar();
        sb.setScoreBoard(e.getPlayer());

        getLogger().info("HIII");
    }
}
