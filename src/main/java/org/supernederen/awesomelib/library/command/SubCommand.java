package org.supernederen.awesomelib.library.command;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.supernederen.awesomelib.library.command.Command;

/**
 * A sub command of a command.
 * It's use case os to be used in a {@link Command} class.
 * It's used for making more complex commands.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public abstract class SubCommand extends Command {
    private final String permission;
    private final String usage;
    private final String description;
    private final String[] aliases;

    public SubCommand(JavaPlugin plugin, String description, String usage, String permission, String... aliases) {
        super(plugin);

        this.description = description;
        this.usage = usage;
        this.permission = permission;
        this.aliases = aliases;
    }

    /**
     * The method that is called when the command is executed.
     *
     * @param sender The sender of the command.
     * @param args The arguments of the command.
     *
     * @return Whether the command was executed successfully.
     */
    public abstract boolean execute(CommandSender sender, String[] args);

    /**
     * Get the permission of the command.
     *
     * @return The permission of the sub command.
     */
    public String getPermission() {
        return this.permission;
    }

    /**
     * Get the usage of the command.
     *
     * @return The usage of the sub command.
     */
    public String getUsage(String label) {
        return "/" + label + " " + this.usage;
    }

    /**
     * Get the description of the command.
     *
     * @return The description of the sub command.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the aliases of the command.
     *
     * @return The aliases of the sub command.
     */
    public String[] getAliases() {
        return this.aliases;
    }
}
