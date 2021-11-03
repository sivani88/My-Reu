package cUI.ui.main.AddMeeting;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.maru.Model.Meeting;

import java.util.ArrayList;

import repository.MeetingRepository;

public class AddMeetingViewModel extends ViewModel {

    ArrayList<Meeting> mMeetings;
    private final MutableLiveData<Boolean> isSaveButtonEnabledMutableLiveData = new MutableLiveData<>(false);
    MutableLiveData<ArrayList<Meeting>> mMutableLiveData;
    MeetingRepository mMeetingRepository;
    private String avatarUrl = generateAvatarUrl();


    public MutableLiveData<ArrayList<Meeting>> getMutableLiveData() {
        return mMutableLiveData;

    }

    AddMeetingViewModel( MeetingRepository repository) {
        this.mMeetingRepository = repository;
    }

    public AddMeetingViewModel() {
        mMeetingRepository = new MeetingRepository();
        mMutableLiveData = new MutableLiveData<>();

    }



    public LiveData<Boolean> getIsSaveButtonEnabledLiveData() {
        return isSaveButtonEnabledMutableLiveData;
 }


    public void onNameChanged(String name) {
        isSaveButtonEnabledMutableLiveData.setValue(!name.isEmpty());


    }


    public void saveNewMeeting(String mMail, String mDate, String mHour, String mSubject) {
        mMeetingRepository.addMeetingFirst(mMail, mDate, mHour, mSubject);


    }

    @NonNull
    private String generateAvatarUrl() {
        return avatarUrl;
        //TODO liste des salle a faire switch case

    }


    private void finalize(AddMeetingViewModel viewModel) {

    }



}
