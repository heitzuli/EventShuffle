package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.Set;

public record VoteRequest(String name, Set<LocalDate> votes) { }
