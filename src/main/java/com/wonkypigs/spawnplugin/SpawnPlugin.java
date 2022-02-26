package com.wonkypigs.spawnplugin;

import com.wonkypigs.spawnplugin.commands.SetSpawnCommand;
import com.wonkypigs.spawnplugin.commands.SpawnCommand;
import com.wonkypigs.spawnplugin.listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("SpawnPlugin enabled");

        // config.yml
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("SpawnPlugin disabled");
    }
}
