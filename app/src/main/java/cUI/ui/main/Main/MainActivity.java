package cUI.ui.main.Main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import Service.MeetingApiService;
import cUI.ui.main.AddMeeting.AddMeetingActivity;
import cUI.ui.main.Fragment.ListMeetingPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private MeetingApiService mApiService;

    public MainActivity() {
        super(R.layout.activity_main2);
    }

    private ArrayList<Meeting> mMeetings = new ArrayList<>();
    public ListMeetingPagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabLayout tabLayout= findViewById(R.id.tabLayoutMainActivity);
        ViewPager2 viewPager2= findViewById(R.id.viewPager2MainActivity);

        FragmentManager fm = getSupportFragmentManager();
        mPagerAdapter =  new ListMeetingPagerAdapter(fm, getLifecycle());
        viewPager2.setAdapter(mPagerAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("Mes Reunions"));
        tabLayout.addTab(tabLayout.newTab().setText("par Dates"));
        tabLayout.addTab(tabLayout.newTab().setText("par salle"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });




        FloatingActionButton fab = findViewById(R.id.floatingActionButtonadd);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMeetingActivity.navigate(v.getContext());
            }
        });


    }


}