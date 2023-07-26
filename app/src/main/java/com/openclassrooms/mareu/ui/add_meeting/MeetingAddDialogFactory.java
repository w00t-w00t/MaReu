package com.openclassrooms.mareu.ui.add_meeting;

import com.openclassrooms.mareu.repository.fake.MeetingRegistrationFakeRepository;

/**
 * Factory for the MeetingRegistrationDialog
 */
public class MeetingAddDialogFactory {

    /**
     * Create a MeetingRegistrationDialogFragment
     * @return the MeetingRegistrationDialogFragment
     */
    public MeetingAddDialogFragment getFragment(){

        // create the model
        MeetingAddDialogContract.Model model = new MeetingRegistrationFakeRepository();

        // create the fragment (view)
        MeetingAddDialogFragment fragment = MeetingAddDialogFragment.newInstance();

        // create the presenter
        new MeetingAddDialogPresenter(fragment, model);

        // return the fragment
        return fragment;

    }

}

