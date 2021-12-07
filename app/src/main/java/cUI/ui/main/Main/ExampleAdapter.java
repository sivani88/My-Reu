package cUI.ui.main.Main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExempleViewHolder> implements Filterable {


    private OnItemclickListener mListener;
    private ArrayList<Meeting> mMeetingList;
    private ArrayList<Meeting> mMeetingsListOriginal;
    private static final String TAG = "ExampleAdapter";
    private Filter meetingFilter;

    public interface OnItemclickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);

    }

    public void setOnItemClickListener(OnItemclickListener listener) {
        mListener = listener;
    }

    public ExampleAdapter(ArrayList<Meeting> meetingList) {
        // mListener = listener;
        mMeetingList = meetingList;
        this.mMeetingsListOriginal = new ArrayList<>(meetingList);
        meetingFilter = new MeetingFilter(mMeetingsListOriginal) {

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mMeetingList.clear();
                mMeetingList.addAll((ArrayList) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public static class ExempleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mAvatar;
        public TextView mDay, mSubject, mMails, mName;
        ImageButton mButtonDelete;


        public ExempleViewHolder(@NonNull View itemView, OnItemclickListener listener) {
            super(itemView);
            mAvatar = itemView.findViewById(R.id.item_list_user_avatar);
            mDay = itemView.findViewById(R.id.heure);
            mMails = itemView.findViewById(R.id.email);
            mName = itemView.findViewById(R.id.NomSalle);
            mSubject = itemView.findViewById(R.id.sujet);
            mButtonDelete = itemView.findViewById(R.id.imageButtonDelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            mButtonDelete.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onDeleteClick(position);
                    }
                }
            });


        }
    }

    @Override
    public Filter getFilter() {
        return meetingFilter;
    }



    @NonNull
    @Override

    public ExempleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExempleViewHolder mHolder = new ExempleViewHolder(v, mListener);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExempleViewHolder holder, int position) {
        Meeting currentMeeting = mMeetingList.get(position);
        holder.mName.setText(currentMeeting.getName());
        holder.mSubject.setText(currentMeeting.getSubject());
        holder.mMails.setText(currentMeeting.getMail());
        holder.mDay.setText(currentMeeting.getDate());
        holder.mAvatar.setImageResource(currentMeeting.getAvatarUrl());

    }

    @Override
    public int getItemCount() {
        return mMeetingList.size();
    }
}