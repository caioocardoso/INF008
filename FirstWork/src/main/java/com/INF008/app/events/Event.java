package com.INF008.app.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.INF008.app.participants.Participant;

public class Event {
    private String title;
    private String date;
    private String local;
    private int capacity;
    private String description;
    // private HashMap<String, Participant> participantsOfEvent = new LinkedHashMap<>();

    public Event(String title, String date, String local, int capacity, String description) {
        this.title = title;
        this.date = date;
        this.local = local;
        this.capacity = capacity;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
}