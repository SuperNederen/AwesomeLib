package org.supernederen.awesomelib.library.events.custom;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * PlayerKillEntityEvent is called when a player kills an entity.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.1.0
 */
public class PlayerKillEntityEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final @Getter Player killer;
    private final @Getter LivingEntity entity;
    private @Getter @Setter int exp;
    private @Getter @Setter List<ItemStack> drops;

    public PlayerKillEntityEvent(Player killer, LivingEntity entity, int exp, List<ItemStack> drops) {
        this.killer = killer;
        this.entity = entity;
        this.exp = exp;
        this.drops = drops;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
