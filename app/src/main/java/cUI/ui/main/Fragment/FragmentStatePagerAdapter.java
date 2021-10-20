package cUI.ui.main.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import cUI.ui.main.Fragment.FragmentFilterByDate;
import cUI.ui.main.Fragment.FragmentFilterByRoom;
import cUI.ui.main.Fragment.FragmentMyReu;

public class FragmentStatePagerAdapter extends FragmentStateAdapter {


    public FragmentStatePagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    public FragmentStatePagerAdapter(FragmentManager fm, Lifecycle lifecycle) {
        super(fm, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch  (position) {
            case 1 :
                return  new FragmentFilterByDate();
            case 2 :
                return  new FragmentFilterByRoom();

        }
        return new FragmentMyReu();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
