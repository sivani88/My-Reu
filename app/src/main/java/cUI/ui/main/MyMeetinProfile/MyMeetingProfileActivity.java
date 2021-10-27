package cUI.ui.main.MyMeetinProfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.maru.R;

import injection.ViewModelFactory;


public class MyMeetingProfileActivity extends AppCompatActivity {

    private static final String KEY_MEETING_ID = "KEY_MEETING_ID";

    public static Intent navigate(Context context, long meetingID) {
        Intent intent = new Intent(context, MyMeetingProfileActivity.class);

        intent.putExtra(KEY_MEETING_ID, meetingID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_meeting_profile);

        //TODO boutton Back a faire toolbar

        TextView mNameRoom = findViewById(R.id.NamePlace);
        TextView mDateAndHour = findViewById(R.id.HeureDateMeeting);
        TextView mSujet = findViewById(R.id.Sujet);
        TextView mMail = findViewById(R.id.Email);

        long meetingId = getIntent().getLongExtra(KEY_MEETING_ID, -1);
        if (meetingId == -1) {
            throw new IllegalStateException("use my profile activity");

        }
        MyMeetingProfileViewModel mViewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(MyMeetingProfileViewModel.class);
        mViewModel.getMeetingProfileViewStateLiveData(meetingId).observe(this, myMeetingProfileViewState -> {
            mNameRoom.setText(myMeetingProfileViewState.getName());
            mDateAndHour.setText(myMeetingProfileViewState.getDate());
            mDateAndHour.setText(myMeetingProfileViewState.getHour());
            mMail.setText(myMeetingProfileViewState.geteMails());
        });

    }
}