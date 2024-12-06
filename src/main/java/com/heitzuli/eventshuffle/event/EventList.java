package com.heitzuli.eventshuffle.event;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to events in the REST API.
 * Purely cosmetic.
 */

public class EventList {
    private record ListEvent(int id, String name) { }

    private final Set<ListEvent> events = new HashSet<>();

    public EventList(Set<Event> events) {
        for (Event event : events) {
            this.events.add(new ListEvent(event.getId(), event.getName()));
        }
    }

    public Set<ListEvent> getEvents() {
        return events;
    }
}
