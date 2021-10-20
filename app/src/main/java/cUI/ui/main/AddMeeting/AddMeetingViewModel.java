package cUI.ui.main.AddMeeting;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import repository.MeetingRepository;

public class AddMeetingViewModel<TODO> extends ViewModel {
    @NonNull
    private  final MeetingRepository mRepository;
    private  final MutableLiveData<Boolean> isSaveButtonEnabledMutableLiveData = new MutableLiveData<>(false);

    private final String avatarUrl = generateAvatarUrl();
    private final MutableLiveData<String> avatarUrlMutableLiveData = new MutableLiveData<>(avatarUrl);
   // private final ViewModel.SingleLiveEvent<Void>closeActivitySingleLiveEvent = new SingleLiveEvent<>();



    public AddMeetingViewModel(@NonNull MeetingRepository repository) {
        mRepository = repository;
    }
    public LiveData<Boolean> getIsSaveButtonEnabledLiveData() {
        return  isSaveButtonEnabledMutableLiveData;
    }
    public  LiveData<String> getAvatarUrlLiveData() {
        return  avatarUrlMutableLiveData;

    }
    //public SingleLiveEvent<Void> getCloseActivitySingleLiveEvent() {
     //   return closeActivitySingleLiveEvent;
    //}
    public void onNamechanged(String name){
        isSaveButtonEnabledMutableLiveData.setValue(! name.isEmpty());



    }
   // public void onAddButtonClicked(){
        //mRepository.addMeeting(@NonNull..;);
      //  closeActivitySingleLiveEvent.call();
        // TODO: finir addactivity
  //  }
    @NonNull
    private String generateAvatarUrl(){
        return null;
        //TODO a faire liste salle pour la photo,
    }

}
