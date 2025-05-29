package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.INF008.app.events.Event;
import com.INF008.app.events.Lecture;
import com.INF008.app.events.iEvent;

public class EventManager implements iEvent{
    private static int counter = 0;
    private static HashMap<Integer, Event> events = new LinkedHashMap<>();

    public static void createLecture(String title, String date, String local, int capacity, String description){
        Lecture newLecture = new Lecture(title, date, local, capacity, description);
        events.put(counter++, (Event)newLecture);
    }

    public static String getTitle(int key) {
        Event event = events.get(key);

        if (event != null) {
            return event.getTitle();
        } else {
            return "Error: Event found for key " + key + " doesnt exists.";
        }
    }

    @Override
    public void registerParticipantToEvent(){}
}
