package cUI.ui.main.Main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Filter;

import repository.MeetingRepository;

public class MeetingViewModel extends ViewModel {

    private static final String TAG = "MeetingViewModel";
    private MutableLiveData<List<Meeting>> mMutableLiveData;
    LiveData<List<Meeting>> mMeetings;
    private MeetingRepository mRepository;
    private final MutableLiveData<Set<Filter>> filters = new MutableLiveData<>();
    private MeetingViewModel mMeetingViewModel;
    private final LiveData<List<Meeting>> originalList = mMeetings;
    private LiveData<List<Meeting>> mMeetinFiltred;
    private final LiveData<List<Meeting>> filtredList = mMeetinFiltred ;


    public LiveData<List<Meeting>> getFiltredList() {
        return filtredList;

    }
    public LiveData<Set<Filter>> getFilter() {
        return filters;
    }
    public void addFilter(Filter filter) {
        if (filtredList != null) {

            initMeetingList();
        }
    }
    public void remove(Filter filter) {
        if (filtredList != null) {
            remove(filter);
        }

    }

    public MeetingViewModel(MeetingRepository repository) {
        mRepository = repository;
        initMeetingList();
    }


    public LiveData<List<Meeting>> getMeetingLiveData() {

        return mMutableLiveData;
    }

    private void initMeetingList() {
        if (mMutableLiveData != null) {
            return;
        }
        mMutableLiveData = new MutableLiveData<>();
        mMutableLiveData.setValue(mRepository.getMeetings());
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

    public void onDeleteMeetingClicked(long meetingId) {
        mRepository.deleteMeeting(meetingId);
    }
    public void onFilterSelected(Filter filter) {
        mMeetingViewModel.addFilter(filter);
    }
    public  void onFilterDeselected(Filter filter) {
        mMeetingViewModel.remove(filter);
    }
}