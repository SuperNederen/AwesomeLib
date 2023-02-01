package org.supernederen.awesomelib;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class AwesomeLib extends JavaPlugin {

    @Getter
    private static AwesomeLib instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
