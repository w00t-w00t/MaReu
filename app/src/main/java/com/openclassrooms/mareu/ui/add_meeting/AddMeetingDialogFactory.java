package com.openclassrooms.mareu.ui.add_meeting;

import com.openclassrooms.mareu.repository.fake.MeetingRegistrationFakeRepository;

/**
 * Factory for the MeetingRegistrationDialog
 */
public class AddMeetingDialogFactory {

    /**
     * Create a MeetingRegistrationDialogFragment
     * @return the MeetingRegistrationDialogFragment
     */
    public AddMeetingDialogFragment getFragment(){

        // create the model
        AddMeetingDialogContract.Model model = new MeetingRegistrationFakeRepository();

        // create the fragment (view)
        AddMeetingDialogFragment fragment = AddMeetingDialogFragment.newInstance();

        // create the presenter
        new AddMeetingDialogPresenter(fragment, model);

        // return the fragment
        return fragment;

    }

}

