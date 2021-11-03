package Service;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;

public class DummyMeetingApiService implements MeetingApiService {
    private final ArrayList<Meeting> mMeetings = DummyMeetingGenerator.generateMeetings();

    @Override
    public ArrayList<Meeting> getMeetings() {
        return mMeetings;
    }

    @Override
    public void deleteMeeting(Meeting meeting) {
        mMeetings.remove(meeting);
    }

    @Override
    public void createMeeting(Meeting meeting) {
        mMeetings.add(meeting);

    }
   /*public List<Meeting> getFillteredRoomsMeetings() {
        List<Meeting> filterRooms= new ArrayList<>();
        for (int i = 0; i< mMeetings.size();i++) {
            if(mMeetings.get(i).setName()==
        }
  }*/
}
