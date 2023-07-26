package com.openclassrooms.mareu.meetings;

import static org.junit.Assert.assertEquals;

import com.openclassrooms.mareu.base.BaseUnitTest;
import com.openclassrooms.mareu.model.Meeting;

import org.junit.Test;

import java.util.List;

public class EmptyUnitTest extends BaseUnitTest {

    /**
     * Test if the meeting service has no meeting at startup
     */
    @Test
    public void emptyMeetingsAtServiceStartup(){
        // get the list of meetings
        List<Meeting> meetings = mMeetingsApiService.getMeetings();
        // check if the list is empty
        assertEquals(0, meetings.size());
    }

}
