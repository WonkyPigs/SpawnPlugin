package com.wonkypigs.spawnplugin.commands;

import com.wonkypigs.spawnplugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("spawnplugin.spawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location location = plugin.getConfig().getLocation("spawn");
                if (location != null) {
                    player.teleport(location);
                    player.sendMessage(ChatColor.GREEN + "You have been teleported to the spawn point.");
                } else {
                    player.sendMessage(ChatColor.RED + "There is no spawn point set. Use /setspawn to set one.");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player to use this command.");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
        }
        return true;
    }
}
