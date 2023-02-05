package com.openclassrooms.mareu.repository;

import androidx.lifecycle.LiveData;

import com.openclassrooms.mareu.dao.PersonDao;
import com.openclassrooms.mareu.model.Person;

import java.util.Set;

/**
 * Repository used by the MVVM "add persons" UI dialog
 */

public class PersonListRepository {

    // act mainly as a proxy between the UI and the DAO

    private PersonDao mPersonDao;

    public PersonListRepository(PersonDao personDao) {
        mPersonDao = personDao;
    }

    public void createPerson(Person person){
        mPersonDao.createPerson(person);
    }

    public LiveData<Set<Person>> getPersons(){
        return mPersonDao.getPersons();
    }

}

