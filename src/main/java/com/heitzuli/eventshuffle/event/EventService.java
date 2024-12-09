package com.heitzuli.eventshuffle.event;

import com.heitzuli.eventshuffle.event.model.Event;
import com.heitzuli.eventshuffle.event.model.EventDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EventService {
    // Mock database until I figure out how repositories work
    private static final Set<Event> database = new HashSet<>();

    public Set<Event> getEvents() {
        return database;
    }

    public int createEvent(CreateRequest request) {
        // Convert dates form the request into event dates
        var eventDates = request.dates().stream()
                .map(date -> new EventDate(date, new HashSet<>()))
                .collect(Collectors.toSet());
        Event event = new Event(request.name(), eventDates);
        int id = database.size() + 1;
        event.setId(id);
        database.add(event);
        return event.getId();
    }

    public Event getEvent(int id) {
        return database.stream()
                .filter(event -> event.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Event vote(int id, VoteRequest request) {
        Event event = getEvent(id);
        if (event == null) {
            return null;
        }
        for (LocalDate vote : request.votes()) {
            event.addVote(request.name(), vote);
        }
        return event;
    }

    public VoteResult getResult(int id) {
        Event event = getEvent(id);
        if (event == null) {
            return null;
        }
        var suitableDates = EventLogic.findSuitableDates(event);
        return new VoteResult(id, event.getName(), suitableDates);
    }
}
