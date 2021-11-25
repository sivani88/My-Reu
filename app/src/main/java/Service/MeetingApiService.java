package Service;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;

public interface MeetingApiService {
    ArrayList<Meeting> getMeetings();

    void deleteMeeting(Meeting meeting);

    void createMeeting(Meeting meeting);

    public String getAvailableRoom(String date, String hour);

    void createMeeting(String mSubject, String mMail, String mName, String mDate, String mHour);
}
