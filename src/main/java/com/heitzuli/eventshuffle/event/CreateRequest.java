package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.Set;

public record CreateRequest(String name, Set<LocalDate> dates) { }
