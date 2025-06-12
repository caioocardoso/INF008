package com.INF008.app.participants;

public class Participant implements iParticipant{
    String cpf;
    String name;

    public Participant(String cpf, String name){
        this.cpf = cpf;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }
}
