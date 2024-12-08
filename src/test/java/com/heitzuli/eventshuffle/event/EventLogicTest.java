package com.heitzuli.eventshuffle.event;

import com.heitzuli.eventshuffle.event.model.Event;
import com.heitzuli.eventshuffle.event.model.EventDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class EventLogicTest {

    public static final LocalDate DAY1 = LocalDate.parse("1728-05-04");
    public static final LocalDate DAY2 = LocalDate.parse("1728-05-16");
    public static final LocalDate DAY3 = LocalDate.parse("1728-05-25");

    @Test
    @DisplayName("Returns only dates with the most votes")
    void returnsOnlyDatesWithTheMostVotes() {
        // Create event
        var possibleDates = new HashSet<EventDate>();
        possibleDates.add(new EventDate(DAY1, new HashSet<>()));
        possibleDates.add(new EventDate(DAY2, new HashSet<>()));
        possibleDates.add(new EventDate(DAY3, new HashSet<>()));

        Event event = new Event("Find Captain Sparrow's hat", possibleDates);

        // Make sure that both day 1 and day 3 has two votes
        event.addVote("Turner", DAY1);
        event.addVote("Anamaria", DAY1);
        event.addVote("Anamaria", DAY2);
        event.addVote("Miss Swann", DAY2);
        event.addVote("Miss Swann", DAY3);

        var suitableDates = EventLogic.findSuitableDates(event);
        assertEquals(2, suitableDates.size());
    }

    @Test
    @DisplayName("Returns the date with the most votes")
    void returnDateWithMostVotes() {
        // Create event
        var possibleDates = new HashSet<EventDate>();
        possibleDates.add(new EventDate(DAY1, new HashSet<>()));
        possibleDates.add(new EventDate(DAY2, new HashSet<>()));
        possibleDates.add(new EventDate(DAY3, new HashSet<>()));

        Event event = new Event("Find Captain Sparrow's hat", possibleDates);

        // Make sure that both day 1 and day 3 has two votes
        event.addVote("Turner", DAY1);
        event.addVote("Anamaria", DAY1);
        event.addVote("Anamaria", DAY2);
        event.addVote("Miss Swann", DAY3);

        var suitableDates = EventLogic.findSuitableDates(event);
        assertEquals(1, suitableDates.size());
    }
}