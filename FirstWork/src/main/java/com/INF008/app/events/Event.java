package com.INF008.app.events;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;

import com.INF008.app.participants.Participant;

public class Event implements iEvent{
    private String title;
    private String date;

    private String local;
    private int capacity;
    private String description;

    Comparator<Participant> comparatorByName = new Comparator<Participant>() {
        @Override
        public int compare(Participant p1, Participant p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    private TreeSet<Participant> participantsOfEvent = new TreeSet<>(comparatorByName);

    public Event(String title, String date, String local, int capacity, String description) {
        this.title = title;
        this.date = date;
        this.local = local;
        this.capacity = capacity;
        this.description = description;
    }

    public void registerParticipantToEvent(Participant participant) {
        participantsOfEvent.add(participant);
        System.out.println(participantsOfEvent.contains(participant));
    }

    public int getNumberOfParticipants() {
        return participantsOfEvent.size();
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public String getDate() {
        return date;
    }

    public TreeSet<Participant> getParticipantsOfEvent() {
        return participantsOfEvent;
    }

    public String getLocal() {
        return local;
    }

    public String getDescription() {
        return description;
    }
}