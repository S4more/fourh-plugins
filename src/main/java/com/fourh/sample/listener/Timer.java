package com.fourh.sample.listener;

import com.fourh.sample.SideBar;
import com.fourh.sample.StartMatch;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class Timer {
    JavaPlugin plugin;
    int time;
    int taskID;

    public Timer() {
        this.setTimer(0);
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTimer(int amount) {
        time = amount;
    }

    public void startTimer(JavaPlugin plugin, CommandSender sender) {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        taskID = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
            SideBar sb = new SideBar();
            StartMatch match = new StartMatch(sender);
            @Override
            public void run() {
                for(Player all : Bukkit.getServer().getOnlinePlayers()) {
                    sb.setScoreBoard(all);
                    sb.addTicks();
                }
                if (sb.getMinute() == 0 && sb.getSecond() == 0) {
                    match.start();
                }
                if (sb.getMinute() == 5 && sb.getSecond() == 0) {
                    match.shrinkBorder();
                }
            }
        }, 0L, 5L);
    }
    public void stopTimer() {
        SideBar sb = new SideBar();
        for (BukkitTask i:Bukkit.getScheduler().getPendingTasks()) {
            Bukkit.getScheduler().cancelTask(i.getTaskId());
        }
        for(Player all : Bukkit.getServer().getOnlinePlayers()) {
            sb.setScoreBoard(all);
        }
        new StartMatch();
    }
}
