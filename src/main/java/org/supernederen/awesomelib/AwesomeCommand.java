package org.supernederen.awesomelib;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.supernederen.awesomelib.library.utils.ColorUtils;

/**
 * This is the only command class for AwesomeLib.
 * It is used to register the command and to execute it.
 * The command provides the version of AwesomeLib.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public class AwesomeCommand implements CommandExecutor {

    private final AwesomeLib plugin;

    public AwesomeCommand(AwesomeLib plugin) {
        this.plugin = plugin;
        Bukkit.getPluginCommand("awesomelib").setExecutor(this);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ColorUtils.colorize("&6AwesomeLib version &bv" + plugin.getVERSION()));
        return false;
    }

}
