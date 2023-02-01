package org.supernederen.awesomelib.utils;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    /**
     * Checks if a string is a number.
     *
     * @param str the string to check
     * @return if the string is a number
     */
    public static boolean isNumber(String str) {
        if (isNothing(str)) {
            return false;
        }
        return isInteger(str)
                || isDouble(str)
                || isFloat(str)
                || isLong(str)
                || isShort(str);
    }

    /**
     * Checks if a string is an integer.
     *
     * @param str the string to check
     * @return if the string is an integer
     */
    public static boolean isInteger(String str) {
        if (isNothing(str)) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a string is a double.
     *
     * @param str the string to check
     * @return if the string is a double
     */
    public static boolean isDouble(String str) {
        if (isNothing(str)) {
            return false;
        }
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a string is a float.
     *
     * @param str the string to check
     * @return if the string is a float
     */
    public static boolean isFloat(String str) {
        if (isNothing(str)) {
            return false;
        }
        try {
            Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a string is a long.
     *
     * @param str the string to check
     * @return if the string is a long
     */
    public static boolean isLong(String str) {
        if (isNothing(str)) {
            return false;
        }
        try {
            Long.parseLong(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a string is a short.
     *
     * @param str the string to check
     * @return if the string is a short
     */
    public static boolean isShort(String str) {
        if (isNothing(str)) {
            return false;
        }
        try {
            Short.parseShort(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * Checks if a string is a boolean.
     *
     * @param str the string to check
     * @return if the string is a boolean
     */
    public static boolean isBoolean(String str) {
        if (isNothing(str)) {
            return false;
        }
        return str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false");
    }

    /**
     * Capitalizes a string, changing the first letter to title case as per
     * {@link Character#toUpperCase(char)}. No other letters are changed.
     *
     * @param str the string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(String str) {
        if (isNothing(str)) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    /**
     * Decapitalizes a string, changing the first letter to title case as per
     * {@link Character#toLowerCase(char)}. No other letters are changed.
     *
     * @param str the string to capitalize
     * @return the capitalized string
     */
    public static String decapitalize(String str) {
        if (isNothing(str)) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    /**
     * Converts a string to camel case.
     *
     * @param str the string to convert
     * @return the camel case string
     */
    public static String toCamelCase(String str) {
        if (isNothing(str)) {
            return str;
        }
        String[] parts = str.split("_");
        String camelCaseString = "";
        for (String part : parts) {
            camelCaseString = camelCaseString + capitalize(part);
        }
        return decapitalize(camelCaseString);
    }

    /**
     * Checks if a string is valid.
     *
     * @param str the string to check
     * @return if the string is valid
     */
    public static boolean isNothing(String str) {
        return str != null && !str.isEmpty();
    }
}
