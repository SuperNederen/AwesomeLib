package org.supernederen.awesomelib;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.supernederen.awesomelib.library.utils.ColorUtils;

public class AwesomeCommand implements CommandExecutor {

    private final AwesomeLib plugin;

    public AwesomeCommand(AwesomeLib plugin) {
        this.plugin = plugin;
        Bukkit.getPluginCommand("awesome").setExecutor(this);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ColorUtils.colorize("&6AwesomeLib version &bv" + plugin.getVERSION()));
        return false;
    }

}
