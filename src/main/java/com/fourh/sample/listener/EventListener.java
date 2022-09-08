package com.fourh.sample.listener;

import com.fourh.sample.SideBar;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getLogger;

public class EventListener implements Listener {
    JavaPlugin plugin;

    public EventListener(JavaPlugin javaPlugin) {
        super();
        this.plugin = javaPlugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        SideBar sb = new SideBar();
        sb.setScoreBoard(e.getPlayer());

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable()
        {
            @Override
            public void run()
            {
                sb.updateScoreBoard(e.getPlayer());
            }
        }, 10, 10);
    }
}
