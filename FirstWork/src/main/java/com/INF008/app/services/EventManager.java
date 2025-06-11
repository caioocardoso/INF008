package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.time.LocalDateTime;

import com.INF008.app.Menu;
import com.INF008.app.events.AcademicFair;
import com.INF008.app.events.Course;
import com.INF008.app.events.Event;
import com.INF008.app.events.Lecture;
import com.INF008.app.events.Workshop;
import com.INF008.app.participants.External;
import com.INF008.app.participants.Participant;
import com.INF008.app.participants.Student;
import com.INF008.app.participants.Teacher;
import com.INF008.app.utils.ConsoleColors;
import com.INF008.app.utils.Utils;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.FileOutputStream;
import java.io.IOException;

public class EventManager {
    private static int counter = 1;
    private static HashMap<Integer, Event> events = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void createLecture(String title, String date, String local, int capacity, String description,
            boolean isOnline) {
        Lecture newLecture = new Lecture(title, date, local, capacity, description, isOnline);
        events.put(counter++, (Event) newLecture);
    }

    public static void createFair(String title, String date, String local, int capacity, String description,
            boolean isOnline) {
        AcademicFair newFair = new AcademicFair(title, date, local, capacity, description, isOnline);
        events.put(counter++, (Event) newFair);
    }

    public static void createCourse(String title, String date, String local, int capacity, String description,
            boolean isOnline) {
        Course newCourse = new Course(title, date, local, capacity, description, isOnline);
        events.put(counter++, (Event) newCourse);
    }

    public static void createWorkshop(String title, String date, String local, int capacity, String description,
            boolean isOnline) {
        Workshop newWorkshop = new Workshop(title, date, local, capacity, description, isOnline);
        events.put(counter++, (Event) newWorkshop);
    }

    public static String getTitleByKey(int key) {
        Event event = events.get(key);

        if (event != null) {
            return event.getTitle();
        } else {
            return "Error: Event found for key " + key + " doesnt exists.";
        }
    }

    public static Event getEvent(int key) {
        Event event = events.get(key);

        if (event == null)
            return null;
        else
            return event;
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
        if (eventFound instanceof Course && !(participant instanceof Student)) {
            Menu.error("PARTICIPANT IS NOT A STUDENT");
            return;
        }
        eventFound.registerParticipantToEvent(participant);
        Menu.successfull("REGISTERED SUCCESSFULLY");
    }

    public static void populateEvents() {
        createLecture("Music Festival 2024", "03/05/2026", "Annual music event.", 1, "oi", true);
        createLecture("Tech Conference Global", "28/02/2025", "Leading tech conference.", 1, "oi", true);
        createLecture("Local Charity Run", "25/08/2027", "5k run for charity.", 1, "oi", false);
        createWorkshop("Art Exhibition Opening", "02/11/2025", "New modern art pieces.", 1, "oi", false);
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

    public static void eventsReportByType() {
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println(
                "║\t\t\t" + ConsoleColors.INFO + "CHOOSE AN EVENT TO SEE MORE INFORMATION" + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
        if (events.isEmpty()) {
            System.out.println("║ " + ConsoleColors.WARNING + "No events available to list." + ConsoleColors.RESET);
        } else {
            final int[] displayIndex = { 1 };

            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "LECTURE LIST" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            events.forEach((key, event) -> {
                if (event instanceof Lecture)
                    System.out
                            .println("║ " + displayIndex[0]++ + ". " + event.getTitle() + " (" + event.getDate() + ")");
            });

            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "ACADEMIC FAIR LIST" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            events.forEach((key, event) -> {
                if (event instanceof AcademicFair)
                    System.out
                            .println("║ " + displayIndex[0]++ + ". " + event.getTitle() + " (" + event.getDate() + ")");
            });

            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "COURSES LIST" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            events.forEach((key, event) -> {
                if (event instanceof Course)
                    System.out
                            .println("║ " + displayIndex[0]++ + ". " + event.getTitle() + " (" + event.getDate() + ")");
            });

            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            System.out.println("║\t\t\t" + ConsoleColors.INFO + "WORKSHOP LIST" + ConsoleColors.RESET);
            System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
            events.forEach((key, event) -> {
                if (event instanceof Workshop)
                    System.out
                            .println("║ " + displayIndex[0]++ + ". " + event.getTitle() + " (" + event.getDate() + ")");
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
        System.out.println("║\t\t\t" + ConsoleColors.INFO + "EVENT DETAILS OF \"" + eventFound.getTitle() + "\""
                + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
        System.out.println(
                "║ " + ConsoleColors.INFO + "Type: " + ConsoleColors.RESET + eventFound.getClass().getSimpleName());
        System.out.println("║ " + ConsoleColors.INFO + "Date: " + ConsoleColors.RESET + eventFound.getDate());
        if (eventFound.isOnline()) {
            System.out.println("║ " + ConsoleColors.INFO + "Modality: " + ConsoleColors.RESET + "Online");
            System.out.println("║ " + ConsoleColors.INFO + "Link: " + ConsoleColors.RESET + eventFound.getLocal());
        } else {
            System.out.println("║ " + ConsoleColors.INFO + "Modality: " + ConsoleColors.RESET + "Presential");
            System.out.println("║ " + ConsoleColors.INFO + "Local: " + ConsoleColors.RESET + eventFound.getLocal());
        }
        System.out.println("║ " + ConsoleColors.INFO + "Capacity: " + ConsoleColors.RESET + eventFound.getCapacity());
        System.out.println("║ " + ConsoleColors.INFO + "Participants: " + ConsoleColors.RESET
                + eventFound.getNumberOfParticipants());
        System.out.println(
                "║ " + ConsoleColors.INFO + "Description: " + ConsoleColors.RESET + eventFound.getDescription());
        System.out.println("║ " + ConsoleColors.INFO + "Participants List: " + ConsoleColors.RESET);
        if (eventFound.getParticipantsOfEvent().isEmpty()) {
            System.out.println("║   No participants registered yet.");
        } else {
            for (Participant p : eventFound.getParticipantsOfEvent()) {
                System.out.println("║   - " + p.getName() + " (CPF: " + p.getCpf() + ")");
            }
        }
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
        Utils.pressEnterToContinue(scanner);
    }

    public static void generateCertificate(int keyEvent, String cpfParticipant) {
        Event event = EventManager.getEvent(keyEvent);
        Participant participant = ParticipantManager.getParticipant(cpfParticipant);

        if (event == null) {
            Menu.error("EVENT NOT FOUND");
            return;
        }
        if (participant == null) {
            Menu.error("PARTICIPANT NOT FOUND");
            return;
        }

        TreeSet<Participant> participantsOfEvent = event.getParticipantsOfEvent();

        if (!participantsOfEvent.contains(participant)) {
            Menu.error("PARTICIPANT DOESNT BELONG TO THE EVENT");
            return;
        }
        try {
            PdfWriter writer = new PdfWriter(new FileOutputStream("src/main/resources/certificate.pdf"));

            PdfDocument pdfDoc = new PdfDocument(writer = writer);
            Document document = new Document(pdfDoc);

            Paragraph heading = new Paragraph("CERTIFICATE")
                    .setFontSize(14)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(heading);

            String eventMode;
            if (event.isOnline())
                eventMode = " in online mode";
            else
                eventMode = " in presential mode";

            if (participant instanceof Student) {
                Paragraph p = new Paragraph(
                        "The university certifies that " + participant.getName() + ", holder of CPF "
                                + participant.getCpf() +
                                ", registration number " + ((Student) participant).getMatricula() +
                                ", participated in the event " + event.getTitle() + ", held on " + event.getDate() + eventMode
                                + ".")
                        .setFontSize(12);
                document.add(p);
            } else if (participant instanceof Teacher) {
                Paragraph p = new Paragraph(
                        "The university certifies that " + participant.getName() + ", holder of CPF "
                                + participant.getCpf() +
                                ", employee ID " + ((Teacher) participant).getTeacherCode() +
                                ", participated in the event " + event.getTitle() + ", held on " + event.getDate() + eventMode
                                + ".")
                        .setFontSize(12);
                document.add(p);
            } else if (participant instanceof External) {
                Paragraph p = new Paragraph(
                        "The university certifies that " + participant.getName() + ", holder of CPF "
                                + participant.getCpf() +
                                ", external ID " + ((External) participant).getExternalCode() +
                                ", participated in the event " + event.getTitle() + ", held on " + event.getDate() + eventMode
                                + ".")
                        .setFontSize(12);
                document.add(p);
            }

            document.close();

            Menu.successfull("CERTIFICATE DOWNLOADED SUCCESSFULLY IN\n src/main/resources/certificate.pdf");
        } catch (IOException e) {
            System.err.println("Erro ao gerar certificado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}