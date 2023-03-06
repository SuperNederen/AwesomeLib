package org.supernederen.awesomelib.library.events.custom.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.supernederen.awesomelib.library.events.Listener;
import org.supernederen.awesomelib.library.events.custom.PlayerHarvestCropEvent;

public class PlayerHarvestCropListener {

    public static @Listener void onPlayerHarvestCrop(@NotNull BlockBreakEvent event) {
        final Block block = event.getBlock();
        if (isCrop(block)) {
            Bukkit.getPluginManager().callEvent(new PlayerHarvestCropEvent
                    (
                            event.getPlayer(),
                            block.getDrops().size(),
                            block.getDrops().toArray(new ItemStack[0]),
                            block
                    )
            );
        }
    }

    private static boolean isCrop(@NotNull Block block) {
        switch (block.getType()) {
            case WHEAT:
            case CARROT:
            case POTATO:
            case COCOA:
            case SUGAR_CANE:
            case MELON:
            case PUMPKIN:
            case NETHER_WARTS:
                return true;
            default:
                return false;
        }
    }
}
