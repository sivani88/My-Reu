package repository;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;

import Service.MeetingApiService;
import configure.injection.DI;

public class MeetingRepository {
    private static final MeetingApiService service = DI.getMeetingApiService();


    public ArrayList<Meeting> getMeetings() {
        return service.getMeetings();
    }

    public void deleteMeeting(Meeting meeting) {
        service.deleteMeeting(meeting);
    }

    public void addMeeting(Meeting meeting) {
        service.createMeeting(meeting);
    }

    public void addMeetingFirst(String mMail, String mDate, String mHour, String mSubject) {

    }
}