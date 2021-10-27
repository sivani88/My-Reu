package cUI.ui.main.Main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;
import java.util.List;

import repository.MeetingRepository;

public class MeetingVeiwModel extends ViewModel {

    private static final String TAG = "MeetingViewModel";
    private MutableLiveData<List<Meeting>> mMutableLiveData;

    public MeetingVeiwModel(MeetingRepository repository) {
    }


    public LiveData<List<Meeting>> getMeetingLiveData() {

        if (mMutableLiveData == null) {
            mMutableLiveData = new MutableLiveData<>();
            initMeetingList();
        }
        return mMutableLiveData;
    }

    private void initMeetingList() {
        if (mMutableLiveData != null) {
            return;


        } List<Meeting> meetingList = new ArrayList<>();
        mMutableLiveData.setValue(meetingList);
    }

    public void deleteMeeting(int position) {
        if (mMutableLiveData.getValue() != null) {
            List<Meeting> meetingList = new ArrayList<>(mMutableLiveData.getValue());
            meetingList.remove(position);
            mMutableLiveData.setValue(meetingList);
        }

    }

    public void addMeeting(Meeting meeting) {
        if (mMutableLiveData.getValue() != null) {
            List<Meeting> meetingList = new ArrayList<>(mMutableLiveData.getValue());
            meetingList.add(meeting);
            mMutableLiveData.setValue(meetingList);
        }

    }

    public void updateMeeting(Meeting newMeeting, int position) {
        if (mMutableLiveData.getValue() != null) {
            List<Meeting> meetingList = new ArrayList<>(mMutableLiveData.getValue());
            meetingList.remove(position);
            meetingList.add(position, newMeeting);
            mMutableLiveData.setValue(meetingList);
        }
    }
}