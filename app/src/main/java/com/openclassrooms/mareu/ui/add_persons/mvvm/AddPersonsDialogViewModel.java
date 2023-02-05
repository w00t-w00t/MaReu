package com.openclassrooms.mareu.ui.add_persons.mvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.openclassrooms.mareu.model.Person;

import java.util.Set;

public class AddPersonsDialogViewModel extends ViewModel {

    private final MutableLiveData<Set<Person>> currentPersons;

    public AddPersonsDialogViewModel() {
        currentPersons = new MutableLiveData<>();
    }

    public LiveData<Set<Person>> getPersons() {
        return currentPersons;
    }

    public void setPersons(Set<Person> initialPersons) {
        currentPersons.setValue(initialPersons);
    }

    public void addPerson(Person person) {
        currentPersons.getValue().add(person);
        currentPersons.setValue(currentPersons.getValue());
    }

}

