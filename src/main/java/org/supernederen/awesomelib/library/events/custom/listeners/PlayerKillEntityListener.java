package org.supernederen.awesomelib.library.events.custom.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.supernederen.awesomelib.library.events.Listener;
import org.supernederen.awesomelib.library.events.custom.PlayerKillEntityEvent;

/**
 * A class that fires the {@link PlayerKillEntityEvent}.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.1.0
 */
public class PlayerKillEntityListener {

    public static @Listener void onPlayerKillEntity(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        Player player = entity.getKiller();
        if (player != null) {
            Bukkit.getPluginManager().callEvent(new PlayerKillEntityEvent(player, entity, event.getDroppedExp(), event.getDrops()));
        }
    }
}
