package cUI.ui.main.Main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cUI.ui.main.AddMeeting.AddMeetingActivity;
import cUI.ui.main.MyMeetinProfile.MyMeetingProfileActivity;
import injection.ViewModelFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public MainActivity() {
        super(R.layout.activity_main2);
    }

    private ExampleAdapter mAdapter;
    private MeetingViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    public AddMeetingActivity mAddMeetingActivity;
    private MeetingViewModel mMeetingViewModel;

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roomms, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnClickListener();
        FloatingActionButton fab = findViewById(R.id.floatingActionButtonadd);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerviewMyReu);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mViewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(MeetingViewModel.class);
        Log.e("TEST:", String.valueOf(mViewModel.getMeetingLiveData().getValue().size()));
        mAdapter = new ExampleAdapter(new OnItemClickListener() {
            @Override
            public void onItemClick(long meetingId) {
                startActivity(MyMeetingProfileActivity.navigate(this, meetingId));
            }

            @Override
            public void onDeleteClick(long meetingId) {
                mMeetingViewModel.onDeleteMeetingClicked(meetingId);
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onPointerCaptureChanged(boolean hasCapture) {

            }
        });
        mViewModel.getMeetingLiveData().observe(this, new Observer<List<Meeting>>() {
            @Override
            public void onChanged(List<Meeting> meetingList) {
                for (int i = 0; i < meetingList.size(); i++) {
                    mViewModel.updateMeeting(meetingList.get(i), i);
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        Log.e("TEST:", String.valueOf(mRecyclerView.getAdapter().getItemCount()));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddMeetingActivity.navigate(this));
            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}