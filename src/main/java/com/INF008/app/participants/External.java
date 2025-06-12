package com.INF008.app.participants;

public class External extends Participant{
    static int counter = 0;
    int externalCode;

    public External(String cpf, String name) {
        super(cpf, name);
        externalCode = counter++;
    }

    public int getExternalCode() {
        return externalCode;
    }
}
