package com.fourh.sample;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {

        PluginManager pm = getServer().getPluginManager();

        getCommand("pos").setExecutor(new SamplePosCommand());
    }
    @Override
    public void onDisable() {
    }
}