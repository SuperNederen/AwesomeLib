package org.supernederen.awesomelib;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class AwesomeLib extends JavaPlugin {

    @Getter
    private static AwesomeLib instance;

    @Override
    public void onEnable() {
        instance = this;

        getLogger().log(Level.INFO, "AwesomeLib has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().log(Level.INFO, "AwesomeLib has been disabled!");
    }
}
