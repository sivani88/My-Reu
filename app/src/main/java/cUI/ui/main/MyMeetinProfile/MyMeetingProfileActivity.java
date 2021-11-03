package cUI.ui.main.MyMeetinProfile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maru.Model.Meeting;
import com.example.maru.R;

import Service.MeetingApiService;
import configure.injection.DI;


public class MyMeetingProfileActivity extends AppCompatActivity {
    MeetingApiService mApiService;
    private static final String KEY_MEETING_ID = "KEY_MEETING_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_meeting_profile);

        //TODO boutton Back a faire toolbar

        TextView mNameRoom = findViewById(R.id.NamePlace);
        TextView mDateAndHour = findViewById(R.id.HeureDateMeeting);
        TextView mSujet = findViewById(R.id.Sujet);
        TextView mMail = findViewById(R.id.Email);
        TextView mHour = findViewById(R.id.textHeure);


        Intent intent = getIntent();
        Meeting meeting = intent.getParcelableExtra("meeting");
        mNameRoom.setText(meeting.getName());
        mDateAndHour.setText(meeting.getDate());
        mSujet.setText(meeting.getSubject());
        mMail.setText(meeting.getMail());
        mHour.setText(meeting.getHour());
        mApiService = DI.getMeetingApiService();

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        setTitle("ma Réu");



        }


}
