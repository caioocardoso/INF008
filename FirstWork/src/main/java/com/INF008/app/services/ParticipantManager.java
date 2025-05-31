package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.INF008.app.participants.Participant;
import com.INF008.app.Menu;

public class ParticipantManager {
    private static HashMap<String, Participant> participants = new LinkedHashMap<>();

    public static Participant getParticipant(String cpf) {
        return participants.get(cpf);
    }

    public static void registerParticipant(String cpf, String name) {
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
        Participant newParticipant = new Participant(cpf, name);
        participants.put(cpf, newParticipant);
        Menu.successfull("PARTICIPANT REGISTERED SUCCESSFULLY");
    }
}
