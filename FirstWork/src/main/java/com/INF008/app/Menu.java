package com.INF008.app;

import java.util.Scanner;

import com.INF008.app.services.EventManager;
import com.INF008.app.services.ParticipantManager;
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
            System.out.println("║\t" + ConsoleColors.INFO + "3. " + ConsoleColors.RESET);
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
                    registerParticipant();
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
                    System.out
                            .println("╔══════════════════════════════════════════════════════════════════════════════");
                    System.out
                            .println("║\t\t\t" + ConsoleColors.WARNING + "Leaving the system..." + ConsoleColors.RESET);
                    System.out
                            .println("╠══════════════════════════════════════════════════════════════════════════════");
                    break;
                default:
                    Utils.cleanScreen();
                    System.out
                            .println("╔══════════════════════════════════════════════════════════════════════════════");
                    System.out.println("║\t\t\t" + ConsoleColors.WARNING + "Invalid option, please try again."
                            + ConsoleColors.RESET);
                    System.out
                            .println("╠══════════════════════════════════════════════════════════════════════════════");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
            }
        } while (option != 0);
    }

    public static void registerEvent() {
        int type = 0;
        String title = "";
        String date = "";
        String local = "";
        int capacity = 0;
        String description = "";

        do {
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

            type = scanner.nextInt();
            scanner.nextLine();

            if (type >= 1 && type <= 4) {
                System.out.print(ConsoleColors.INPUT + "Title: " + ConsoleColors.RESET);
                title = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Date: " + ConsoleColors.RESET);
                date = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Local: " + ConsoleColors.RESET);
                local = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Capacity: " + ConsoleColors.RESET);
                capacity = scanner.nextInt();
                scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Description: " + ConsoleColors.RESET);
                description = scanner.nextLine();
            }

            switch (type) {
                case 1:
                    EventManager.createLecture(title, date, local, capacity, description);
                    successfull("REGISTERING THE LECTURE");
                    break;
                case 2:
                    successfull("REGISTERING THE EVENT");
                    break;
                case 3:
                    successfull("REGISTERING THE EVENT");
                    break;
                case 4:
                    successfull("REGISTERING THE EVENT");
                    break;
                case 0:
                    return;
                default:
                    Utils.cleanScreen();
                    System.out
                            .println("╔══════════════════════════════════════════════════════════════════════════════");
                    System.out.println("║\t\t\t" + ConsoleColors.WARNING + "Invalid option, please try again."
                            + ConsoleColors.RESET);
                    System.out
                            .println("╠══════════════════════════════════════════════════════════════════════════════");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                    break;
            }
        } while (type != 0);
    }

    public static void registerParticipant(){
        int option = 0;
        String cpf = "";
        String name = "";

        do {
            Utils.cleanScreen();
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "REGISTER PARTICIPANT" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t" + ConsoleColors.INFO + "1. Register participant." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "2. Register participant in an event." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "3. " + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "4. " + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "0. Leave" + ConsoleColors.RESET);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
            System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print(ConsoleColors.INPUT + "Cpf: " + ConsoleColors.RESET);
                cpf = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Name: " + ConsoleColors.RESET);
                name = scanner.nextLine();
            }

            switch (option) {
                case 1:
                    ParticipantManager.registerParticipant(cpf, name);
                    successfull("REGISTERING THE PARTICIPANT");
                    break;
                case 2:
                    successfull("REGISTERING THE PARTICIPANT IN AN EVENT");
                    break;
                case 3:
                    successfull("");
                    break;
                case 4:
                    successfull("");
                    break;
                case 0:
                    return;
                default:
                    Utils.cleanScreen();
                    System.out
                            .println("╔══════════════════════════════════════════════════════════════════════════════");
                    System.out.println("║\t\t\t" + ConsoleColors.WARNING + "Invalid option, please try again."
                            + ConsoleColors.RESET);
                    System.out
                            .println("╠══════════════════════════════════════════════════════════════════════════════");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                    break;
            }
        } while (option != 0);
    }

    public static void successfull(String text) {
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t\t\t" + ConsoleColors.INFO + "SUCCESS IN " + text  + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
