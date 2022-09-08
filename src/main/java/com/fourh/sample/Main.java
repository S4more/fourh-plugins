package com.fourh.sample;

import org.bukkit.event.EventHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {

        PluginManager pm = getServer().getPluginManager();

        getServer().getPluginManager().registerEvents(new JoinListenner(), this);

        getCommand("pos").setExecutor(new SamplePosCommand());
    }
    @Override
    public void onDisable() {
    }
}