package com.INF008.app.events;

public class Course extends Event{

    public Course(String title, String date, String local, int capacity, String description, boolean isOnline) {
        super(title, date, local, capacity, description, isOnline);
    }

}
