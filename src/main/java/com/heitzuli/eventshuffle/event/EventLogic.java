package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EventLogic {
    public static Map<LocalDate, Set<String>> findSuitableDates(Event event) {
        var votes = event.getVotes();

        int maxVotes = getMaxVotes(votes);

        // Create empty map
        Map<LocalDate, Set<String>> popularVote = new HashMap<>();
        // Loop through all dates
        for (LocalDate date : votes.keySet()) {
            // If date has max amount of votes
            if (votes.get(date).size() == maxVotes) {
                // Add to map
                popularVote.put(date, votes.get(date));
            }
        }
        return popularVote;
    }

    private static int getMaxVotes(Map<LocalDate, Set<String>> votes) {
        int maxVotes = 0;

        // Iterate through votes
        for (Map.Entry<LocalDate, Set<String>> entry : votes.entrySet()) {
            Set<String> voters = entry.getValue();
            int voterCount = voters.size(); // Count voters for the current date

            // Check if this date has more voters than the current maximum
            if (voterCount > maxVotes) {
                maxVotes = voterCount;
            }
        }
        return maxVotes;
    }
}
