package org.supernederen.awesomelib.library.utils;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for formatting time.
 * This class is not meant to be instantiated.
 *
 * <p>
 *     This class is part of the AwesomeLib project.
 *     <a href="https://github.com/SuperNederen/AwesomeLib">AwesomeLib</a> is licensed under the MIT license.
 * </p>
 * @author WildTooth
 * @since 1.0.0
 */
public final class Time {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private Time() {
        throw new IllegalStateException("Utility class, do not instantiate");
    }

    /**
     * Current unix-timestamp in seconds.
     *
     * @return long value of current unix in seconds
     */
    public static long currentUnixInSeconds(){
        return System.currentTimeMillis()/1000;
    }

    /**
     * Get formatted time string in danish.
     *
     * @param n the unix timestamp
     * @return the formatted time string
     */
    public static String getFormattedTime(long n){
        return getFormattedTime((int)n, true);
    }

    /**
     * Get formatted time string in danish.
     *
     * @param n           the unix timestamp
     * @param withSeconds with or without seconds
     * @return the formatted time string
     */
    public static String getFormattedTime(long n, boolean withSeconds){
        return getFormattedTime((int)n, withSeconds);
    }

    /**
     * Get formatted time string in danish.
     *
     * @param n the unix timestamp in seconds
     * @return the formatted time string
     */
    public static String getFormattedTime(int n){
        return getFormattedTime(n, true);
    }

    /**
     * Get a formatted time string in danish.
     *
     * @param n           the unix timestamp in seconds
     * @param withSeconds with or without seconds
     * @return the formatted time string
     */
    public static String getFormattedTime(int n, boolean withSeconds){
        if(n <= 0){
            return "0 sekunder";
        } else{
            int days, hours, minutes, seconds;
            days = (int) Math.floor( n / 86400 );
            hours = (int) Math.floor( ( n / 3600 ) - ( days * 24 ) );
            minutes = (int) Math.floor( ( n / 60 ) - ( ( hours + ( days * 24 ) ) * 60 ) );
            seconds = (int) Math.floor( n - ( ( days * 86400 ) + ( hours * 3600 ) + ( minutes * 60 ) ) );
            List<String> stringList = new ArrayList<>();
            if(days > 0)
                stringList.add(days + " " + (days == 1 ? "dag" : "dage"));
            if(hours > 0)
                stringList.add(hours + " " + (hours == 1 ? "time" : "timer"));
            if(minutes > 0)
                stringList.add(minutes + " " + (minutes == 1 ? "minut" : "minutter"));
            if(withSeconds && seconds > 0)
                stringList.add(seconds + " " + (seconds == 1 ? "sekund" : "sekunder"));
            else if((days+hours+minutes) <= 0 && seconds > 0)
                stringList.add(seconds + " " + (seconds == 1 ? "sekund" : "sekunder"));
            return StringUtils.formatList(stringList, "");
        }
    }

    /**
     * Get a String by formatting a timestamp as a date.
     *
     * @param paramLong the param long
     * @return the string
     */
    public static @NotNull String formatTimestampAsDate(long paramLong){
        return SIMPLE_DATE_FORMAT.format(paramLong);
    }
}
