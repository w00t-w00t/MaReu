package com.openclassrooms.mareu.base;

import com.openclassrooms.mareu.di.DI;
import com.openclassrooms.mareu.model.Meeting;
import com.openclassrooms.mareu.model.Person;
import com.openclassrooms.mareu.model.Place;
import com.openclassrooms.mareu.service.MeetingsApiService;
import com.openclassrooms.mareu.utils.DateEasy;

import org.junit.Before;

import java.time.Instant;

public abstract class BaseUnitTest {

    /**
     * MeetingsApiService object as a base for testing
     */
    protected MeetingsApiService mMeetingsApiService;

    /**
     * List of four concrete meetings as a base for testing
     */
    protected Meeting mMeetingOne;
    protected Meeting mMeetingTwo;
    protected Meeting mMeetingThree;
    protected Meeting mMeetingFour;

    /**
     * Instantiate the service, and the four concrete meetings
     */
    @Before
    public void setup() {
        // instantiate the MeetingsApiService object
        mMeetingsApiService = DI.getNewInstanceMeetingsApiService();

        // create two places
        Place placeOne = new Place("Salle conférence A");
        Place placeTwo = new Place("Salle conférence B");

        // create four persons
        Person personOne = new Person("jean@entreprise.fr");
        Person personTwo = new Person("luc@entreprise.fr");
        Person personThree = new Person("dora@entreprise.fr");
        Person personFour = new Person("lucie@entreprise.fr");

        // Create dates depending on the current time
        // to successfully pass the filters (now and now + 1 year)
        Instant now = DateEasy.now();
        Instant date1 = DateEasy.plusDays(now,10);
        Instant date2 = DateEasy.plusDays(now,20);
        Instant date3 = DateEasy.plusDays(now,30);
        Instant date4 = DateEasy.plusDays(now,40);

        // create the first meeting
        mMeetingOne = new Meeting(
                date1,
                "Réunion de service",
                placeOne,
                personOne,
                personTwo
        );

        // create the second meeting
        mMeetingTwo = new Meeting(
                date2,
                "Atelier technique Android",
                placeOne,
                personTwo,
                personThree,
                personFour
        );

        // create the third meeting
        mMeetingThree = new Meeting(
                date3,
                "Afterwork Repas Noel",
                placeTwo,
                personOne,
                personTwo,
                personThree,
                personFour
        );

        // create the fourth meeting
        mMeetingFour = new Meeting(
                date4,
                "Mise en exploitaion MaReu",
                placeTwo,
                personThree,
                personFour
        );

    }

}
