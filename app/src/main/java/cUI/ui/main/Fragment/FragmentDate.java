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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDate extends Fragment {
    private MeetingApiService mApiService;
    private ArrayList<Meeting> mMeetings = new ArrayList<>();
    private ExampleAdapter mAdapter;
    public ListMeetingPagerAdapter mPagerAdapter;
    private static final String MEETING_EXTRA = "meeting";

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;



    private static final String ARG_PARAM1 = "param1";


    private String mParam1;


    public FragmentDate() {
        super(R.layout.fragment_date);
    }

    public static FragmentDate newInstance(String param1, String param2) {
        FragmentDate fragment = new FragmentDate();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return   inflater.inflate(R.layout.fragment_date, container, false);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mMeetings = mApiService.getMeetings();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_by_date);
        ExampleAdapter adapter = new ExampleAdapter(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(mRecyclerView.getContext(), MyMeetingProfileActivity.class);
                intent.putExtra(MEETING_EXTRA, (Parcelable) mMeetings.get(position));
                startActivity(intent);

            }


        });
        recyclerView.setAdapter(new ExampleAdapter(getContext(), true, mMeetings));
    }




    }