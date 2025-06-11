package com.INF008.app;

import java.util.Scanner;

import com.INF008.app.services.EventManager;
import com.INF008.app.services.ParticipantManager;
import com.INF008.app.utils.ConsoleColors;
import com.INF008.app.utils.Utils;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        String optionStr;
        int option;
        do {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
            System.out
                    .println("║\t\t\t" + ConsoleColors.INFO + "ACADEMIC EVENT MANAGEMENT SYSTEM" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t" + ConsoleColors.INFO + "1. Register Event." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "2. Register participant." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "3. Event report" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "4. Participant report" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "5. Request a certificate" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "0. Leave" + ConsoleColors.RESET);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
            System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

            optionStr = scanner.nextLine();
            option = Utils.isNumber(optionStr);

            switch (option) {
                case 1:
                    registerEventMenu();
                    break;
                case 2:
                    registerParticipantMenu();
                    break;
                case 3:
                    eventReportMenu();
                    break;
                case 4:
                    ParticipantManager.participantsReport();
                    break;
                case 5:
                    certificateMenu();
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
                    Menu.invalidOption();
                    break;
            }
        } while (option != 0);
    }

    private static void eventReportMenu() {
        String optionStr;
        int option;
        Utils.cleanScreen();
        do {
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "EVENT REPORT" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t" + ConsoleColors.INFO + "1. Report by registration order." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "2. Report by type." + ConsoleColors.RESET);
            // System.out.println("║\t" + ConsoleColors.INFO + "3. Report by date." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "0. Leave" + ConsoleColors.RESET);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
            System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

            optionStr = scanner.nextLine();
            option = Utils.isNumber(optionStr);

            switch (option) {
                case 1:
                    EventManager.eventsReportByRegistrationOrder();
                    break;
                case 2:
                    EventManager.eventsReportByType();
                    break;
                case 0:
                    return;
                default:
                    Menu.invalidOption();
                    break;
            }
        } while (option != 0);
    }

    public static void registerEventMenu() {
        int type;
        String typeStr;
        String title = "";
        String date = "";
        String local = "";
        int capacity = 0;
        String description = "";
        boolean isOnline = false;

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

            typeStr = scanner.nextLine();
            type = Utils.isNumber(typeStr);

            if (type >= 1 && type <= 4) {
                System.out.print(ConsoleColors.INPUT + "Title: " + ConsoleColors.RESET);
                title = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Date: " + ConsoleColors.RESET);
                date = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Is online? (Y/N) " + ConsoleColors.RESET);
                String isOnlineStr = scanner.nextLine();
                isOnline = isOnlineStr.equalsIgnoreCase("Y");

                if (isOnline) {
                    System.out.print(ConsoleColors.INPUT + "Link: " + ConsoleColors.RESET); 
                }else {
                    System.out.print(ConsoleColors.INPUT + "Local: " + ConsoleColors.RESET);
                }
                local = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Capacity: " + ConsoleColors.RESET);
                String capacityStr = scanner.nextLine();
                capacity = Utils.isNumber(capacityStr);
                if(capacity == -1){
                    error("CAPACITY MUST BE AN INTEGER");
                    continue;
                }

                System.out.print(ConsoleColors.INPUT + "Description: " + ConsoleColors.RESET);
                description = scanner.nextLine();

            }

            switch (type) {
                case 1:
                    System.out.print(ConsoleColors.INPUT + "Name of speaker: " + ConsoleColors.RESET);
                    String speaker = scanner.nextLine();
                    EventManager.createLecture(title, date, local, capacity, description, isOnline, speaker);
                    successfull("REGISTERING THE LECTURE");
                    break;
                case 2:
                    System.out.print(ConsoleColors.INPUT + "Topic: " + ConsoleColors.RESET);
                    String topic = scanner.nextLine();
                    EventManager.createWorkshop(title, date, local, capacity, description, isOnline, topic);
                    successfull("REGISTERING THE EVENT");
                    break;
                case 3:
                    System.out.print(ConsoleColors.INPUT + "Duration in hours: " + ConsoleColors.RESET);
                    String durationInHoursStr = scanner.nextLine();
                    int durationInHours = Utils.isNumber(durationInHoursStr);
                    if(durationInHours == -1){
                        error("DURATION MUST BE AN INTEGER");
                        continue;
                    }
                    EventManager.createCourse(title, date, local, capacity, description, isOnline, durationInHours);
                    successfull("REGISTERING THE EVENT");
                    break;
                case 4:
                    System.out.print(ConsoleColors.INPUT + "Number of exhibitors: " + ConsoleColors.RESET);
                    String numberOfExhibitorsStr = scanner.nextLine();
                    int numberOfExhibitors = Utils.isNumber(numberOfExhibitorsStr);
                    if(numberOfExhibitors == -1){
                        error("EXHIBITOR MUST BE AN INTEGER");
                        continue;
                    }
                    EventManager.createFair(title, date, local, capacity, description, isOnline, numberOfExhibitors);
                    successfull("REGISTERING THE EVENT");
                    break;
                case 0:
                    return;
                default:
                    Menu.invalidOption();
                    break;
            }
        } while (type != 0);
    }

    public static void registerParticipantMenu() {
        String optionStr;
        int option;
        String cpf = "";
        String name = "";
        int typeOfParticipant = 0;
        int keyEvent = -1;

        do {
            Utils.cleanScreen();
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "REGISTER PARTICIPANT" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t" + ConsoleColors.INFO + "1. Register participant." + ConsoleColors.RESET);
            System.out
                    .println("║\t" + ConsoleColors.INFO + "2. Register participant in an event." + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "0. Leave" + ConsoleColors.RESET);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
            System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

            optionStr = scanner.nextLine();
            option = Utils.isNumber(optionStr);

            if (option == 1) {
                System.out.println(ConsoleColors.INPUT + "Participant is a Student? Press 1" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.INPUT + "Participant is a Teacher? Press 2" + ConsoleColors.RESET);
                System.out.println(ConsoleColors.INPUT + "Participant is an External? Press 3" + ConsoleColors.RESET);
                String typeOfParticipantStr = scanner.nextLine();
                typeOfParticipant = Utils.isNumber(typeOfParticipantStr);
                if(typeOfParticipant == -1){
                    error("TYPE OF PARTICIPANT MUST BE AN INTEGER");
                    continue;
                }
                System.out.print(ConsoleColors.INPUT + "Cpf: " + ConsoleColors.RESET);
                cpf = scanner.nextLine();

                System.out.print(ConsoleColors.INPUT + "Name: " + ConsoleColors.RESET);
                name = scanner.nextLine();
            }

            if (option == 2) {
                System.out.print(ConsoleColors.INPUT + "Wich event do you want to add the participant? Key: "
                        + ConsoleColors.RESET);
                String keyEventStr = scanner.nextLine();
                keyEvent = Utils.isNumber(keyEventStr);
                if(keyEvent == -1){
                    error("EVENT KEY MUST BE AN INTEGER");
                    continue;
                }

                System.out.print(ConsoleColors.INPUT + "Cpf of participant: " + ConsoleColors.RESET);
                cpf = scanner.nextLine();
            }

            switch (option) {
                case 1:
                    ParticipantManager.registerParticipant(typeOfParticipant, cpf, name);
                    break;
                case 2:
                    EventManager.registerParticipantToEvent(keyEvent, cpf);
                    break;
                case 0:
                    return;
                default:
                    Menu.invalidOption();
                    break;
            }
        } while (option != 0);
    }

    public static void certificateMenu() {
        String cpf = "";

        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t\t\t" + ConsoleColors.INFO + "REQUEST CERTIFICATE" + ConsoleColors.RESET);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");

        System.out.print(ConsoleColors.INPUT + "Event key: " + ConsoleColors.RESET);
        String keyEventStr = scanner.nextLine();
        int keyEvent = Utils.isNumber(keyEventStr);
        if(keyEvent == -1){
            error("EVENT KEY MUST BE AN INTEGER");
        }
        System.out.print(ConsoleColors.INPUT + "Cpf: " + ConsoleColors.RESET);
        cpf = scanner.nextLine();

        EventManager.generateCertificate(keyEvent, cpf);
    }

    public static void successfull(String text) {
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t\t\t" + ConsoleColors.INFO + "[SUCCESS] " + text + ConsoleColors.RESET);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    public static void error(String text) {
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t\t\t" + ConsoleColors.INFO + "[ERROR] " + text + ConsoleColors.RESET);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    public static void invalidOption() {
        Utils.cleanScreen();
        System.out
                .println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t\t\t" + ConsoleColors.WARNING + "Invalid option, please try again."
                + ConsoleColors.RESET);
        System.out
                .println("╚══════════════════════════════════════════════════════════════════════════════");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

}
