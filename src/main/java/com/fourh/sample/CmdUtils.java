package com.fourh.sample;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CmdUtils {
	public static Location parseLocation(CommandSender sender, String x, String y, String z) {
		if (sender instanceof Player) {
			Location senderLocation = ((Player)sender).getLocation();
			
			double targetX = x.equals("~") ? 
				senderLocation.getX() : 
				Float.parseFloat(x);

			double targetY = y.equals("~") ? 
				senderLocation.getY() : 
				Float.parseFloat(y);

			double targetZ = z.equals("~") ? 
				senderLocation.getZ() : 
				Float.parseFloat(z);

			return new Location(senderLocation.getWorld(), targetX, targetY, targetZ);
		} else {
			return new Location(
				sender.getServer().getWorld("world"),
				Integer.parseInt(x),
				Integer.parseInt(y),
				Integer.parseInt(z)
			);
		}
	}
}
