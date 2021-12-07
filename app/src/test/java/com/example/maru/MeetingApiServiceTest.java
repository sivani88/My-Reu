package com.example.maru;

import com.example.maru.Model.Meeting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import Service.MeetingApiService;
import configure.injection.DI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MeetingApiServiceTest {

    private MeetingApiService service;

    @Before
    public void setUp() throws Exception {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getMeetings() {
        assertEquals(14, service.getMeetings().size());
    }



    @Test
    public void addMeeting() {
        List<String> EMAILS = Arrays.asList("xyz@example, abc@example, uvw@example.com");
        Meeting meeting = new Meeting(15, "gygu", "xyz@example, abc@example, uvw@example.com","Laponie", "01/12/2022", "10.00", true, R.drawable.venise);
        service.createMeeting(meeting);
        assertEquals(15, service.getMeetings().size());
        assertEquals(meeting, service.getMeetings().get(0));
        service.getMeetings().clear();
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

     @Test
    public void filterMeetingTest() {
        assertEquals(8, service.getFilterByDate("01/01/2022").size());
        assertEquals(1, service.getFilterByRoom("London").size());
        assertEquals(14, service.getFilterByRoom(" ").size());
        assertEquals(14, service.getFilterByDate(" ").size());
        assertEquals(0, service.getFilterByRoom("ERSQf").size());
        assertEquals(0, service.getFilterByDate("01/02/2012").size());


    }

}