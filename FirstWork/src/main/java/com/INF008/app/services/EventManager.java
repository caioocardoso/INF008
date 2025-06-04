package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;

import com.INF008.app.Menu;
import com.INF008.app.events.Event;
import com.INF008.app.events.Lecture;
import com.INF008.app.participants.Participant;
import com.INF008.app.utils.ConsoleColors;
import com.INF008.app.utils.Utils;

public class EventManager implements iEvent {
    private static int counter = 1;
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

    public static void populateEvents() { // Helper to add some sample data
        events.put(1, new Lecture("Music Festival 2024", "03/05/2026", "Annual music event.", 1, "oi"));
        events.put(2, new Lecture("Tech Conference Global", "28/02/2025", "Leading tech conference.", 1, "oi"));
        events.put(3, new Lecture("Local Charity Run", "25/08/2027", "5k run for charity.", 1, "oi"));
        events.put(4, new Event("Art Exhibition Opening", "02/11/2025", "New modern art pieces.", 1, "oi"));
    }

    public static void eventsReportByRegistrationOrder() {
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println(
                "║\t\t\t" + ConsoleColors.INFO + "CHOOSE AN EVENT TO SEE MORE INFORMATION" + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t" + ConsoleColors.WARNING + "Created at: " + Utils.dateToString(LocalDateTime.now())
                + ConsoleColors.RESET);
        if (events.isEmpty()) {
            System.out.println("║ " + ConsoleColors.WARNING + "No events available to list." + ConsoleColors.RESET);
        } else {
            final int[] displayIndex = { 1 };
            events.forEach((key, event) -> {
                System.out.printf("║ " + displayIndex[0]++ + ". " + event.getTitle() + " (" + event.getDate() + ")\n");
            });
        }
        System.out.println("║ " + ConsoleColors.WARNING + "Press 0 to return" + ConsoleColors.RESET);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
        System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 0)
            return;
        else {
            eventDetails(option);
        }
    }

    public static void eventDetails(int keyEvent) {
        Event eventFound = events.get(keyEvent);
        if (eventFound == null) {
            Menu.error("EVENT NOT FOUND");
            return;
        }
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println(
                "║\t\t\t" + ConsoleColors.INFO + "EVENT DETAILS OF \"" + eventFound.getTitle() + "\"" + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t" + ConsoleColors.WARNING + "Created at: " + Utils.dateToString(LocalDateTime.now())
                + ConsoleColors.RESET);
        System.out.println("║ " + ConsoleColors.INFO + "AAAAAAAAAKKAKAKAKAKAKAKAKAKAK" + ConsoleColors.RESET);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
    }
}
