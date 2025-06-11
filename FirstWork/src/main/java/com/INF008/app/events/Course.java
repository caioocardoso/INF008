package com.INF008.app.events;

public class Course extends Event {
    private int durationInHours;

    public Course(String title, String date, String local, int capacity, String description, boolean isOnline, int durationInHours) {
        super(title, date, local, capacity, description, isOnline);
        this.durationInHours = durationInHours;
    }

    public int getDurationInHours() {
        return durationInHours;
    }
}