package org.supernederen.awesomelib.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * A command that can be executed by a {@link CommandSender}.
 * Acts as a base class for {@link SubCommand}s, and is used for
 * making more complex commands.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public abstract class Command {
    private final JavaPlugin plugin;

    public Command(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Check if the {@link CommandSender} is a {@link Player}
     *
     * @param sender The {@link CommandSender} to check
     *
     * @return true if the sender is a player, false otherwise
     * (always sends a message to the sender if false)
     */
    protected boolean isPlayer(CommandSender sender) {
        return isPlayer(sender, true);
    }

    /**
     * Check if the {@link CommandSender} is a {@link Player}
     *
     * @param sender The {@link CommandSender} to check
     * @param notify Whether to send a message to the sender if false
     *
     * @return true if the sender is a player, false otherwise
     */
    protected boolean isPlayer(CommandSender sender, boolean notify) {
        if (sender instanceof Player) return true;
        if (notify) sender.sendMessage("Du skal være en spiller for at bruge denne kommando.");
        return false;
    }

    /**
     * Check if the {@link CommandSender} has the specified permission
     *
     * @param sender The {@link CommandSender} to check
     * @param permission The permission to check
     *
     * @return true if the sender has the permission, false otherwise
     * (always sends a message to the sender if false)
     */
    protected boolean hasPermission(CommandSender sender, String permission) {
        return hasPermission(sender, permission, true);
    }

    /**
     * Check if the {@link CommandSender} has the specified permission
     *
     * @param sender The {@link CommandSender} to check
     * @param permission The permission to check
     * @param notify Whether to send a message to the sender if false
     *
     * @return true if the sender has the permission, false otherwise
     */
    protected boolean hasPermission(CommandSender sender, String permission, boolean notify) {
        if (sender.hasPermission(permission)) return true;
        if (notify) sender.sendMessage("Du har ikke adgang til denne kommando.");
        return false;
    }

    /**
     * Get the plugin
     *
     * @return The plugin
     */
    protected JavaPlugin getPlugin() {
        return plugin;
    }
}
