package com.openclassrooms.mareu.ui.meetings_registration;

import com.openclassrooms.mareu.di.DI;
import com.openclassrooms.mareu.model.Meeting;
import com.openclassrooms.mareu.model.Person;
import com.openclassrooms.mareu.model.Place;
import com.openclassrooms.mareu.service.MeetingsApiService;
import com.openclassrooms.mareu.utils.DateEasy;

import java.time.Instant;
import java.util.Set;
import java.util.TreeSet;

/**
 * Model for MeetingRegistration
 * Note that this dummy model, in a real app, would be placed in a repository
 */
public class MeetingRegistrationDialogModel implements MeetingRegistrationDialogContract.Model {

    /**
     * The meeting date
     */
    private Instant mMeetingDate = DateEasy.now();

    /**
     * The persons invited to the meeting
     */
    private Set<Person> mPersonsInvitedToTheMeeting = new TreeSet<>();

    /**
     * The API service
     */
    private final MeetingsApiService mApiService = DI.getMeetingsApiService();

    /**
     * Update the meeting date
     * @param meetingDate the meeting date
     */
    @Override
    public void saveMeetingDate(Instant meetingDate) {
        mMeetingDate = meetingDate;
    }

    /**
     * Update the persons invited to the meeting
     * @param persons the persons invited to the meeting
     */
    @Override
    public void saveInvitedPersons(Set<Person> persons) {
        mPersonsInvitedToTheMeeting = persons;
    }

    /**
     * Save the meeting to through the service
     * @param place the place of the meeting
     * @param subject the subject of the meeting
     */
    @Override
    public void saveMeeting(String place, String subject) {
        // create the meeting
        Meeting meeting = new Meeting(mMeetingDate, subject, new Place(place));
        // add the persons invited to the meeting
        for (Person person : mPersonsInvitedToTheMeeting) {
            // add the person to the meeting
            meeting.addPerson(person);
        }
        // persist the meeting through the service
        mApiService.addMeeting(meeting);
    }

    /**
     * Get the meeting date
     * @return the meeting date
     */
    @Override
    public Instant getMeetingDate() {
        return mMeetingDate;
    }

    /**
     * Get the persons invited to the meeting
     * @return the persons invited to the meeting
     */
    @Override
    public Set<Person> getInvitedPersons() {
        return mPersonsInvitedToTheMeeting;
    }
}
