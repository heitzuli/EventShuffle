package com.heitzuli.eventshuffle.event.model;

import java.time.LocalDate;
import java.util.Set;

public class Event {
    private int id; // ID of event
    private final String name; // name of event
    private final Set<EventDate> dates; // date options for event

    // Event must have name, dates
    public Event(String name, Set<EventDate> dates) {
        this.name = name;
        this.dates = dates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<EventDate> getDates() {
        return dates;
    }

    public void addVote(String person, LocalDate voteDate) {
        // Loop through all event dates
        for (EventDate eventDate : this.dates) {
            // If we find the one we voted for, add the name of the person
            if (eventDate.date().equals(voteDate)) {
                eventDate.people().add(person);
            }
        }
    }
}
