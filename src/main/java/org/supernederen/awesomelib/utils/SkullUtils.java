package org.supernederen.awesomelib.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Base64;
import java.util.UUID;

/**
 * Utility class for skulls. This class is used to create skull items with a
 * specific owner, URL or base64 encoding. It also contains methods to set the owner of a skull block.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public class SkullUtils {

    private SkullUtils() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }
    /**
     * @deprecated Use {@link #itemFromUuid(UUID)} instead.
     */
    @Deprecated
    public static ItemStack itemFromName(String paramString) {
        ItemStack itemStack = getPlayerSkullItem();
        return itemWithName(itemStack, paramString);
    }

    /**
     * @deprecated Use {@link #itemWithUuid(ItemStack, UUID)} instead.
     */
    @Deprecated
    public static ItemStack itemWithName(ItemStack paramItemStack, String paramString) {
        notNull(paramItemStack, "item");
        notNull(paramString, "name");
        return Bukkit.getUnsafe().modifyItemStack(paramItemStack, "{SkullOwner:\"" + paramString + "\"}");
    }

    /**
     * Returns a player skull item with the specified owner.
     *
     * @param paramUUID The owner of the skull.
     * @return The player skull item.
     */
    public static ItemStack itemFromUuid(UUID paramUUID) {
        ItemStack itemStack = getPlayerSkullItem();
        return itemWithUuid(itemStack, paramUUID);
    }

    /**
     * Sets the owner of the specified skull item.
     *
     * @param paramItemStack The skull item.
     * @param paramUUID The owner of the skull.
     * @return The skull item.
     */
    public static ItemStack itemWithUuid(ItemStack paramItemStack, UUID paramUUID) {
        notNull(paramItemStack, "item");
        notNull(paramUUID, "id");
        SkullMeta skullMeta = (SkullMeta)paramItemStack.getItemMeta();
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(paramUUID);
        if (offlinePlayer != null) {
            skullMeta.setOwner(offlinePlayer.getName());
        } else {
            return getPlayerSkullItem();
        }
        paramItemStack.setItemMeta((ItemMeta)skullMeta);
        return paramItemStack;
    }

    /**
     * Returns a player skull item with the specified owner.
     *
     * @param paramUUID The owner of the skull.
     * @return The player skull item.
     */
    public static ItemStack convertToSkull(ItemStack paramItemStack, UUID paramUUID) {
        notNull(paramItemStack, "item");
        notNull(paramUUID, "id");
        SkullMeta skullMeta = (SkullMeta)paramItemStack.getItemMeta();
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(paramUUID);
        if (offlinePlayer != null) {
            skullMeta.setOwner(offlinePlayer.getName());
        } else {
            return paramItemStack;
        }
        paramItemStack.setItemMeta((ItemMeta)skullMeta);
        return paramItemStack;
    }

    /**
     * Returns a player skull item from the specified URL.
     *
     * @param paramString The URL of the skull texture.
     * @return The player skull item.
     */
    public static ItemStack itemFromUrl(String paramString) {
        ItemStack itemStack = getPlayerSkullItem();
        return itemWithUrl(itemStack, paramString);
    }

    /**
     * Sets the owner of the specified skull item.
     *
     * @param paramItemStack The skull item.
     * @param paramString The URL of the skull texture.
     * @return The skull item.
     */
    public static ItemStack itemWithUrl(ItemStack paramItemStack, String paramString) {
        notNull(paramItemStack, "item");
        notNull(paramString, "url");
        return itemWithBase64(paramItemStack, urlToBase64(paramString));
    }

    /**
     * Returns a player skull item from the specified base64 string.
     *
     * @param paramString The base64 string of the skull texture.
     * @return The player skull item.
     */
    public static ItemStack itemFromBase64(String paramString) {
        ItemStack itemStack = getPlayerSkullItem();
        return itemWithBase64(itemStack, paramString);
    }

    /**
     * Sets the owner of the specified skull item.
     *
     * @param paramItemStack The skull item.
     * @param paramString The base64 string of the skull texture.
     * @return The skull item.
     */
    public static ItemStack itemWithBase64(ItemStack paramItemStack, String paramString) {
        notNull(paramItemStack, "item");
        notNull(paramString, "base64");
        UUID uUID = new UUID(paramString.hashCode(), paramString.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(paramItemStack, "{SkullOwner:{Id:\"" + uUID + "\",Properties:{textures:[{Value:\"" + paramString + "\"}]}}}");
    }

    /**
     * @deprecated Use {@link #blockWithUuid(Block, UUID)} instead.
     */
    @Deprecated
    public static void blockWithName(Block paramBlock, String paramString) {
        notNull(paramBlock, "block");
        notNull(paramString, "name");
        setBlockType(paramBlock);
        ((Skull)paramBlock.getState()).setOwner(paramString);
    }

    /**
     * Sets the owner of the specified skull block.
     *
     * @param paramBlock The skull block.
     * @param paramUUID The owner of the skull.
     */
    public static void blockWithUuid(Block paramBlock, UUID paramUUID) {
        notNull(paramBlock, "block");
        notNull(paramUUID, "id");
        setBlockType(paramBlock);
        ((Skull)paramBlock.getState()).setOwner(Bukkit.getOfflinePlayer(paramUUID).getName());
    }

    /**
     * Sets the owner of the specified skull block.
     *
     * @param paramBlock The skull block.
     * @param paramString The URL of the skull texture.
     */
    public static void blockWithUrl(Block paramBlock, String paramString) {
        notNull(paramBlock, "block");
        notNull(paramString, "url");
        blockWithBase64(paramBlock, urlToBase64(paramString));
    }

    /**
     * Sets the owner of the specified skull block.
     *
     * @param paramBlock The skull block.
     * @param paramString The base64 string of the skull texture.
     */
    public static void blockWithBase64(Block paramBlock, String paramString) {
        notNull(paramBlock, "block");
        notNull(paramString, "base64");
        UUID uUID = new UUID(paramString.hashCode(), paramString.hashCode());
        String str = String.format("%d %d %d %s", new Object[] { Integer.valueOf(paramBlock.getX()),
                Integer.valueOf(paramBlock.getY()),
                Integer.valueOf(paramBlock.getZ()), "{Owner:{Id:\"" + uUID + "\",Properties:{textures:[{Value:\"" + paramString + "\"}]}}}" });
    }

    /**
     * Returns a player skull item.
     *
     * @return The player skull item.
     */
    public static ItemStack getPlayerSkullItem() {
        return new ItemStack(Material.valueOf("SKULL_ITEM"), 1, (short)3);
    }

    /**
     * Sets the type of the specified block to a player skull.
     *
     * @param paramBlock The block.
     */
    private static void setBlockType(Block paramBlock) {
        try {
            paramBlock.setType(Material.valueOf("PLAYER_HEAD"), false);
        } catch (IllegalArgumentException illegalArgumentException) {
            paramBlock.setType(Material.valueOf("SKULL"), false);
        }
    }

    /**
     * Throws a {@link NullPointerException} if the specified object is null.
     *
     * @param paramObject The object.
     * @param paramString The name of the object.
     */
    private static void notNull(Object paramObject, String paramString) {
        if (paramObject == null)
            throw new NullPointerException(paramString + " should not be null!");
    }

    /**
     * Converts the specified URL to a base64 string.
     *
     * @param paramString The URL.
     * @return The base64 string.
     */
    private static String urlToBase64(String paramString) {
        URI uRI;
        try {
            uRI = new URI(paramString);
        } catch (URISyntaxException uRISyntaxException) {
            throw new RuntimeException(uRISyntaxException);
        }
        String str = "{\"textures\":{\"SKIN\":{\"url\":\"" + uRI.toString() + "\"}}}";
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}

