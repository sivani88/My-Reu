package cUI.ui.main.Main;

import android.widget.Filter;


import com.example.maru.Model.Meeting;

import java.util.ArrayList;

public class MeetingFilter extends Filter {

    //private ArrayList<Meeting> mMeetingList;
    private ArrayList<Meeting> mMeetingsListOriginal;
    private ArrayList<Meeting> filteredMeetingList;

    public MeetingFilter(ArrayList<Meeting> meetingsListOriginal) {
        mMeetingsListOriginal = meetingsListOriginal;

    }
    public MeetingFilter() {

    }

    public void addMeetingList(ArrayList<Meeting> meetingsListOriginal) {
        mMeetingsListOriginal = meetingsListOriginal;
    }


    public void doFilter(CharSequence constraint) {
        filteredMeetingList = new ArrayList<>();
        if (constraint == null || constraint.length() == 0) {
            filteredMeetingList.addAll(mMeetingsListOriginal);

        } else {
            String filterPattern = constraint.toString().toLowerCase().trim();
            for (Meeting meeting : mMeetingsListOriginal) {
                if ((meeting.getDate().toLowerCase().contains(filterPattern)) || (meeting.getName().toLowerCase().contains(filterPattern))) {
                    filteredMeetingList.add(meeting);
                }
            }
        }
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        doFilter(constraint);
        FilterResults results = new FilterResults();
        results.values = filteredMeetingList;
        results.count = filteredMeetingList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

    }

    public ArrayList<Meeting> getFilteredMeeting() {
        return filteredMeetingList;
    }
};


