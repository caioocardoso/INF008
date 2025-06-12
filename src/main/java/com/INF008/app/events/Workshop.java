package com.INF008.app.events;

import java.time.LocalDate;

public class Workshop extends Event{
    private String topic;

    public Workshop(String title, LocalDate date, String local, int capacity, String description, boolean isOnline, String topic) {
        super(title, date, local, capacity, description, isOnline);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}
