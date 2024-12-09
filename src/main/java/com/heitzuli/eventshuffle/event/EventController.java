package com.heitzuli.eventshuffle.event;

import com.heitzuli.eventshuffle.event.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        var event = eventService.getEvent(id);
        if (event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return event;
    }

    @PostMapping(path = "/{id}/vote", produces = "application/json")
    public Event voteEvent(@PathVariable int id, @RequestBody VoteRequest request) {
        var event = eventService.vote(id, request);
        if (event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return event;
    }

    @GetMapping(path = "/{id}/results", produces = "application/json")
    public VoteResult getResult(@PathVariable int id) {
        var event = eventService.getResult(id);
        if (event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return event;
    }
}
