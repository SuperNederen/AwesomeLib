package org.supernederen.awesomelib.library.events.custom;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class PlayerQuitWhileCraftingEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final @Getter Player player;
    private final @Getter int drops;
    private final @Getter ItemStack[] items;

    public PlayerQuitWhileCraftingEvent(Player player, CraftingInventory inventory, int drops, ItemStack[] items) {
        this.player = player;
        this.drops = drops;
        this.items = items;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
