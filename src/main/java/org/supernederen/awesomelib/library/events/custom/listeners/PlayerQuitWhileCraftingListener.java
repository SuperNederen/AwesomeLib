package org.supernederen.awesomelib.library.events.custom.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.supernederen.awesomelib.library.events.custom.PlayerQuitWhileCraftingEvent;

/**
 * A class that fires the PlayerQuitWhileCraftingEvent.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.2.0
 */
public class PlayerQuitWhileCraftingListener implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerLeaveWhileCrafting(@NotNull PlayerQuitEvent event) {
        final Player player = event.getPlayer();
        final CraftingInventory inventory = (CraftingInventory) player.getOpenInventory().getTopInventory();
        if (inventory == null){
            return;
        }
        if (inventory.getMatrix().length != 5) {
            return;
        }
        handleLeave(player, inventory);
    }
    private void handleLeave(Player thePlayer, CraftingInventory inventory) {
        if (isCrafting(inventory)) {
            Bukkit.getPluginManager().callEvent(
                    new PlayerQuitWhileCraftingEvent
                            (thePlayer, inventory, inventory.getResult().getAmount(), getCraftingItems(inventory)));
        }
    }
    private boolean isCrafting(@NotNull CraftingInventory inventory) {
        for (ItemStack item : inventory.getMatrix()) {
            if (item != null) {
                return true;
            }
        }
        return false;
    }
    private ItemStack @NotNull [] getCraftingItems(@NotNull CraftingInventory inventory) {
        ItemStack[] items = new ItemStack[inventory.getMatrix().length - 1];
        int i = 0;
        for (ItemStack item : inventory.getMatrix()) {
            if (item != null) {
                items[i] = item;
            }
            i++;
        }
        return items;
    }
}