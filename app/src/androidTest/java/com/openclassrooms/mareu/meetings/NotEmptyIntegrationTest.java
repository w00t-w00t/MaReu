package com.openclassrooms.mareu.meetings;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.openclassrooms.mareu.utils.RecyclerViewCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;

import com.openclassrooms.mareu.R;
import com.openclassrooms.mareu.base.BaseIntegrationTest;

import org.junit.Test;

public class NotEmptyIntegrationTest extends BaseIntegrationTest {

    @Test
    public void meetingsListTest_shouldContainFourMeetings() {
        onView(allOf(withId(R.id.fragment_meetings_recycler_view), isDisplayed()))
                .check(withItemCount(4));
    }

}

