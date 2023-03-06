package org.supernederen.awesomelib.library.events.custom;

import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class PlayerHarvestCropEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final @Getter Player player;
    private final @Getter int drops;
    private final @Getter ItemStack[] items;
    private final @Getter Block crop;

    public PlayerHarvestCropEvent(Player player, int drops, ItemStack[] items, Block crop) {
        this.player = player;
        this.drops = drops;
        this.items = items;
        this.crop = crop;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
