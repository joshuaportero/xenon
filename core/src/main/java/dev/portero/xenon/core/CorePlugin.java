package dev.portero.xenon.core;

import org.bukkit.plugin.java.JavaPlugin;

public class CorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Xenon Core has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Xenon Core has been disabled!");
    }
}