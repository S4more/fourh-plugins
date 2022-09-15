package com.fourh.sample;

import com.fourh.sample.listener.Timer;
import org.apache.logging.log4j.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class MainCommand implements CommandExecutor {
    private JavaPlugin plugin;
    public MainCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Timer time = new Timer();
        if (args[0].equals("start")) {
            time.startTimer(this.plugin, sender);
            this.plugin.getServer( ).broadcastMessage("Game started.");
        } else if (args[0].equals("team")) {
            if (args[1].equals("add")) {
                this.plugin.getServer( ).broadcastMessage("You created the team.");
            } else if (args[1].equals("remove")) {
                this.plugin.getServer( ).broadcastMessage("You removed the team.");
            } else if (args[1].equals("join")) {
                this.plugin.getServer( ).broadcastMessage("You joined the team.");
            } else if (args[1].equals("leave")) {
                this.plugin.getServer( ).broadcastMessage("You left the team.");
            }
        } else if (args[0].equals("stop")) {
            time.stopTimer();
            this.plugin.getServer( ).broadcastMessage("Game stopped.");
        } else {
            this.plugin.getServer( ).broadcastMessage("Not an input");
        }
        return true;
    }
}
