package com.INF008.app;

import java.util.Scanner;

import com.INF008.app.utils.ConsoleColors;
import com.INF008.app.utils.Utils;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        int option;
        do {
            Utils.cleanScreen();
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
            System.out
                    .println("║\t\t\t" + ConsoleColors.INFO + "ACADEMIC EVENT MANAGEMENT SYSTEM" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t" + ConsoleColors.INFO + "1. Register Event." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "2. Register participant." + ConsoleColors.RESET);
            System.out.println(
                    "║\t" + ConsoleColors.INFO + "3. Register participant for the event." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "4. " + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "5. " + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "6. " + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "0. Leave" + ConsoleColors.RESET);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
            System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerEvent();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 0:
                    Utils.cleanScreen();
                    System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
                    System.out.println("║\t\t\t" + ConsoleColors.WARNING + "Leaving the system..." + ConsoleColors.RESET);
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
                    break;
                default:
                    Utils.cleanScreen();
                    System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
                    System.out.println("║\t\t\t" + ConsoleColors.WARNING + "Invalid option, please try again." + ConsoleColors.RESET);
                    System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
            }
        } while (option != 0);
    }

    public static void registerEvent() {
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t\t\t" + ConsoleColors.INFO + "REGISTER EVENT" + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t" + ConsoleColors.INFO + "1. Lecture." + ConsoleColors.RESET);
        System.out.println("║\t" + ConsoleColors.INFO + "2. Workshop." + ConsoleColors.RESET);
        System.out.println("║\t" + ConsoleColors.INFO + "3. Short course." + ConsoleColors.RESET);
        System.out.println("║\t" + ConsoleColors.INFO + "4. Academic fair" + ConsoleColors.RESET);
        System.out.println("║\t" + ConsoleColors.INFO + "0. Leave" + ConsoleColors.RESET);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
        System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

        int type;
        type = scanner.nextInt();
        scanner.nextLine();
        if (type == 0)
            return;

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Local: ");
        String local = scanner.nextLine();

        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        Utils.cleanScreen();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\t\t\tEVENT REGISTER SUCCESSFULL");
        System.out.println("-------------------------------------------------------------------------------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
