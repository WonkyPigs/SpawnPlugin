package com.wonkypigs.spawnplugin.commands;

import com.wonkypigs.spawnplugin.SpawnPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SetSpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("spawnplugin.setspawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                Location location = player.getLocation();
                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();
                player.sendMessage(ChatColor.GREEN + "Spawn has to been set at " + ChatColor.GRAY + "(" + location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ() + ")");
            } else {
                sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
        }
        return true;
    }
}
