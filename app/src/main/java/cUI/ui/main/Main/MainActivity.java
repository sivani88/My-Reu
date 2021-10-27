package cUI.ui.main.Main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ExampleAdapter.MeetingClickInterface {
    public MainActivity() {
        super(R.layout.activity_main2);
    }

    private ExampleAdapter mAdapter;
    private MeetingVeiwModel mVeiwModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
private MeetingVeiwModel mMeetingVeiwModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerviewMyReu);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new ExampleAdapter(Meeting.sItemCallback, this);
        mRecyclerView.setAdapter(mAdapter);
        mMeetingVeiwModel = new ViewModelProvider(this).get(MeetingVeiwModel.class);
        mMeetingVeiwModel.getMeetingLiveData().observe(this, new Observer<List<Meeting>>(){

            @Override
            public void onChanged(List<Meeting> meetings) {
                mAdapter.submitList(meetings);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_filter_menu, menu);
        return true;
    }

    @Override
    public void onDelete(int position) {
    mMeetingVeiwModel.deleteMeeting(position);


    }

    @Override
    public void onDelete() {

    }


    public void addItem(View view) {
        //TODO metre par raport addMeeting class
     // mMeetingVeiwModel.addMeeting();


    }
    private List<Meeting> initMeetingList() {
        List<Meeting> meetingList = new ArrayList<>();
        return meetingList;

    }
    public  void updateItem() {

    }
}
