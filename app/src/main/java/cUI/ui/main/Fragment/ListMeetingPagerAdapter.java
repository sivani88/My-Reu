package cUI.ui.main.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ListMeetingPagerAdapter  extends FragmentStateAdapter {
    public ListMeetingPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1 :
                return new FragmentDate();
            case 2:
                return  new FragmentFilterByRoom();
        }
        return new FragmentMyReu();
    }




    @Override
    public int getItemCount() {
        return 3;
    }

 /*   @NonNull
    @Override
    public Fragment createFragment(int position) {


    @Override
    public int getItemCount() {
        return 3;
    }*/
}
