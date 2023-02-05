package com.openclassrooms.mareu.ui.add_persons.mvp;

import com.openclassrooms.mareu.model.Person;

import java.util.Set;
import java.util.TreeSet;

/**
 * Model for the AddPersonsDialog
 */
public class AddPersonsDialogModel implements AddPersonsDialogContract.Model {

    /**
     * The list of (set of unique) persons
     */
    private final Set<Person> mPersonsSet = new TreeSet<>();

    /**
     * The listener to notify when the list of persons is updated
     */
    private OnPersonsSetFinalChangedListener mOnPersonsSetFinalChangedListener;

    /**
     * Get the list (set) of persons
     * @return the list (set) of persons
     */
    @Override
    public Set<Person> getPersonsSet() {
        return mPersonsSet;
    }

    /**
     * Add a person to the list (set) of persons
     * @param person the person to add
     */
    @Override
    public void addPerson(Person person) {
        mPersonsSet.add(person);
    }

    /**
     * Tell the model that's the final list of persons that is currently set
     * So we can notify the listener
     */
    @Override
    public void commit() {
        if (mOnPersonsSetFinalChangedListener != null) {
            mOnPersonsSetFinalChangedListener.onPersonsListFinalChanged(mPersonsSet);
        }
    }

    @Override
    public void setInitialPersons(Set<Person> initialPersons) {
        mPersonsSet.clear();
        mPersonsSet.addAll(initialPersons);
    }

    /**
     * Set the listener to notify when the list of persons is updated
     * @param onPersonsSetFinalChangedListener the listener
     */
    public void setOnPersonsSetFinalChangedListener(
            OnPersonsSetFinalChangedListener onPersonsSetFinalChangedListener) {
        mOnPersonsSetFinalChangedListener = onPersonsSetFinalChangedListener;
    }
}