package com.INF008.app.events;

public class AcademicFair extends Event{
    private int numberOfExhibitors;

    public AcademicFair(String title, String date, String local, int capacity, String description, boolean isOnline, int numberOfExhibitors) {
        super(title, date, local, capacity, description, isOnline);
        this.numberOfExhibitors = numberOfExhibitors;
    }

    public int getNumberOfExhibitors() {
        return numberOfExhibitors;
    }
}
