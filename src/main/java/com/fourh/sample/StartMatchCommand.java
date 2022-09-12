package com.fourh.sample;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;


public class StartMatchCommand implements CommandExecutor {
    // Args : 
    //      x  y  z
    //      size, 
    // 		speed, 
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Location targetLocation = CmdUtils.parseLocation(sender, args[0], args[1], args[2]);
        
        int size = Integer.parseInt(args[3]);
        int speed = Integer.parseInt(args[4]);

        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setCenter(targetLocation);
        border.setSize(size);
        border.setSize(size/2, speed);
        return true;
    }
}
