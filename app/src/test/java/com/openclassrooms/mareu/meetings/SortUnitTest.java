package com.openclassrooms.mareu.meetings;

import static org.junit.Assert.assertEquals;

import com.openclassrooms.mareu.base.BaseUnitTest;

import org.junit.Test;

import java.util.Collections;

public class SortUnitTest extends BaseUnitTest {

    /**
     * Test the meetings are correctly sorted by date
     */
    @Test
    public void sortMeetingsByDatetime(){

        // add four meeting to the service
        mMeetingsApiService.addMeeting(mMeetingTwo);
        mMeetingsApiService.addMeeting(mMeetingFour);
        mMeetingsApiService.addMeeting(mMeetingOne);
        mMeetingsApiService.addMeeting(mMeetingThree);

        // check if the objects are correctly unordered
        assertEquals(mMeetingOne, mMeetingsApiService.getMeetings().get(2));
        assertEquals(mMeetingTwo, mMeetingsApiService.getMeetings().get(0));
        assertEquals(mMeetingThree, mMeetingsApiService.getMeetings().get(3));
        assertEquals(mMeetingFour, mMeetingsApiService.getMeetings().get(1));

        // sort the meetings by date
        Collections.sort(mMeetingsApiService.getMeetings());

        // check if the objects are correctly ordered
        assertEquals(mMeetingOne, mMeetingsApiService.getMeetings().get(0));
        assertEquals(mMeetingTwo, mMeetingsApiService.getMeetings().get(1));
        assertEquals(mMeetingThree, mMeetingsApiService.getMeetings().get(2));
        assertEquals(mMeetingFour, mMeetingsApiService.getMeetings().get(3));
    }

}
