package com.example.maru;

import com.example.maru.Model.Meeting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Service.MeetingApiService;
import cUI.ui.main.Main.MeetingFilter;
import configure.injection.DI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.spy;

public class MeetingApiServiceTest {

    private MeetingApiService service;

    @Before
    public void setUp() throws Exception {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetings() {
        List<Meeting> meetings = service.getMeetings();
        assertEquals(14, meetings.size());
    }



    @Test
    public void addMeeting() {
        service.getMeetings().clear();
        List<String> EMAILS = Arrays.asList("xyz@example, abc@example, uvw@example.com");
        Meeting meeting = new Meeting(15, "gygu", "xyz@example, abc@example, uvw@example.com","Laponie", "01/12/2022", "10.00", true, R.drawable.venise);
        service.createMeeting(meeting);
        assertEquals(1, service.getMeetings().size());
    }

    @Test
    public void deleteMeeting() {
        List<String> EMAILS = Arrays.asList("xyz@example", "abc@example", "uvw@example.com");
        Meeting meeting = new Meeting(15, "gygu", "xyz@example, abc@example, uvw@example.com","Laponie", "01/12/2022", "10.00", true, R.drawable.venise);
        service.createMeeting(meeting);
        Meeting neighbourToDelete = service.getMeetings().get(0);
        service.deleteMeeting(neighbourToDelete);
        assertFalse(service.getMeetings().contains(neighbourToDelete));
    }


}