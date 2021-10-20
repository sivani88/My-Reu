package cUI.ui.main.MyMeetinProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.maru.R;
import com.example.maru.databinding.ActivityMain2Binding;
import com.example.maru.databinding.ActivityMyMeetingProfileBinding;

public class MyMeetingProfileActivity extends AppCompatActivity {
 ActivityMyMeetingProfileBinding mProfileBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProfileBinding = ActivityMyMeetingProfileBinding.inflate(getLayoutInflater());
        setContentView(mProfileBinding.getRoot());


    }
}