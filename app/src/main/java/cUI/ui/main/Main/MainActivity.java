package cUI.ui.main.Main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.maru.R;
import com.example.maru.databinding.ActivityMain2Binding;
import com.google.android.material.tabs.TabLayout;

import cUI.ui.main.Fragment.FragmentStatePagerAdapter;

public class MainActivity extends AppCompatActivity {
    public MainActivity(){
        super(R.layout.activity_main2);
    }
    ActivityMain2Binding mBinding;
    FragmentStatePagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        FragmentManager fm = getSupportFragmentManager();
        mAdapter = new FragmentStatePagerAdapter(fm, getLifecycle());
        mBinding.viewPager.setAdapter(mAdapter);

        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("My Réu"));
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Par Date"));
        mBinding.tabs.addTab(mBinding.tabs.newTab().setText("Par Salle"));

        mBinding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mBinding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                mBinding.tabs.selectTab(mBinding.tabs.getTabAt(position));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_filter_menu, menu);
        return true;
    }
}
