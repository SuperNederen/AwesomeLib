package org.supernederen.awesomelib.library.events.custom;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

/**
 * AnvilItemTakeEvent is called when a player takes an item from an anvil.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.1.0
 */
public class AnvilItemTakeEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final @Getter Player player;
    private final @Getter ItemStack item;
    private final @Getter AnvilInventory inventory;

    public AnvilItemTakeEvent(Player player, ItemStack item, AnvilInventory inventory) {
        this.player = player;
        this.item = item;
        this.inventory = inventory;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
