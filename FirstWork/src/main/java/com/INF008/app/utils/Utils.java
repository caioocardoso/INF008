package com.INF008.app.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static void cleanScreen(){
        System.out.println("\33[H\33[2J");
    }

    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

    public static String dateToString(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        return date.format(DEFAULT_DATETIME_FORMATTER);
    }
}
