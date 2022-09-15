package com.fourh.sample;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldBorder;
import org.bukkit.command.CommandSender;

import java.io.Console;

public class StartMatch {
    private Location targetLocation;
    public StartMatch(CommandSender sender) {
        this.targetLocation = CmdUtils.parseLocation(sender, "~", "~", "~");
    }
    public StartMatch() {
        stop();
    }
    public void start() {
        int size = 200;

        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setCenter(this.targetLocation);
        border.setSize(size);
    }
    public void shrinkBorder() {
        int size = 200;
        int speed = 60;

        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setCenter(this.targetLocation);
        border.setSize(size/2, speed);
    }
    public void stop() {
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.reset();
    }
}
