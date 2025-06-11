package com.INF008.app.events;

public class Workshop extends Event{

    public Workshop(String title, String date, String local, int capacity, String description, boolean isOnline) {
        super(title, date, local, capacity, description, isOnline);
    }

}
