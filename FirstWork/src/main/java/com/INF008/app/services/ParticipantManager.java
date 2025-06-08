package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.INF008.app.participants.External;
import com.INF008.app.participants.Participant;
import com.INF008.app.participants.Student;
import com.INF008.app.participants.Teacher;
import com.INF008.app.Menu;

public class ParticipantManager {
    private static HashMap<String, Participant> participants = new LinkedHashMap<>();

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
        }else if (typeOfParticipant == 2) {
            Teacher newTeacher = new Teacher(cpf, name);
            participants.put(cpf, newTeacher);         
        }else if (typeOfParticipant == 3) {
            External newExternal = new External(cpf, name);
            participants.put(cpf, newExternal);                     
        }else{
            Menu.error("INVALID TYPE OF PARTICIPANT");
            return;
        }
        Menu.successfull("PARTICIPANT REGISTERED SUCCESSFULLY");
    }
}
