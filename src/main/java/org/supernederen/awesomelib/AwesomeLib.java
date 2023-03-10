package org.supernederen.awesomelib;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.supernederen.awesomelib.library.events.Listeners;
import org.supernederen.awesomelib.library.events.custom.listeners.PlayerQuitWhileCraftingListener;

import java.util.logging.Level;

/**
 * AwesomeLib is a library for Spigot plugins.
 * It provides a lot of useful methods and classes.
 * It is also a plugin, so you can use it as a dependency.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public final class AwesomeLib extends JavaPlugin {

    @Getter
    private static final String PREFIX = "§8[§6AwesomeLib§8]§r ";
    @Getter
    private String version;

    @Getter
    private static AwesomeLib instance;

    @Override
    public void onEnable() {
        instance = this;
        version = getDescription().getVersion();

        new BukkitRunnable() {
            public @Override void run() {
                new Listeners().register();
            }
        }.runTaskLater(this, 1);

        new AwesomeCommand(getInstance());
        Bukkit.getPluginManager().registerEvents(new PlayerQuitWhileCraftingListener() , getInstance());

        getLogger().log(Level.INFO, "AwesomeLib has been enabled!");
        getLogger().log(Level.INFO, "AwesomeLib version: " + getInstance().getVersion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().log(Level.INFO, "AwesomeLib has been disabled!");
        getLogger().log(Level.INFO, "AwesomeLib version: " + getInstance().getVersion());

        instance = null;
    }
}
