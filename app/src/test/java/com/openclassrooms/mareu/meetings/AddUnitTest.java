package com.openclassrooms.mareu.meetings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.openclassrooms.mareu.base.BaseUnitTest;

import org.junit.Test;

public class AddUnitTest extends BaseUnitTest {

    /**
     * Test the meetings are correctly added to the service
     */
    @Test
    public void addMeetings(){

        // add four meeting to the service
        mMeetingsApiService.addMeeting(mMeetingOne);
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingOne));
        mMeetingsApiService.addMeeting(mMeetingTwo);
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingTwo));
        mMeetingsApiService.addMeeting(mMeetingThree);
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingThree));
        mMeetingsApiService.addMeeting(mMeetingFour);
        assertTrue(mMeetingsApiService.getMeetings().contains(mMeetingFour));

        // check if the objects from the service are the same as the objects created (date check)
        assertEquals(mMeetingOne.getDate(), mMeetingsApiService.getMeetings().get(0).getDate());
        assertEquals(mMeetingTwo.getDate(), mMeetingsApiService.getMeetings().get(1).getDate());
        assertEquals(mMeetingThree.getDate(), mMeetingsApiService.getMeetings().get(2).getDate());
        assertEquals(mMeetingFour.getDate(), mMeetingsApiService.getMeetings().get(3).getDate());

        // check if the objects from the service are the same as the objects created (place check)
        assertEquals(mMeetingOne.getPlace(), mMeetingsApiService.getMeetings().get(0).getPlace());
        assertEquals(mMeetingTwo.getPlace(), mMeetingsApiService.getMeetings().get(1).getPlace());
        assertEquals(mMeetingThree.getPlace(), mMeetingsApiService.getMeetings().get(2).getPlace());
        assertEquals(mMeetingFour.getPlace(), mMeetingsApiService.getMeetings().get(3).getPlace());

        // check if the objects from the service are the same as the objects created (subject check)
        assertEquals(mMeetingOne.getSubject(), mMeetingsApiService.getMeetings().get(0).getSubject());
        assertEquals(mMeetingTwo.getSubject(), mMeetingsApiService.getMeetings().get(1).getSubject());
        assertEquals(mMeetingThree.getSubject(), mMeetingsApiService.getMeetings().get(2).getSubject());
        assertEquals(mMeetingFour.getSubject(), mMeetingsApiService.getMeetings().get(3).getSubject());

        // check if the objects from the service are the same as the objects created
        // (rely on equals() method)
        assertEquals(mMeetingOne, mMeetingsApiService.getMeetings().get(0));
        assertEquals(mMeetingTwo, mMeetingsApiService.getMeetings().get(1));
        assertEquals(mMeetingThree, mMeetingsApiService.getMeetings().get(2));
        assertEquals(mMeetingFour, mMeetingsApiService.getMeetings().get(3));

        // check if the persons added in each meeting are those expected
        assertTrue(
                mMeetingsApiService.getMeetings().get(0).getPersons().containsAll(mMeetingOne.getPersons())
        );
        assertTrue(
                mMeetingsApiService.getMeetings().get(1).getPersons().containsAll(mMeetingTwo.getPersons())
        );
        assertTrue(
                mMeetingsApiService.getMeetings().get(2).getPersons().containsAll(mMeetingThree.getPersons())
        );
        assertTrue(
                mMeetingsApiService.getMeetings().get(3).getPersons().containsAll(mMeetingFour.getPersons())
        );
    }

}
