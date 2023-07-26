package com.openclassrooms.mareu.meetings;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import com.openclassrooms.mareu.R;
import com.openclassrooms.mareu.base.BaseIntegrationTest;

import org.junit.Test;

public class NotEmptyInitialListTest extends BaseIntegrationTest {

    /**
     * Test the meetings list is not empty
     */
    @Test
    public void meetingsListTest_shouldNotBeEmpty() {
        onView(allOf(withId(R.id.fragment_meetings_recycler_view), isDisplayed()))
                .check(matches(hasMinimumChildCount(1)));
    }

}
