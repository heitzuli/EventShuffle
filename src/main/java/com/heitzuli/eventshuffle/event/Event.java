package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Event {
    private int id; // Id of event
    private final String name; // name of event
    private final Set<LocalDate> dates; // date options for event
    private final Map<LocalDate, Set<String>> votes = new HashMap<>(); // per date, a set of persons

    // Event must have name, dates
    public Event(String name, Set<LocalDate> dates) {
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

    public Set<LocalDate> getDates() {
        return dates;
    }

    public Map<LocalDate, Set<String>> getVotes() {
        return votes;
    }
}
