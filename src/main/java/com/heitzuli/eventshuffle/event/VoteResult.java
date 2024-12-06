package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

// This record only exists so we can write "suitableDate" in the REST response
public record VoteResult(int id, String name, Map<LocalDate, Set<String>> suitableDates) { }
