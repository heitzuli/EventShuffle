package com.heitzuli.eventshuffle.event;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EventService {
    // Mock database until I figure out how repositories work
    private static final Set<Event> database = new HashSet<>();

    public Set<Event> getEvents() {
        return database;
    }

    public int createEvent(CreateRequest request) {
        Event event = new Event(request.name(), request.dates());
        int id = database.size() + 1;
        event.setId(id);
        database.add(event);
        return event.getId();
    }
}
