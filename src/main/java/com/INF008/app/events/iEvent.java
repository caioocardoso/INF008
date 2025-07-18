package com.INF008.app.events;

import java.time.LocalDate;
import java.util.TreeSet;

import com.INF008.app.participants.Participant;

public interface iEvent {
    public void registerParticipantToEvent(Participant participant);
    public int getNumberOfParticipants();
    public String getTitle();
    public int getCapacity();
    public LocalDate getDate();
    public TreeSet<Participant> getParticipantsOfEvent();
    public String getLocal();
    public String getDescription();
}
