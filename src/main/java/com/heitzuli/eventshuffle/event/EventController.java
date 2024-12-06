package com.heitzuli.eventshuffle.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService; // Dependency gets injected by Spring
    }

    @GetMapping(path = "/list", produces = "application/json")
    public EventList getEventList() {
        // Create new event list from the events in the service
        return new EventList(eventService.getEvents());
    }
}
