package com.openclassrooms.mareu.service;

import com.openclassrooms.mareu.model.Meeting;

import java.util.List;

/**
 * API service to handle Meetings data
 */
public interface MeetingsApiService {

    /**
     * Get all the Meetings
     * @return {@link List}
     */
    List<Meeting> getMeetings();

    /**
     * Add a Meeting
     * @param meeting Meeting to add
     */
    void addMeeting(Meeting meeting);

    /**
     * Delete a Meeting
     * @param meeting Meeting to delete
     */
    void deleteMeeting(Meeting meeting);

}

