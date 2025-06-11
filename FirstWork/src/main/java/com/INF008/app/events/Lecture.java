package com.INF008.app.events;

public class Lecture extends Event{
    public Lecture(String title, String date, String local, int capacity, String description, boolean isOnline){
        super(title, date, local, capacity, description, isOnline);
    }
}