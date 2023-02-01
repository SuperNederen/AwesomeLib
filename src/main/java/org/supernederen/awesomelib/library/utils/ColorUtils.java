package org.supernederen.awesomelib.library.utils;

import org.bukkit.ChatColor;

import java.util.List;

/**
 * Utility class for translating strings with color codes
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public final class ColorUtils {

    private ColorUtils() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    /**
     * Translates a string using an alternate color code character into
     * an array of Strings that uses the internal {@link ChatColor}.COLOR_CODE
     *
     * @param stringList The string(s) to translate
     * @return The translated string(s)
     */
    public static String[] colorize(String... stringList){
        if(stringList == null) return null;
        for(int i = 0; i< stringList.length;i++)
            stringList[i] = colorize(stringList[i]);
        return stringList;
    }

    /**
     * Translates a list of strings using an alternate color code character
     * into a list of Strings that uses the internal {@link ChatColor}.COLOR_CODE
     *
     * @param stringList The string(s) to translate
     * @return The translated string(s)
     */
    public static List<String> colorize(List<String> stringList){
        if(stringList == null) return null;
        for(int i = 0; i< stringList.size();i++)
            stringList.set(i, colorize(stringList.get(i)));
        return stringList;
    }

    /**
     * Translates a string using an alternate color code character
     * into a string that uses the internal {@link ChatColor}.COLOR_CODE
     *
     * @param s The string to translate
     * @return The translated string
     */
    public static String colorize(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }


}
