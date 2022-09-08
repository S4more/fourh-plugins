package com.fourh.sample;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SamplePosCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        if (args.length != 4) {
            return false;
        }

        int targetX = Integer.parseInt(args[0]);
        int targetY = Integer.parseInt(args[1]);
        int targetZ = Integer.parseInt(args[2]);
        int width = Integer.parseInt(args[3]);

        World w = Bukkit.getWorld("world");
        Location underPlayer = new Location(w, targetX, targetY, targetZ);

        for (int x = 0; x < width; x++) {
            for (int z = 0; z < width; z++) {
                w.getBlockAt(
                        -width / 2 + underPlayer.getBlockX() + x,
                        underPlayer.getBlockY() ,
                        z + underPlayer.getBlockZ() - width / 2
                        ) .setType(Material.VOID_AIR);
            }
        }

        return true;
    }
}
