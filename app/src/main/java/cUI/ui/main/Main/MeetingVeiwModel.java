package cUI.ui.main.Main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import repository.MeetingRepository;

public class MeetingVeiwModel extends ViewModel {

    private static final String TAG = "MeetingViewModel";

    @NonNull
    private final MeetingRepository mMeetingRepository;

    public MeetingVeiwModel(@NonNull MeetingRepository meetingRepository) {
        mMeetingRepository = meetingRepository;
    }

    public void getMeetingByRoom(String mName) {



    }
}