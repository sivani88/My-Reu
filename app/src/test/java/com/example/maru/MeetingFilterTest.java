package com.example.maru;

import com.example.maru.Model.Meeting;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import Service.MeetingApiService;
import cUI.ui.main.Main.MeetingFilter;
import configure.injection.DI;

import static org.junit.Assert.assertEquals;


public class MeetingFilterTest {
    private MeetingApiService service;
    private ArrayList<Meeting> meetings;

    @Before
    public void setUp() throws Exception {
        service = DI.getNewInstanceApiService();
        meetings = service.getMeetings();
    }


    @Test
    public void filterMeetingtest() throws Exception {
        ArrayList<Meeting> filteredMeetings;
        MeetingFilter filter = new MeetingFilter(meetings);
        filter.doFilter("Vienna");
        assertEquals(1, filter.getFilteredMeeting().size());
        filter.doFilter("01/01/2022");
        assertEquals(8, filter.getFilteredMeeting().size());
        filter.doFilter("fddgd");
        assertEquals(0, filter.getFilteredMeeting().size());
    }



}
