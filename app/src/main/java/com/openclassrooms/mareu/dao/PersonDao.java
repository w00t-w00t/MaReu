package com.openclassrooms.mareu.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.openclassrooms.mareu.model.Person;

import java.util.Set;

/**
 * DAO used by the MVVM "add persons" UI dialog
 */

public class PersonDao {

    // dao might use one or more model services

    private final MutableLiveData<Set<Person>> currentPersons;

    public PersonDao() {
        currentPersons = new MutableLiveData<>();
    }

    public LiveData<Set<Person>> getPersons() {
        return currentPersons;
    }

    public void setPersons(Set<Person> initialPersons) {
        currentPersons.setValue(initialPersons);
    }

    public void createPerson(Person person) {
        currentPersons.getValue().add(person);
        currentPersons.setValue(currentPersons.getValue());
    }

}
