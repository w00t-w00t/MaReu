package com.openclassrooms.mareu.ui.add_persons;

import com.openclassrooms.mareu.model.Person;

import java.util.Set;

/**
 * Factory to create AddPersonsDialogFragment
 */
public class AddPersonsDialogFactory implements AddPersonsDialogFactoryContract {

    /**
     * Create a new instance of AddPersonsDialogFragment
     * @param initialPersons the initial persons to display
     * @param onPersonsSetFinalChangedListener the listener to call when final persons set changed
     * @return the new instance of AddPersonsDialogFragment
     */

    @Override
    public AddPersonsDialogDisplayable getFragment(
            Set<Person> initialPersons,
            OnPersonsSetFinalChangedListener
                    onPersonsSetFinalChangedListener){

        // /!\ suppose we pass this property by configuration
        final String PATTERN_CHOSEN = "MVVM";

        return getFragment(initialPersons, onPersonsSetFinalChangedListener, PATTERN_CHOSEN);

    }

    @Override
    public AddPersonsDialogDisplayable getFragment(
            Set<Person> initialPersons,
            OnPersonsSetFinalChangedListener
                    onPersonsSetFinalChangedListener,
            String patternToUse){

        AddPersonsDialogDisplayable displayable = null;

        if(patternToUse.equals("MVP")){

            // create the model
            com.openclassrooms.mareu.ui.add_persons.mvp.AddPersonsDialogContract.Model model =
                    new com.openclassrooms.mareu.ui.add_persons.mvp.AddPersonsDialogModel();
            model.setInitialPersons(initialPersons);
            model.setOnPersonsSetFinalChangedListener(
                    onPersonsSetFinalChangedListener::onPersonsListFinalChanged
            );

            // create the fragment (view)
            com.openclassrooms.mareu.ui.add_persons.mvp.AddPersonsDialogFragment fragment =
                com.openclassrooms.mareu.ui.add_persons.mvp.AddPersonsDialogFragment.newInstance();

            // create the presenter
            new com.openclassrooms.mareu.ui.add_persons.mvp.AddPersonsDialogPresenter(
                    fragment,
                    model
            );

            // export the fragment as a displayable abstract object
            displayable = fragment;

        } else if( patternToUse.equals("MVVM")) {

            // create the ViewModel
            com.openclassrooms.mareu.ui.add_persons.mvvm.AddPersonsDialogViewModel viewModel =
                    new com.openclassrooms.mareu.ui.add_persons.mvvm.AddPersonsDialogViewModel();

            // create the View (fragment)
            com.openclassrooms.mareu.ui.add_persons.mvvm.AddPersonsDialogFragment fragment =
                    new com.openclassrooms.mareu.ui.add_persons.mvvm.AddPersonsDialogFragment(
                        viewModel,
                            () -> onPersonsSetFinalChangedListener.onPersonsListFinalChanged(
                                    viewModel.getPersons().getValue()
                            )
                    );

            // set the initial persons
            viewModel.setPersons(initialPersons);

            // export the fragment as a displayable abstract object
            displayable = fragment;

        } else {
            throw new IllegalArgumentException("Unknown pattern chosen");
        }

        // return the fragment
        return displayable;
    }

}
