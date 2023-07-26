package com.openclassrooms.mareu.meetings;

import static org.junit.Assert.assertEquals;

import com.openclassrooms.mareu.base.BaseUnitTest;
import com.openclassrooms.mareu.model.Meeting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GetUnitTest extends BaseUnitTest {

    /**
     * Test if the meeting service has four meetings (after adding four meetings)
     */
    @Test
    public void getMeetings(){
        // add four meetings to the service
        mMeetingsApiService.addMeeting(mMeetingOne);
        mMeetingsApiService.addMeeting(mMeetingTwo);
        mMeetingsApiService.addMeeting(mMeetingThree);
        mMeetingsApiService.addMeeting(mMeetingFour);

        // add four meetings to a list
        List<Meeting> expectedMeetings = new ArrayList<>();
        expectedMeetings.add(mMeetingOne);
        expectedMeetings.add(mMeetingTwo);
        expectedMeetings.add(mMeetingThree);
        expectedMeetings.add(mMeetingFour);

        // get the list of meetings from the service
        List<Meeting> actualMeetings = mMeetingsApiService.getMeetings();

        // check if the two lists are equal
        assertEquals(actualMeetings,expectedMeetings);
    }

}
