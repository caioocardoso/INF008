package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.INF008.app.Menu;
import com.INF008.app.events.Event;
import com.INF008.app.events.Lecture;
import com.INF008.app.participants.Participant;
import com.INF008.app.utils.ConsoleColors;
import com.INF008.app.utils.Utils;

public class EventManager implements iEvent {
    private static int counter = 0;
    private static HashMap<Integer, Event> events = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void createLecture(String title, String date, String local, int capacity, String description) {
        Lecture newLecture = new Lecture(title, date, local, capacity, description);
        events.put(counter++, (Event) newLecture);
    }

    public static String getTitle(int key) {
        Event event = events.get(key);

        if (event != null) {
            return event.getTitle();
        } else {
            return "Error: Event found for key " + key + " doesnt exists.";
        }
    }

    public static void registerParticipantToEvent(int keyEvent, String cpfParticipant) {
        Event eventFound = events.get(keyEvent);
        if (eventFound == null) {
            Menu.error("EVENT NOT FOUND");
            return;
        }
        if (eventFound.getNumberOfParticipants() >= eventFound.getCapacity()) {
            Menu.error("EVENT IS FULL");
            return;
        }
        Participant participant = ParticipantManager.getParticipant(cpfParticipant);
        if (participant == null) {
            Menu.error("PARTICIPANT NOT FOUND");
            return;
        }
        if (eventFound.getParticipantsOfEvent().contains(participant)) {
            Menu.error("PARTICIPANT ALREADY REGISTERED");
            return;
        }
        eventFound.registerParticipantToEvent(participant);
        Menu.successfull("REGISTERED SUCCESSFULLY");
    }

    public static void eventReport(int keyEvent) {
        Event eventFound = events.get(keyEvent);
        if (eventFound == null) {
            Menu.error("EVENT NOT FOUND");
            return;
        }
        int option;
        do {
            Utils.cleanScreen();
            System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "EVENT REPORT OF \"" + eventFound.getTitle() + "\"" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t" + ConsoleColors.INFO + "" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "" + ConsoleColors.RESET);
            System.out.println("║\t" + ConsoleColors.INFO + "" + ConsoleColors.RESET);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
            System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print(ConsoleColors.INPUT + "Event Key: " + ConsoleColors.RESET);
                // keyEvent = scanner.nextInt();
                // scanner.nextLine();
            }

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    return;
                default: Menu.invalidOption(); break;
            }
        } while (option != 0);
    }
}
