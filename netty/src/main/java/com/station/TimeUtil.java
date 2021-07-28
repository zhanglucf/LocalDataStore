package com.station;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author zzh
 * @date 2021年07月28日
 */
public class TimeUtil {
    public static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String getCurrentTimeStr() {
        return LocalDateTime.now().format(dtf2);
    }
}
