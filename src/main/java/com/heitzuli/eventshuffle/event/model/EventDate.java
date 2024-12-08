package com.heitzuli.eventshuffle.event.model;

import java.time.LocalDate;
import java.util.Set;

public record EventDate(LocalDate date, Set<String> people) {
}
