package com.heitzuli.eventshuffle.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    @DisplayName("Adds a vote")
    void addVote() {
        // create new event
        Set<LocalDate> dates = new HashSet<>();
        LocalDate date = LocalDate.parse("2020-01-01");
        dates.add(date);
        Event event = new Event("X", dates);
        // add vote with name X
        event.addVote("Bob", Set.of(date));

        assertTrue(event.getVotes().containsKey(date)); // Date is present
        assertTrue(event.getVotes().get(date).contains("Bob")); // Person is present
    }

    @Test
    @DisplayName("Throws an exception if person has already voted")
    void duplicatePerson() {
        // create new event
        Set<LocalDate> dates = new HashSet<>();
        LocalDate date = LocalDate.parse("2020-01-01");
        dates.add(date);
        Event event = new Event("X", dates);
        // add vote with name X
        event.addVote("Bob", Set.of(date));

        assertThrows(IllegalArgumentException.class, () -> event.addVote("Bob", Set.of(date)));
    }
}