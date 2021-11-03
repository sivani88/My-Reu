package Service;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;

public interface MeetingApiService {
    ArrayList<Meeting> getMeetings();

    void deleteMeeting(Meeting meeting);

    void createMeeting(Meeting meeting);


}
