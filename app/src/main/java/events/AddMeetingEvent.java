package events;

import com.example.maru.Model.Meeting;

import configure.injection.DI;

public class AddMeetingEvent {
    public Meeting mMeeting;

    public AddMeetingEvent(Meeting meeting) {
        this.mMeeting = meeting;
        DI.getMeetingApiService().createMeeting(mMeeting);

    }
}
