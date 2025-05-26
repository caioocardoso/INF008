package com.INF008.app;

public class Event {
    private String title;
    private String date;
    private String local;
    private int capacity;
    private String description;

    public void setEvent(String title, String date, String local, int capacity, String description) {
        this.title = title;
        this.date = date;
        this.local = local;
        this.capacity = capacity;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}