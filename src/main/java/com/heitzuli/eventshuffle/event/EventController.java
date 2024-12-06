package com.heitzuli.eventshuffle.event;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "", produces = "application/json")
    public CreateResponse createEvent(@RequestBody CreateRequest request) {
        var id = eventService.createEvent(request);
        return new CreateResponse(id);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Event getEvent(@PathVariable int id) {
        return eventService.getEvent(id);
    }

    @PostMapping(path = "/{id}/vote", produces = "application/json")
    public Event voteEvent(@PathVariable int id, @RequestBody VoteRequest request) {
        return eventService.vote(id, request);
    }
}
