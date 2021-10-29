package cUI.ui.main.MyMeetinProfile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import repository.MeetingRepository;

public class MyMeetingProfileViewModel extends ViewModel {
    @NonNull
    private final Application mApplication;

    @NonNull
    private final MeetingRepository mMeetingRepository;

    public MyMeetingProfileViewModel(@NonNull Application application, @NonNull MeetingRepository meetingRepository) {
        mApplication = application;
        mMeetingRepository = meetingRepository;
    }
/*    public LiveData<MyMeetingProfileViewState> getMeetingProfileViewStateLiveData (long meetingId) {
        return Transformations.map(
                mMeetingRepository.getMeetingById(meetingId),
                meeting -> new MyMeetingProfileViewState
                        (meeting.getName(), meeting.getDate(),
                          meeting.getHour(), meeting.getSubject(),
                                meeting.getMail()));
    }*/

}
