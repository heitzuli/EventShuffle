package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EventLogic {
    public static Map<LocalDate, Set<String>> findSuitableDates(Event event) {
        var votes = event.getVotes();

        // Variables to track the date with the most voters
        LocalDate mostVotedDate = null;
        int maxVotes = 0;

        // For-loop to iterate through the map entries
        for (Map.Entry<LocalDate, Set<String>> entry : votes.entrySet()) {
            LocalDate date = entry.getKey();
            Set<String> voters = entry.getValue();
            int voterCount = voters.size(); // Count voters for the current date

            // Check if this date has more voters than the current maximum
            if (voterCount > maxVotes) {
                maxVotes = voterCount;
                mostVotedDate = date;
            }
        }

        Map<LocalDate, Set<String>> popularVote = new HashMap<>();
        popularVote.put(mostVotedDate, votes.get(mostVotedDate));
        return popularVote;
    }
}
