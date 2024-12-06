package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Event {
    private int id;
    private final String name;
    private final Set<LocalDate> dates;
    private final Map<LocalDate, Set<String>> votes = new HashMap<>();

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
