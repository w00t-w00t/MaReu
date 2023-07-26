package com.openclassrooms.mareu.meetings;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.mareu.utils.RecyclerViewCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;

import com.openclassrooms.mareu.R;
import com.openclassrooms.mareu.base.BaseIntegrationTest;

import org.junit.Test;

public class AddIntegrationTest extends BaseIntegrationTest {

    /**
     * Test a meeting has been successfully added
     */

    @Test
    public void meetingsListTest_createAction_shouldAddItem() {
        final int EXPECTED_ITEM_COUNT = 5;

        // click to add a meeting, and open the meeting registration form/dialog
        onView(allOf(withId(R.id.activity_meetings_add_meeting_fab), isDisplayed()))
                .perform(click());

        // fill the meeting registration form/dialog (set the subject)
        onView(allOf(matcherFactory.childAtPosition(
                        matcherFactory.childAtPosition(
                                withId(R.id.fragment_meeting_registration_subject_text_input), 0
                        ),
                        0
                ),
                isDisplayed()
        ))
                .perform(replaceText("The subject"), closeSoftKeyboard());

        // fill the meeting registration form/dialog (set the place)
        onView(allOf(
                matcherFactory.childAtPosition(
                        matcherFactory.childAtPosition(
                                withId(R.id.fragment_meeting_registration_place_text_input), 0
                        ),
                        0
                ),
                isDisplayed()
        ))
                .perform(replaceText("A place"), closeSoftKeyboard());

        // perform save action on the toolbar
        onView(allOf(withId(R.id.meeting_creation_dialog_toolbar_save_item), isDisplayed()))
                .perform(click());

        // check the meeting has been added
        onView(allOf(withId(R.id.fragment_meetings_recycler_view), isDisplayed()))
                .check(withItemCount(EXPECTED_ITEM_COUNT));

    }

}
