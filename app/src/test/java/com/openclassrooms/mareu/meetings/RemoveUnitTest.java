package com.openclassrooms.mareu.meetings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.mareu.base.BaseUnitTest;

import org.junit.Test;

public class RemoveUnitTest extends BaseUnitTest {

    /**
     * Test the meetings are correctly deleted from the service
     */
    @Test
    public void deleteMeetings(){
        // add the first meeting to the service
        mMeetingsApiService.addMeeting(mMeetingOne);
        // check the first service is correctly added
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingOne));
        // add the second meeting to the service
        mMeetingsApiService.addMeeting(mMeetingTwo);
        // check the second service is correctly added
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingTwo));
        // add the third meeting to the service
        mMeetingsApiService.addMeeting(mMeetingThree);
        // check the third service is correctly added
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingThree));
        // add the fourth meeting to the service
        mMeetingsApiService.addMeeting(mMeetingFour);
        // check the fourth service is correctly added
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingFour));

        // delete the first meeting
        mMeetingsApiService.deleteMeeting(mMeetingOne);
        // check if the meeting is not in the list
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingOne));
        // check if the other meetings are still in the list
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingTwo));
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingThree));
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingFour));

        // delete the second meeting
        mMeetingsApiService.deleteMeeting(mMeetingTwo);
        // check if the two first meeting are not in the list
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingOne));
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingTwo));
        // check if the other meetings are still in the list
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingThree));
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingFour));

        // delete the third meeting
        mMeetingsApiService.deleteMeeting(mMeetingThree);
        // check if the three first meeting are not in the list
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingOne));
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingTwo));
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingThree));
        // check if the other meetings are still in the list
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingFour));

        // delete the fourth meeting
        mMeetingsApiService.deleteMeeting(mMeetingFour);
        // check if the four first meeting are not in the list
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingOne));
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingTwo));
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingThree));
        assertFalse(mMeetingsApiService.getMeetings().contains(mMeetingFour));

    }

}
