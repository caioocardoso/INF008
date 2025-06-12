package com.INF008.app.participants;

public class Teacher extends Participant{
    static int counter = 0;
    int teacherCode;

    public Teacher(String cpf, String name) {
        super(cpf, name);
        teacherCode = counter++;
    }

    public int getTeacherCode() {
        return teacherCode;
    }
}
