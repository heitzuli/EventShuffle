package com.heitzuli.eventshuffle.event;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Event {
    private int id; // ID of event
    private final String name; // name of event
    private final Set<LocalDate> dates; // date options for event
    private final Map<LocalDate, Set<String>> votes = new HashMap<>(); // per date, a set of persons

    // Event must have name, dates
    public Event(String name, Set<LocalDate> dates) {
        this.name = name;
        this.dates = dates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Set<LocalDate> getDates() {
        return dates;
    }

    public Map<LocalDate, Set<String>> getVotes() {
        return votes;
    }

    public void addVote(String person, Set<LocalDate> dates) {
        // Goes through all sets of people who voted and throws an exception if this person is in any of the sets
        var hasAlreadyVoted = votes.values().stream().anyMatch(people -> people.contains(person));
        if (hasAlreadyVoted) {
            throw new IllegalArgumentException("person " + person + " is already voted");
        }
        // all dates in the vote need to be part of the possible event dates
        var hasInvalidDate = !this.dates.containsAll(dates);
        if (hasInvalidDate) {
            throw new IllegalArgumentException("dates " + dates + " are invalid");
        }

        // Add the votes
        dates.forEach(date-> { // check existing dates if date exists
            if (!votes.containsKey(date)) { // if date doesn't exist
                votes.put(date, new HashSet<>()); // create new date
            }
            votes.get(date).add(person); // if date exists, add person
        });
    }
}
