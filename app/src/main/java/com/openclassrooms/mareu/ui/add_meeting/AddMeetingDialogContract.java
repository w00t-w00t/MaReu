package com.openclassrooms.mareu.ui.add_meeting;

import com.openclassrooms.mareu.core.SimpleMvp;
import com.openclassrooms.mareu.model.Person;

import java.time.Instant;
import java.util.Set;

/**
 * MeetingRegistration MVP Contract
 * Contract between the view and the presenter
 * Contract between the presenter and the model
 */
public interface AddMeetingDialogContract {

    /**
     * Model interface
     */
    interface Model extends SimpleMvp.Model {
        // save the date of the meeting
        void saveMeetingDate(Instant meetingDate);

        // save the persons invited to the meeting
        void saveInvitedPersons(Set<Person> persons);

        // save the meeting
        void saveMeeting(String place, String subject);

        // get the meeting date
        Instant getMeetingDate();

        // get the persons invited to the meeting
        Set<Person> getInvitedPersons();
    }

    /**
     * View interface
     */
    interface View extends SimpleMvp.View<Presenter> {

        // show the meeting registration dialog to the screen
        void showDialog();

        // dismiss the meeting registration dialog
        void returnBackToMeetings();

        // update the meeting date
        void updateMeetingDate(Instant meetingDate);

        // update the persons invited to the meeting
        void updatePersonsInvitedToTheMeeting(String personsFlattenList);

        // the topic must be set
        void setErrorTopicIsEmpty();
        // the place must be set
        void setErrorPlaceIsEmpty();
        // the date must be set
        void setErrorDateIsEmpty();
        // the date is in the wrong format (see DateEasy utils class)
        void setErrorDateIsInWrongFormat();

        // trigger the view to launch the date picker dialog
        void triggerDatePickerDialog(Instant meetingDate);
        // trigger the view to launch the time picker dialog
        void triggerTimePickerDialog(Instant meetingDate);
        // trigger the view to launch the add persons dialog
        void triggerAddPersonsDialog(Set<Person> initialPersons);

    }

    /**
     * Presenter interface
     */
    interface Presenter extends SimpleMvp.Presenter {

        // on resume view request (after screen rotation)
        void onResumeRequest();

        // method called when the user click on the save toolbar button, to persist the meeting
        void onCreateMeetingRequest(String topic, String meetingDateTextInput, String place);

        // method called when the user click on the date text input, to launch the date picker dialog
        void onMeetingDatePickRequest(String meetingDateTextInput);

        // method called when the user has selected a date in the date picker dialog
        void onMeetingDateSelected(Instant date);

        // method called when the user has selected a time in the time picker dialog
        void onMeetingTimeSelected(Instant mergedDateAndTime);

        // method called when the user click on the persons text input, to launch the add persons dialog
        void onAddPersonsRequest();

        // method called when the user has selected persons in the add persons dialog
        void onPersonsChanged(Set<Person> persons);
    }
}
