package com.openclassrooms.mareu.meetings;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.mareu.utils.RecyclerViewCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;

import com.openclassrooms.mareu.R;
import com.openclassrooms.mareu.base.BaseIntegrationTest;
import com.openclassrooms.mareu.utils.DropViewAction;

import org.junit.Test;

public class DeleteIntegrationTest extends BaseIntegrationTest {

    /**
     * Test the meetings drop meeting action on the list (recycler view)
     */
    @Test
    public void meetingsListTest_deleteAction_shouldRemoveItem() {
        final int EXPECTED_MEETINGS_COUNT = 3;
        final int DROP_MEETING_AT_POSITION = 2;

        onView(allOf(withId(R.id.fragment_meetings_recycler_view), isDisplayed()))
                .perform(actionOnItemAtPosition(DROP_MEETING_AT_POSITION, new DropViewAction()))
                .check(withItemCount(EXPECTED_MEETINGS_COUNT));
    }

}
