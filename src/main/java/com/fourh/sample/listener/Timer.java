package com.fourh.sample.listener;

import com.fourh.sample.SideBar;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Timer {
    JavaPlugin plugin;
    int time;
    int taskID;

    public Timer(JavaPlugin plugin) {
        this.setTimer(0);
        this.startTimer(plugin);
    }

    public void setTimer(int amount) {
        time = amount;
    }

    public void startTimer(JavaPlugin plugin) {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        taskID = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
            SideBar sb = new SideBar();
            @Override
            public void run() {
                for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                    sb.setScoreBoard(all);
                    sb.addTicks();
                }
            }
        }, 0L, 5L);
    }
    public void stopTimer() {
        Bukkit.getScheduler().cancelTask(taskID);
    }
}
