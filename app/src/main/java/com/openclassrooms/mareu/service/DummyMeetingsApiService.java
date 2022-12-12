package com.openclassrooms.mareu.service;

import com.openclassrooms.mareu.model.Meeting;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete implementation of {@link MeetingsApiService}
 * This implementation is a Dummy one, with static data, not related to a database
 */
public class DummyMeetingsApiService implements MeetingsApiService {

    /**
     * Static list of meetings, thanks to an ArrayList implementation
     */
    private final List<Meeting> meetings = new ArrayList<>();

    /**
     * Get meetings list
     * @return {@link List}
     */
    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    /**
     * Add a meeting
     * @param meeting {@link Meeting}
     */
    @Override
    public void addMeeting(Meeting meeting) {
        if(!meetings.contains(meeting))
            meetings.add(meeting);
    }

    /**
     * Delete a meeting
     * @param meeting {@link Meeting}
     */
    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

}
