package com.openclassrooms.mareu.ui.add_meeting;

import androidx.annotation.NonNull;

import com.openclassrooms.mareu.model.Person;
import com.openclassrooms.mareu.utils.DateEasy;
import com.openclassrooms.mareu.utils.PersonsListFormatter;

import java.time.Instant;
import java.util.Set;

/**
 * The presenter for the MeetingRegistrationDialog
 */
public class AddMeetingDialogPresenter implements AddMeetingDialogContract.Presenter {

    /**
     * The view
     */
    private final AddMeetingDialogContract.View mView;

    /**
     * The model
     */
    private final AddMeetingDialogContract.Model mModel;

    /**
    * Constructor for the presenter
    * @param view the view
    * @param model the model
    */
    public AddMeetingDialogPresenter(
            @NonNull AddMeetingDialogContract.View view,
            @NonNull AddMeetingDialogContract.Model model) {
        // initialize the view
        mView = view;
        // initialize the model
        mModel = model;
        // important : immediately attach the presenter to the view
        mView.attachPresenter(this);
    }

    /**
     * When the view is created (or recreated)
     */
    @Override
    public void onResumeRequest() {
        // refresh the persons invited to the meeting
        onPersonsChanged(mModel.getInvitedPersons());
        // refresh the meeting date
        mView.updateMeetingDate(mModel.getMeetingDate());
    }

    /**
     * View ask the presenter to create a meeting
     * @param topic the topic of the meeting
     * @param dateText the meeting date
     * @param place the place of the meeting
     */
    @Override
    public void onCreateMeetingRequest(String topic, String dateText, String place) {

        // declare a date, in order to parse it from text
        Instant meetingDate = null;

        // check for error
        boolean isError = false;

        // check if the place is empty
        if (place.isEmpty()) {
            // the place is empty
            isError = true;
            // display the error
            mView.setErrorPlaceIsEmpty();
        }

        // check if the topic is empty
        if (topic.isEmpty()) {
            // the topic is empty
            isError = true;
            // display the error
            mView.setErrorTopicIsEmpty();
        }

        // check if the date is empty
        if (dateText.isEmpty()) {
            // the date is empty
            isError = true;
            // display the error
            mView.setErrorDateIsEmpty();
        // try to parse the date to proper instant
        } else if ((meetingDate = DateEasy.parseDateTimeStringToInstant(dateText)) == null) {
            // the date has wrong format
            isError = true;
            // display the error
            mView.setErrorDateIsInWrongFormat();
        }

        // if there is no error
        if (!isError) {
            // save the date
            mModel.saveMeetingDate(meetingDate);
            // save the meeting
            mModel.saveMeeting(place, topic);
            // return to the meeting list
            mView.returnBackToMeetings();
        }
    }

    /**
     * Method call by the view, when the user click on the date field
     * @param meetingDateTextInput the date text input
     */
    @Override
    public void onMeetingDatePickRequest(String meetingDateTextInput) {
        // save the date to the model
        mModel.saveMeetingDate(DateEasy.parseDateTimeOrDateOrReturnNow(meetingDateTextInput));
        // update the view meeting date
        mView.updateMeetingDate(mModel.getMeetingDate());
        // trigger (show) the date picker dialog
        mView.triggerDatePickerDialog(mModel.getMeetingDate());
    }

    /**
     * Method call by the view, when a date is selected by the user
     * @param date the meeting date
     */
    @Override
    public void onMeetingDateSelected(Instant date) {
        // save the date to the model
        mModel.saveMeetingDate(date);
        // update the view meeting date
        mView.updateMeetingDate(mModel.getMeetingDate());
        // trigger (show) the TIME picker dialog, in order for the user to choose the time
        mView.triggerTimePickerDialog(mModel.getMeetingDate());
    }

    /**
     * Method call by the view, when a time is selected by the user
     * @param mergedDateAndTime the merged date and time
     */
    @Override
    public void onMeetingTimeSelected(Instant mergedDateAndTime) {
        // save the resulting merged date and time to the model
        mModel.saveMeetingDate(mergedDateAndTime);
        // update the view meeting date
        mView.updateMeetingDate(mModel.getMeetingDate());
    }

    /**
     * Method call by the view, when the user click to ask for adding persons invited to the meeting
     */
    @Override
    public void onAddPersonsRequest() {
        mView.triggerAddPersonsDialog(mModel.getInvitedPersons());
    }

    /**
     * The view give us back the persons invited to the meeting
     * @param persons the persons invited to the meeting
     */
    @Override
    public void onPersonsChanged(Set<Person> persons) {
        // save the persons
        mModel.saveInvitedPersons(persons);
        // create persons formatter
        PersonsListFormatter personsListFormatter = new PersonsListFormatter(persons);
        // update the view (list of persons invited to the meeting) accordingly
        mView.updatePersonsInvitedToTheMeeting(personsListFormatter.format());
    }

    /**
     * Init the view, and show it!
     */
    @Override
    public void init() {
        mView.showDialog();
    }
}

