package com.INF008.app.events;

import java.time.LocalDate;

public class Course extends Event {
    private int durationInHours;

    public Course(String title, LocalDate date, String local, int capacity, String description, boolean isOnline, int durationInHours) {
        super(title, date, local, capacity, description, isOnline);
        this.durationInHours = durationInHours;
    }

    public int getDurationInHours() {
        return durationInHours;
    }
}