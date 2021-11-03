package cUI.ui.main.Main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;

import repository.MeetingRepository;

public class MeetingViewModel extends ViewModel {

    ArrayList<Meeting> mMeetings;
    MutableLiveData<ArrayList<Meeting>> mMutableLiveData;
    MeetingRepository mMeetingRepository;

    public MutableLiveData<ArrayList<Meeting>> getMutableLiveData() {
        return mMutableLiveData;
    }

    public void fetchMeetings() {
        mMeetings = mMeetingRepository.getMeetings();
        mMutableLiveData.setValue(mMeetings);
        Log.e("fetchmeetings : ",String.valueOf(mMeetings.size()));

    }

    public void deleteMeeting(Meeting meeting) {
        mMeetingRepository.deleteMeeting(meeting);
        mMeetings.remove(meeting);
        mMutableLiveData.setValue(mMeetings);

    }

    public void addMeeting(Meeting meeting) {
        mMeetingRepository.addMeeting(meeting);
        mMeetings.add(meeting);
        mMutableLiveData.setValue(mMeetings);


    }

    public MeetingViewModel() {
        mMeetingRepository = new MeetingRepository();
        mMutableLiveData = new MutableLiveData<>();
        fetchMeetings();
        }


    public long onDeleteMeetingClicked(long meetingId) {
        return meetingId;
    }

    private void initMeetingList() {

    }

    public void deleteMeeting(CharSequence item) {
    }



  /* public LiveData<List<Meeting>> getFiltredList() {
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

    }*/


    // public void onFilterSelected(Filter filter) {
    // mMeetingViewModel.addFilter(filter);
    //  }
    //  public  void onFilterDeselected(Filter filter) {
    //    mMeetingViewModel.remove(filter);
    //  }
}