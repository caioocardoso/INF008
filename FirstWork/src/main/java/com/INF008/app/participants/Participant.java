package com.INF008.app.participants;

public class Participant {
    String cpf;
    String name;

    public String getName() {
        return name;
    }

    public Participant(String cpf, String name){
        this.cpf = cpf;
        this.name = name;
    }
}
