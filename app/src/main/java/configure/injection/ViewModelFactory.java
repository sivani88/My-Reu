package configure.injection;

public class ViewModelFactory  { /*implements ViewModelProvider.Factory

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


    private final MeetingRepository mMeetingRepository;

    public ViewModelFactory( MeetingRepository meetingRepository) {
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

    }*/
}