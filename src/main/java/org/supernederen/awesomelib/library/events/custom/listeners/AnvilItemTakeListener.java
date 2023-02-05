package org.supernederen.awesomelib.library.events.custom.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.supernederen.awesomelib.library.events.Listener;
import org.supernederen.awesomelib.library.events.custom.AnvilItemTakeEvent;

/**
 * A class that listens for the AnvilItemTakeEvent.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.1.0
 */
public class AnvilItemTakeListener {
    public static @Listener void onAnvilItemTake(InventoryClickEvent event) {
        if (event.getInventory() instanceof AnvilInventory) {
            handle(event);
        } else if (event.getClickedInventory() instanceof AnvilInventory) {
            handle(event);
        } else if (event.getWhoClicked().getOpenInventory().getTopInventory() instanceof AnvilInventory) {
            handle(event);
        }
    }

    private static void handle(InventoryClickEvent event) {
        AnvilInventory inventory = (AnvilInventory) event.getInventory();
        if (event.getSlot() == 2 && event.getSlotType() == InventoryType.SlotType.RESULT) {
            if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {
                Bukkit.getPluginManager().callEvent(new AnvilItemTakeEvent(Bukkit.getPlayer(event.getWhoClicked().getUniqueId()), event.getCurrentItem(), inventory));
            }
        }
    }
}
