package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.INF008.app.participants.Participant;

public class ParticipantManager {
    private static HashMap<String, Participant> participants = new LinkedHashMap<>();

    public static void registerParticipant(String cpf, String name){
        Participant newParticipant = new Participant(cpf, name);
        participants.put(cpf, newParticipant);
    }
}
