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

public class FilterIntegrationTest extends BaseIntegrationTest {

    @Test
    public void meetingsListTest_filterAction_shouldHideItem() {
        final int EXPECTED_MEETINGS_COUNT = 4;

        // expand the filters card view
        onView(allOf(withId(R.id.fragment_meetings_card_view_filter), isDisplayed()))
                .perform(click());

        // check if the filter by place is displayed
        onView(allOf(
                matcherFactory.childAtPosition(
                        matcherFactory.childAtPosition(
                                withId(R.id.fragment_meetings_card_view_filter_place), 0
                        ),
                        0),
                isDisplayed()
        ))
                // set the place filter to Salle
                .perform(replaceText("Salle"), closeSoftKeyboard());

        // validate the filters
        onView(allOf(withId(R.id.fragment_meetings_card_view_filter_apply_btn), isDisplayed()))
                .perform(click());

        // check the count output
        onView(allOf(withId(R.id.fragment_meetings_recycler_view), isDisplayed()))
                .check(withItemCount(EXPECTED_MEETINGS_COUNT));

    }

}
