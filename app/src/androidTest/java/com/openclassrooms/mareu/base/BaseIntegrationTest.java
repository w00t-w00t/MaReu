package com.openclassrooms.mareu.base;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.core.IsNull.notNullValue;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.openclassrooms.mareu.R;
import com.openclassrooms.mareu.di.DI;
import com.openclassrooms.mareu.model.Meeting;
import com.openclassrooms.mareu.model.Person;
import com.openclassrooms.mareu.model.Place;
import com.openclassrooms.mareu.service.MeetingsApiService;
import com.openclassrooms.mareu.ui.main.MainActivity;
import com.openclassrooms.mareu.utils.DateEasy;
import com.openclassrooms.mareu.utils.MatcherFactory;

import org.junit.Before;
import org.junit.Rule;

import java.time.Instant;

public class BaseIntegrationTest {

    /**
     * The meetings
     */
    protected Meeting meetingOne;
    protected Meeting meetingTwo;
    protected Meeting meetingThree;
    protected Meeting meetingFour;


    /**
     * The simplest scenario rule possible
     */
    @Rule
    public ActivityScenarioRule<MainActivity> mActivityTestRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Declare the API service
     */
    protected MeetingsApiService service;


    /**
     * Matcher factory
     */
    protected MatcherFactory matcherFactory = new MatcherFactory();

    /**
     * Initialize the meetings
     */
    @Before
    public void setUp() {

        // Assert that we can correctly get the main activity
        mActivityTestRule.getScenario().onActivity(activity -> {
            assertThat(activity, notNullValue());
        });

        // Get the API service
        service = DI.getMeetingsApiService();

        // assert service is not null
        assertThat(service, notNullValue());

        // Build the places
        Place placeOne = new Place("Salle conference A");
        Place placeTwo = new Place("Salle conference B");

        // Build the persons
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

        // Build the meetings
        meetingOne = new Meeting(
                date1,
                "Réunion de service",
                placeOne,
                personOne,
                personTwo
        );

        meetingTwo = new Meeting(
                date2,
                "Atelier technique Android",
                placeOne,
                personTwo,
                personThree,
                personFour
        );

        meetingThree = new Meeting(
                date3,
                "Afterwork Repas Noel",
                placeTwo,
                personOne,
                personTwo,
                personThree,
                personFour
        );

        meetingFour = new Meeting(
                date4,
                "Mise en exploitaion MaReu",
                placeTwo,
                personThree,
                personFour
        );

        // add the meetings to the API service
        service.getMeetings().clear();
        service.addMeeting(meetingOne);
        service.addMeeting(meetingTwo);
        service.addMeeting(meetingThree);
        service.addMeeting(meetingFour);

        // expand and collapse the filters, to see them on screen before the test start
        onView(allOf(withId(R.id.fragment_meetings_card_view_filter), isDisplayed()))
                .perform(click());
        onView(allOf(withId(R.id.fragment_meetings_card_view_filter), isDisplayed()))
                .perform(click());
    }



}
