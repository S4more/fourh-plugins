package com.fourh.sample;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import static org.bukkit.Bukkit.getLogger;

public class Main extends JavaPlugin {

    public final String PLUGIN_VERSION = "1.0-SNAPSHOT";
    @Override
    public void onEnable() {

        getLogger().info("Welcome to Rising Lava");
        getLogger().info("Version " + PLUGIN_VERSION);

        getCommand("remove_floor").setExecutor(new SamplePosCommand());

        getServer().getPluginManager().registerEvents(new JoinListenner(), this);

        getCommand("pos").setExecutor(new SamplePosCommand());
    }
    @Override
    public void onDisable() {
    }
}