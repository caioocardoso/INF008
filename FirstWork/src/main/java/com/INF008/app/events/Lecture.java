package com.INF008.app.events;

public class Lecture extends Event{
    private String speaker;

    public Lecture(String title, String date, String local, int capacity, String description, boolean isOnline, String speaker){
        super(title, date, local, capacity, description, isOnline);
        this.speaker = speaker;
    }

    public String getSpeaker() {
        return speaker;
    }
}