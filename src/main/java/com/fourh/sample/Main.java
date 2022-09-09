package com.fourh.sample;

import com.fourh.sample.listener.EventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static final String PLUGIN_VERSION = "1.0-SNAPSHOT";
    @Override
    public void onEnable() {

        getLogger().info("Welcome to Rising Lava");
        getLogger().info("Version " + PLUGIN_VERSION);

        getCommand("remove_floor").setExecutor(new RemoveFloorCommand());
        getCommand("start_match").setExecutor(new StartMatchCommand());

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }
    @Override
    public void onDisable() {
    }
}