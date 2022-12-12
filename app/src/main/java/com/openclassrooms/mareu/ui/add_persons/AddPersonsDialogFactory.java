package com.openclassrooms.mareu.ui.add_persons;

import com.openclassrooms.mareu.model.Person;

import java.util.Set;

/**
 * Factory to create AddPersonsDialogFragment
 */
public class AddPersonsDialogFactory {

    /**
     * Create a new instance of AddPersonsDialogFragment
     * @param initialPersons the initial persons to display
     * @param onPersonsSetFinalChangedListener the listener to call when final persons set changed
     * @return the new instance of AddPersonsDialogFragment
     */
    public AddPersonsDialogFragment getFragment(
            Set<Person> initialPersons,
            AddPersonsDialogContract.Model.OnPersonsSetFinalChangedListener
                    onPersonsSetFinalChangedListener){

        // create the model
        AddPersonsDialogContract.Model model = new AddPersonsDialogModel();
        model.setInitialPersons(initialPersons);
        model.setOnPersonsSetFinalChangedListener(onPersonsSetFinalChangedListener);

        // create the fragment (view)
        AddPersonsDialogFragment fragment = AddPersonsDialogFragment.newInstance();

        // create the presenter
        new AddPersonsDialogPresenter(fragment, model);

        // return the fragment
        return fragment;
    }
}
