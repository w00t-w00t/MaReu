package com.openclassrooms.mareu.ui.meetings_registration;

/**
 * Factory for the MeetingRegistrationDialog
 */
public class MeetingRegistrationDialogFactory {

    /**
     * Create a MeetingRegistrationDialogFragment
     * @return the MeetingRegistrationDialogFragment
     */
    public MeetingRegistrationDialogFragment getFragment(){

        // create the model
        MeetingRegistrationDialogContract.Model model = new MeetingRegistrationDialogModel();

        // create the fragment (view)
        MeetingRegistrationDialogFragment fragment = MeetingRegistrationDialogFragment.newInstance();

        // create the presenter
        new MeetingRegistrationDialogPresenter(fragment, model);

        // return the fragment
        return fragment;

    }

}

