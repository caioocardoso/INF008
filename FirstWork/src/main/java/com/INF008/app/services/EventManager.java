package com.INF008.app.services;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.INF008.app.Menu;
import com.INF008.app.events.Event;
import com.INF008.app.events.Lecture;
import com.INF008.app.participants.Participant;

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

    public static void registerParticipantToEvent(int keyEvent, String cpfParticipant){
        Event eventFound = events.get(keyEvent);

        if(eventFound != null){
            eventFound.registerParticipantToEvent(ParticipantManager.getParticipant(cpfParticipant));
        } else{
            Menu.error("REGISTERING PARTICIPANT TO AN EVENT");
        }
    }
}
