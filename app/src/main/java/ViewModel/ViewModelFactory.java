package ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import cUI.ui.main.Main.MeetingVeiwModel;
import configure.BuildConfigResolver;
import repository.MeetingRepository;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private static ViewModelFactory sFactory;
    private MeetingRepository mRepository;

    public ViewModelFactory(MeetingRepository meetingRepository) {
    }


    public static ViewModelFactory getInstance() {
        if (sFactory == null) {
            synchronized (ViewModelFactory.class) {
                if (sFactory == null) {
                    sFactory = new ViewModelFactory(new MeetingRepository(new BuildConfigResolver()));
                }
            }
        }
        return sFactory;


    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(MeetingVeiwModel.class)){
            return (T) new MeetingVeiwModel(mRepository);
        }

        return null;
    }
}