package injection;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.maru.Model.Meeting;

import cUI.ui.main.AddMeeting.AddMeetingActivity;
import cUI.ui.main.AddMeeting.AddMeetingViewModel;
import cUI.ui.main.Main.MainApplication;
import cUI.ui.main.Main.MeetingViewModel;
import cUI.ui.main.MyMeetinProfile.MyMeetingProfileActivity;
import cUI.ui.main.MyMeetinProfile.MyMeetingProfileViewModel;
import repository.MeetingRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory sFactory;
  //  private MeetingRepository mRepository;
    private Meeting meeting;
    private MeetingViewModel mMeetingViewModel;
    private AddMeetingActivity mAddMeetingActivity;
    private MyMeetingProfileActivity mMyMeetingProfileActivity;


    public static ViewModelFactory getInstance() {
        if (sFactory == null) {
            synchronized (ViewModelFactory.class) {
                if (sFactory == null) {
                    sFactory = new ViewModelFactory(new MeetingRepository());
                }
            }
        }
        return sFactory;
    }

    @NonNull
    private final MeetingRepository mMeetingRepository;

    public ViewModelFactory(@NonNull MeetingRepository meetingRepository) {
        mMeetingRepository = meetingRepository;
        Log.e("fdsdf: ", String.valueOf(mMeetingRepository.getMeetings().size()));
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //Log.e("CReateur de factory", "");
        if (modelClass.isAssignableFrom(MeetingViewModel.class)) {
            return (T) new MeetingViewModel(mMeetingRepository);
        } else if (modelClass.isAssignableFrom(AddMeetingViewModel.class)) {
            return (T) new AddMeetingViewModel(mMeetingRepository);
        } else if (modelClass.isAssignableFrom(MyMeetingProfileActivity.class)) {
            return (T) new MyMeetingProfileViewModel(MainApplication.getInstance(), mMeetingRepository);
        }
        throw new IllegalArgumentException("Unkonwn Viewmodel Class");

    }
}