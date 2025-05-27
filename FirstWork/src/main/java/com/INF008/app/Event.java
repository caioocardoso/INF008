package com.INF008.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Event implements iEvent {
    private int id;
    private String title;
    private String date;
    private String local;
    private int capacity;
    private String description;
    private static int counter = 0;
    private static HashMap<Integer, Event> events = new LinkedHashMap<>();

    public Event(String title, String date, String local, int capacity, String description) {
        this.title = title;
        this.date = date;
        this.local = local;
        this.capacity = capacity;
        this.description = description;
    }
}