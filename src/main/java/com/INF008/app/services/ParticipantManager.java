package com.INF008.app.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import com.INF008.app.participants.External;
import com.INF008.app.participants.Participant;
import com.INF008.app.participants.Student;
import com.INF008.app.participants.Teacher;
import com.INF008.app.utils.ConsoleColors;
import com.INF008.app.utils.Utils;
import com.INF008.app.Menu;
import com.INF008.app.events.Event;

public class ParticipantManager {
    private static HashMap<String, Participant> participants = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static HashMap<String, Participant> getParticipants() {
        return participants;
    }

    public static Participant getParticipant(String cpf) {
        return participants.get(cpf);
    }

    public static void registerParticipant(int typeOfParticipant, String cpf, String name) {
        if (cpf == null || cpf.trim().isEmpty() || !cpf.matches("\\d{11}")) {
            Menu.error("INVALID CPF (MUST HAVE 11 DIGITS)");
            return;
        }
        if (name == null || name.trim().isEmpty()) {
            Menu.error("NAME CANNOT BE EMPTY");
            return;
        }
        if (participants.containsKey(cpf)) {
            Menu.error("PARTICIPANT ALREADY REGISTERED");
            return;
        }
        if (typeOfParticipant == 1) {
            Student newStudent = new Student(cpf, name);
            participants.put(cpf, newStudent);
        } else if (typeOfParticipant == 2) {
            Teacher newTeacher = new Teacher(cpf, name);
            participants.put(cpf, newTeacher);
        } else if (typeOfParticipant == 3) {
            External newExternal = new External(cpf, name);
            participants.put(cpf, newExternal);
        } else {
            Menu.error("INVALID TYPE OF PARTICIPANT");
            return;
        }
        Menu.successfull("PARTICIPANT REGISTERED SUCCESSFULLY");
    }

    public static void participantsReport() {
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println(
                "║\t\t\t" + ConsoleColors.INFO + "CHOOSE A PARTICIPANT TO SEE MORE INFORMATION" + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
        System.out.println("║\t" + ConsoleColors.WARNING + "Created at: " + Utils.dateToString(LocalDateTime.now())
                + ConsoleColors.RESET);
        if (participants.isEmpty()) {
            System.out
                    .println("║ " + ConsoleColors.WARNING + "No participants available to list." + ConsoleColors.RESET);
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
            Utils.pressEnterToContinue(scanner);
            return;
        }
        List<String> cpfList = new ArrayList<>(participants.keySet());
        final int[] displayIndex = { 1 };
        participants.forEach((cpf, participant) -> {
            System.out.printf(
                    "║ " + displayIndex[0]++ + ". " + participant.getName() + " (" + participant.getCpf() + ")\n");
        });
        System.out.println("║ " + ConsoleColors.WARNING + "Press 0 to return" + ConsoleColors.RESET);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
        System.out.print(ConsoleColors.INPUT + "Choose an option: " + ConsoleColors.RESET);

        try {
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 0) return;
            else if (option > 0 && option <= cpfList.size()) {
                String selectedCpf = cpfList.get(option - 1);
                participantDetails(selectedCpf);
            } else {
                Menu.invalidOption();
            }
        } catch (InputMismatchException e) {
            Menu.invalidOption();
        }
    }

    public static void participantDetails(String cpf) {
        Participant participantFound = participants.get(cpf);
        if (participantFound == null) {
            Menu.error("PARTICIPANT NOT FOUND");
            return;
        }
        Utils.cleanScreen();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════");
        System.out.println(
                "║\t\t\t" + ConsoleColors.INFO + "DETAILS OF " + participantFound.getName() + ConsoleColors.RESET);
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════");
        System.out.println(
                "║ " + ConsoleColors.INFO + "Type: " + ConsoleColors.RESET
                        + participantFound.getClass().getSimpleName());
        System.out.println("║ " + ConsoleColors.INFO + "Name: " + ConsoleColors.RESET + participantFound.getName());
        System.out.println("║ " + ConsoleColors.INFO + "CPF: " + ConsoleColors.RESET + participantFound.getCpf());
        if (participantFound instanceof Student)
            System.out.println("║ " + ConsoleColors.INFO + "Registration ID: " + ConsoleColors.RESET
                    + ((Student) participantFound).getMatricula());
        else if (participantFound instanceof Teacher)
            System.out.println("║ " + ConsoleColors.INFO + "Employee ID: " + ConsoleColors.RESET
                    + ((Teacher) participantFound).getTeacherCode());
        else if (participantFound instanceof External)
            System.out.println("║ " + ConsoleColors.INFO + "External ID: " + ConsoleColors.RESET
                    + ((External) participantFound).getExternalCode());
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════");
        System.out.println(ConsoleColors.INPUT + "Press Enter to return..." + ConsoleColors.RESET);
        scanner.nextLine();
    }
}