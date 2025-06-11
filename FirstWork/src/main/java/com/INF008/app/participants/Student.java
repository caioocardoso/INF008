package com.INF008.app.participants;

public class Student extends Participant{
    static int counter = 0;
    int matricula;

    public Student(String cpf, String name) {
        super(cpf, name);
        matricula = counter++;
    }

    public int getMatricula() {
        return matricula;
    }
}
