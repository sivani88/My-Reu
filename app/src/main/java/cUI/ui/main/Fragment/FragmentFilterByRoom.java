package cUI.ui.main.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maru.R;
import com.example.maru.databinding.FragmentFilterByRoomBinding;


public class FragmentFilterByRoom extends Fragment {
FragmentFilterByRoomBinding mRoomBinding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
             = getArguments().getString();
             = getArguments().getString();
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter_by_room, container, false);
    }
}