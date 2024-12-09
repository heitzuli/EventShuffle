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

    /**
     * Get all events in the database
     * @return The set if events
     */
    public Set<Event> getEvents() {
        return database;
    }

    /**
     * Create a new event
     * @param request The request with the event name and dates
     * @return The id of the created event
     */
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

    /**
     * Retrieve an event from the database
     * @param id Id of the event
     * @return The event, or null if there's no event
     */
    public Event getEvent(int id) {
        return database.stream()
                .filter(event -> event.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Vote for the event with the given ID
     * @param id The id of the event
     * @param request The vote request
     * @return the event voted on, or null if the event isn't found
     */
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

    /**
     * Get most suitable date
     * @param id The id of the event
     * @return The dates with most votes, null if the event isn't found
     */
    public VoteResult getResult(int id) {
        Event event = getEvent(id);
        if (event == null) {
            return null;
        }
        var suitableDates = EventLogic.findSuitableDates(event);
        return new VoteResult(id, event.getName(), suitableDates);
    }
}
