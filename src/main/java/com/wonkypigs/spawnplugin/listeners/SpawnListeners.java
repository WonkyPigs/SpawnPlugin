package com.wonkypigs.spawnplugin.listeners;

import com.wonkypigs.spawnplugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final SpawnPlugin plugin;

    public SpawnListeners(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Location location = plugin.getConfig().getLocation("spawn");
        if (player.hasPlayedBefore()) {
            if (location != null) {
                player.teleport(location);
            }
            else {
                player.sendMessage(ChatColor.RED + "No spawn point location set.");
            }
        }
        else if (plugin.getConfig().getBoolean("spawnonjoin")) {
            if (location != null) {
                player.teleport(location);
            }
            else {
                player.sendMessage(ChatColor.RED + "No spawn point location set.");
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location location = plugin.getConfig().getLocation("spawn");
        if (plugin.getConfig().getBoolean("spawnondeath")) {
            if (location != null) {
                player.teleport(location);
            }
            else {
                player.sendMessage(ChatColor.RED + "No spawn point location set.");
            }
        }
    }
}