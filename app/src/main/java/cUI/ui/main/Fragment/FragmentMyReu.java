package cUI.ui.main.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;

import java.util.ArrayList;

import Service.MeetingApiService;
import cUI.ui.main.Main.ExampleAdapter;
import cUI.ui.main.Main.OnItemClickListener;
import cUI.ui.main.MyMeetinProfile.MyMeetingProfileActivity;

public class FragmentMyReu extends Fragment {
    private MeetingApiService mApiService;
    private ArrayList<Meeting> mMeetings = new ArrayList<>();
    private ExampleAdapter mAdapter;
    public ListMeetingPagerAdapter mPagerAdapter;
    private static final String MEETING_EXTRA = "meeting";

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    public static FragmentMyReu getInstance(){
        FragmentMyReu fragmentTwo = new FragmentMyReu();
        return fragmentTwo;

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return   inflater.inflate(R.layout.fragment_my_reu, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mMeetings = mApiService.getMeetings();
        RecyclerView recyclerView = view.findViewById(R.id.rcyclerview_my_reu);
        ExampleAdapter adapter = new ExampleAdapter(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(mRecyclerView.getContext(), MyMeetingProfileActivity.class);
                intent.putExtra(MEETING_EXTRA, (Parcelable) mMeetings.get(position));
                startActivity(intent);

            }


        });
        recyclerView.setAdapter(adapter);
    }





      /*  mRecyclerView = f(R.id.rcyclerview_my_reu);
        mAdapter = new ExampleAdapter(this, mMeetings);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);*/


}
