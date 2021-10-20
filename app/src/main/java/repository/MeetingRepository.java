package repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.maru.Model.Meeting;
import com.example.maru.Model.Room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import configure.BuildConfigResolver;

public class MeetingRepository {
    private final MutableLiveData<List<Meeting>> meetingsLiveData = new MutableLiveData<>(new ArrayList<>());
    private long maxId = 0;
    private Meeting meeting;

    public MeetingRepository(BuildConfigResolver buildConfigResolver) {
        if (buildConfigResolver.isDebug()) {
            generateRandomMeeting();
        }
    }


    public void addMeeting(
            @NonNull String subject,
            @NonNull String mMail,
            @NonNull String mName,
            @NonNull String mDate,
            @NonNull String mHour,
            boolean availability,
            @NonNull String avatarUrl

    ) {
        List<Meeting> meetings = meetingsLiveData.getValue();
        if (meetings == null) return;

        meetings.add(new Meeting(maxId++, subject, mMail, new Room(mName, mDate, mHour, false, avatarUrl)));
        meetingsLiveData.setValue(meetings);
    }

    public void deleteMeeting(long meetingId) {
        List<Meeting> meetings = meetingsLiveData.getValue();

        if (meetings == null) return;

        for (Iterator<Meeting> iterator = meetings.iterator(); iterator.hasNext(); ) {
            Meeting meeting = iterator.next();

            if (meeting.getid() == meetingId) {
                iterator.remove();
                break;
            }
        }
    }

    public LiveData<List<Meeting>> getMeetingLiveData() {
        return meetingsLiveData;
    }

    public LiveData<Meeting> getMeetingLiveData(long meetingId) {
        return Transformations.map(meetingsLiveData, meetings -> {
            for (Meeting meeting : meetings) {
                if (meeting.getid() == meetingId) {
                    return meeting;
                }
            }
            return null;

        });
    }

   public LiveData<List<Meeting>> getMeetingfilterByRoom(String mName, String date, long meetingId) {

        return Transformations.map(meetingsLiveData, meetings -> {
            for (int i = 0; i < meetings.size(); i++) {
                if (date.equals(meetings.get(i).getid()) && mName.equals(meetings.get(i).getRoom().getName())) {
                    mFilterMeeting.add(meetings.get(i));
                }
            }
            return mFilterMeeting;
        });

}

        private void generateRandomMeeting () {
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "paris", "01/01/2022", "10", true, "src\\main\\res\\drawable\\paris.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "paris", "02/01/2022", "11", true, "src\\main\\res\\drawable\\paris.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "paris", "03/01/2022", "12", true, "src\\main\\res\\drawable\\paris.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "paris", "04/01/2022", "13", true, "src\\main\\res\\drawable\\paris.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "paris", "05/01/2022", "14", true, "src\\main\\res\\drawable\\paris.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "london", "01/01/2022", "10", true, "src\\main\\res\\drawable\\london.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Barcelona", "01/01/2022", "10", true, "src\\main\\res\\drawable\\barcelona.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Berlin", "01/01/2022", "10", true, "src\\main\\res\\drawable\\berlin.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "New york", "01/01/2022", "10", true, "src\\main\\res\\drawable\\newyork.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "venise", "01/01/2022", "10", true, "src\\main\\res\\drawable\\venise.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Vienne", "01/01/2022", "10", true, "src\\main\\res\\drawable\\vienna.png");
            addMeeting("projet construction", "louloi@gmail.com, Lala@gmail.com, ploskkm@free.fr, zaza@yahoo.fr, bidule88@gmail.com, bazar15@gmail.com",
                    "Moscou", "01/01/2022", "10", true, "src\\main\\res\\drawable\\moscou.PNG");
        }
    }