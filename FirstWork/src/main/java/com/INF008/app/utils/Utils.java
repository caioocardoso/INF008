package com.INF008.app.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utils {
    public static void cleanScreen() {
        System.out.println("\33[H\33[2J");
    }

    private static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter
            .ofPattern("MM-dd-yyyy HH:mm:ss");

    public static String dateToString(LocalDateTime date) {
        if (date == null) {
            return null;
        }
        return date.format(DEFAULT_DATETIME_FORMATTER);
    }

    public static void pressEnterToContinue(Scanner scanner) {
        System.out.println(ConsoleColors.INPUT + "Press Enter to return..." + ConsoleColors.RESET);
        scanner.nextLine();
    }

    public static Integer isNumber(String value){
        try{
            int num = Integer.valueOf(value);
            return num;
        }catch(Exception e){
            return -1;
        }
    }
}
