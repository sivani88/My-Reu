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

    @Override
    public String getAvailableRoom(String date, String hour) {
        for (int i=0; i<Meeting.getRoomList().size(); i++) {
            String roomName = Meeting.getRoomList().get(i).mName;
            Boolean available = true;
            for (int j=0; j<mMeetings.size(); j++) {
                if ((date == mMeetings.get(j).getName()) && (hour == mMeetings.get(j).getHour())) {
                    available = false;
                    break;
                }
            }
            if (available) {
                return roomName;
            }
        }
        return null;
    }

    private long getNextId() {
        long id = 0;
        for (int j = 0; j < mMeetings.size(); j++) {
            if (id<mMeetings.get(j).getId()) {
                id = mMeetings.get(j).getId();
            }
        }
        return id +1;
    }

    @Override
    public void createMeeting(String mSubject, String mMail, String mName, String mDate, String mHour) {
        Meeting meeting = new Meeting(getNextId(),mSubject,mMail, mName, mDate, mHour, false, Meeting.MeetingRoom.getAvatarUrl(mName));
        mMeetings.add(meeting);
    }

 /*  public List<Meeting> getFillteredRoomsMeetings() {
        List<Meeting> filterRooms= new ArrayList<>();
        for (int i = 0; i< mMeetings.size();i++) {
            if(mMeetings.get(i).setName()== mName) {
                return filterRooms.
            }
        }
  }*/
}
