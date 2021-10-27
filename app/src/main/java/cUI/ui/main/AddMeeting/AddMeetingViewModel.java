package cUI.ui.main.AddMeeting;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ViewModel.SingleLiveEvent;
import repository.MeetingRepository;

public class AddMeetingViewModel extends ViewModel {
    @NonNull
    private final MeetingRepository mRepository;
    private final MutableLiveData<Boolean> isSaveButtonEnabledMutableLiveData = new MutableLiveData<>(false);

    private final String avatarUrl = generateAvatarUrl();

    private final MutableLiveData<String> avatarUrlMutableLiveData = new MutableLiveData<>(avatarUrl);
    private final SingleLiveEvent<Void> closeActivitySingleLiveEvent = new SingleLiveEvent<>();


    public AddMeetingViewModel(@NonNull MeetingRepository repository) {

        this.mRepository = repository;
    }

    public LiveData<Boolean> getIsSaveButtonEnabledLiveData() {
        return isSaveButtonEnabledMutableLiveData;
    }

    public LiveData<String> getAvatarUrlLiveData() {
        return avatarUrlMutableLiveData;

    }

    public void onNamechanged(String name) {
        isSaveButtonEnabledMutableLiveData.setValue(!name.isEmpty());


    }

    public SingleLiveEvent<Void> getCloseActivitySingleLiveEvent() {
        return closeActivitySingleLiveEvent;
    }




}
