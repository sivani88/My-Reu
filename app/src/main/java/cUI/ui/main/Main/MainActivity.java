package cUI.ui.main.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Service.MeetingApiService;
import cUI.ui.main.AddMeeting.AddMeetingActivity;
import cUI.ui.main.MyMeetinProfile.MyMeetingProfileActivity;

public class MainActivity extends AppCompatActivity implements OnItemClickListener, AdapterView.OnItemSelectedListener {
    private MeetingApiService mApiService;

    public MainActivity() {
        super(R.layout.activity_main2);
    }
    private ArrayList<Meeting> mMeetings = new ArrayList<>();
    private ExampleAdapter mAdapter;
    private MeetingViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    public AddMeetingActivity mAddMeetingActivity;
    private static  final String MEETING_EXTRA = "meeting";




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.roomms, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);





        FloatingActionButton fab = findViewById(R.id.floatingActionButtonadd);

        mRecyclerView = findViewById(R.id.recyclerviewMyReu);
        mAdapter = new ExampleAdapter(this, mMeetings);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);


        mViewModel = new ViewModelProvider(this).get(MeetingViewModel.class);
        mViewModel.getMutableLiveData().observe(this, meeting -> {
            mMeetings.clear();
            mMeetings.addAll(meeting);
            mRecyclerView.getAdapter().notifyDataSetChanged();
            });

        Log.e("nombre  view model", String.valueOf(mViewModel.getMutableLiveData().getValue().size()));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMeetingActivity.navigate(v.getContext());
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
              mViewModel.deleteMeeting(adapter.getItem(viewHolder.getAdapterPosition()));

            }
        }).attachToRecyclerView(mRecyclerView);


    }

    private void initList() {
        mMeetings = mApiService.getMeetings();
        mRecyclerView.setAdapter(new ExampleAdapter(this, mMeetings));
    }


    @Override
    public void onItemClick(long meetingId) {

    }

    @Override
    public void onItemClickFirst(int position) {

        Log.e("recyclerview: ", mRecyclerView.toString());
        Intent intent = new Intent(MainActivity.this, MyMeetingProfileActivity.class);
        intent.putExtra(MEETING_EXTRA, (Parcelable) mMeetings.get(position));
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(long meetingId) {
        mViewModel.onDeleteMeetingClicked(meetingId);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
           /* for (int i = 0; i<mMeetings.size();i++) {
            if(mMeetings.get(i).getName()== text) {
             mMeetings.get(i).getName();

            }
        } return ;*/
        //TODO retourne recyclerview ?


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}