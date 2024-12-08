package com.heitzuli.eventshuffle.event;

import com.heitzuli.eventshuffle.event.model.Event;
import com.heitzuli.eventshuffle.event.model.EventDate;

import java.util.HashSet;
import java.util.Set;

public class EventLogic {
    public static Set<EventDate> findSuitableDates(Event event) {
        var eventDates = event.getDates();

        int maxVotes = getMaxVotes(eventDates);

        // Create empty set
        Set<EventDate> suitableDates = new HashSet<>();
        // Loop through all dates
        for (EventDate eventDate : eventDates) {
            // If date has max amount of votes
            if (eventDate.people().size() == maxVotes) {
                // Add to map
                suitableDates.add(eventDate);
            }
        }
        return suitableDates;
    }

    private static int getMaxVotes(Set<EventDate> eventDates) {
        int maxVotes = 0;

        for (EventDate eventDate : eventDates) {
            int voterCount = eventDate.people().size(); // Count voters for the current date

            // Check if this date has more voters than the current maximum
            if (voterCount > maxVotes) {
                maxVotes = voterCount;
            }
        }
        return maxVotes;
    }
}
