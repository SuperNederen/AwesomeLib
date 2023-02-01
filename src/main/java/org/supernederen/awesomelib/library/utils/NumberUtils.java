package org.supernederen.awesomelib.library.utils;

import org.jetbrains.annotations.Nullable;

/**
 * NumberUtils is a utility class for numbers.
 * It contains methods for converting numbers to other types, such as
 * {@link #toInteger(String)} and {@link #toLong(String)}.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public final class NumberUtils {

    private NumberUtils() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    /**
     * Converts a string to a number.
     * @param string The string to convert.
     * @return The number.
     */
    public static @Nullable Number toNumber(String string) {
        if (StringUtils.isInteger(string)) {
            return toInteger(string);
        } else if (StringUtils.isDouble(string)) {
            return toDouble(string);
        } else if (StringUtils.isFloat(string)) {
            return toFloat(string);
        } else if (StringUtils.isLong(string)) {
            return toLong(string);
        } else if (StringUtils.isShort(string)) {
            return toShort(string);
        } else {
            return null;
        }
    }

    /**
     * Converts a string to an integer.
     * @param string The string to convert.
     * @return The integer.
     */
    public static int toInteger(String string) {
        StringUtils.isInteger(string);
        return Integer.parseInt(string);
    }

    /**
     * Converts a string to a double.
     * @param string The string to convert.
     * @return The double.
     */
    public static double toDouble(String string) {
        StringUtils.isDouble(string);
        return Double.parseDouble(string);
    }

    /**
     * Converts a string to a float.
     * @param string The string to convert.
     * @return The float.
     */
    public static float toFloat(String string) {
        StringUtils.isFloat(string);
        return Float.parseFloat(string);
    }

    /**
     * Converts a string to a long.
     * @param string The string to convert.
     * @return The long.
     */
    public static long toLong(String string) {
        StringUtils.isLong(string);
        return Long.parseLong(string);
    }

    /**
     * Converts a string to a short.
     * @param string The string to convert.
     * @return The short.
     */
    public static short toShort(String string) {
        StringUtils.isShort(string);
        return Short.parseShort(string);
    }

    /**
     * Converts a string to a boolean.
     * @param string The string to convert.
     * @return The boolean.
     */
    public static boolean toBoolean(String string) {
        StringUtils.isBoolean(string);
        return Boolean.parseBoolean(string);
    }

}
