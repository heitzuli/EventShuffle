package com.heitzuli.eventshuffle.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EventLogicTest {

    public static final LocalDate DAY1 = LocalDate.parse("1728-05-04");
    public static final LocalDate DAY2 = LocalDate.parse("1728-05-16");
    public static final LocalDate DAY3 = LocalDate.parse("1728-05-25");

    @Test
    @DisplayName("Returns only dates with the most votes")
    void returnsOnlyDatesWithTheMostVotes() {
        // Create event
        Set<LocalDate> possibleDates = Set.of(DAY1, DAY2, DAY3);

        Event event = new Event("Find Captain Sparrow's hat", possibleDates);

        // Add votes
        event.addVote("Turner", Set.of(DAY1));
        event.addVote("Barbosa", Set.of(DAY1, DAY3));

        var suitableDates = EventLogic.findSuitableDates(event);
        assertEquals(1, suitableDates.size());
        assertTrue(suitableDates.containsKey(DAY1));
        assertEquals(2, suitableDates.get(DAY1).size());
    }
}