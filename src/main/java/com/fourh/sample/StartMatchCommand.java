package com.fourh.sample;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class StartMatchCommand implements CommandExecutor {
    // Args : 
    // 		size, 
    // 		speed, 
    // 		grace period, 
    // 		event interval
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) return false;
        ConsoleCommandSender console = sender.getServer().getConsoleSender();

        String centerBorder = "worldborder center 0 0";
        String setStart = "worldborder set 200";
        String setEnd = "worldborder set 100 600";

        Bukkit.dispatchCommand(console, centerBorder);
        Bukkit.dispatchCommand(console, setStart);
        Bukkit.dispatchCommand(console, setEnd);

        return true;
    }
}
