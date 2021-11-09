package cUI.ui.main.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.MeetingViewHolder> implements Filterable {
    private Context mContext;
    private OnItemClickListener mListener;
    private ArrayList<Meeting> mMeetingList;
    private ArrayList<Meeting> mMeetingsFull;
    private static final String TAG = "ExampleAdapter";


    public ExampleAdapter(Context context, boolean listener, List<Meeting> meetingList) {
        super();
        
        Filterable  mFilterable;
        this.mContext = context;
        this.mMeetingList = (ArrayList<Meeting>) meetingList;
        this.mMeetingsFull = new ArrayList<Meeting>(meetingList);
    }

    public ExampleAdapter(OnItemClickListener listener) {
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeetingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapter.MeetingViewHolder holder, int position) {
        Meeting meeting = mMeetingList.get(position);
        holder.nameRoom.setText(meeting.getName());
        holder.roomImage.setImageResource(meeting.getAvatarUrl());
        holder.mDate.setText(meeting.getDate());
        holder.eMail.setText(meeting.getMail());
        holder.mSubject.setText(meeting.getSubject());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null) {

                    int position = holder.getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);

                    }
                }
            }
        });

    }



    @Override
    public int getItemCount() {
        if (this.mMeetingList == null) {
            return 0 ;
        } else
        {
            return this.mMeetingList.size();
        }
    }
    public Meeting getUser(int position) {

        return this.mMeetingList.get(position);
    }
    public interface ItemClickListener{
        public void onItemClick(int position);

    }

    public void setMeetingList(List<Meeting> meetings) {
        this.mMeetingList = mMeetingList;


    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }


    private final Filter exampleFilter = new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence constraint) {

             ArrayList<Meeting> filteredList = new ArrayList<>();

             if (constraint == null || constraint.length() == 0) {
                 filteredList.addAll(mMeetingsFull);
             }else {
                 String filterPattern = constraint.toString().toLowerCase().trim();
                 for (Meeting item : mMeetingsFull){
                     if(item.getDate().toLowerCase().contains(filterPattern)){
                         filteredList.add(item);
                     }
                 }
             }
             FilterResults results = new FilterResults();
             results.values = filteredList;
             return results;
         }

         @Override
         protected void publishResults(CharSequence constraint, FilterResults results) {
             mMeetingList.clear();;
             mMeetingList.addAll((List)results.values);


         }
     };



    static class MeetingViewHolder extends RecyclerView.ViewHolder {

        ImageView roomImage;
        TextView eMail, nameRoom, mDate, mSubject;

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);
            roomImage = itemView.findViewById(R.id.item_list_user_avatar);
            eMail = itemView.findViewById(R.id.email);
            nameRoom = itemView.findViewById(R.id.NomSalle);
            mDate = itemView.findViewById(R.id.heure);
            mSubject = itemView.findViewById(R.id.sujet);


        }


    }

}
