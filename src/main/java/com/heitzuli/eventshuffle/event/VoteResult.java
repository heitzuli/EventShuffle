package com.heitzuli.eventshuffle.event;

import com.heitzuli.eventshuffle.event.model.EventDate;

import java.util.Set;

// This record only exists so we can write "suitableDate" in the REST response
public record VoteResult(int id, String name, Set<EventDate> suitableDates) { }
