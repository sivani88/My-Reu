package events;

import com.example.maru.Model.Meeting;

import configure.injection.DI;

public class DeleteMeetingEvent {
    public Meeting mMeeting;

    public DeleteMeetingEvent(Meeting meeting) {
        this.mMeeting = meeting;
        DI.getMeetingApiService().deleteMeeting(mMeeting);
    }
}

