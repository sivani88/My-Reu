package cUI.ui.main.Main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;

public class ExampleAdapter extends ListAdapter<Meeting, ExampleAdapter.MeetingViewHolder> implements OnItemClickListener {
MeetingClickInterface mMeetingClickInterface;


    protected ExampleAdapter(@NonNull DiffUtil.ItemCallback<Meeting> diffCallback, MeetingClickInterface mMetingClickInterface) {
        super(diffCallback);
        this.mMeetingClickInterface = mMetingClickInterface;
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeetingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {
        Meeting meeting = getItem(position);
    holder.bind(meeting);
    }

    class  MeetingViewHolder extends RecyclerView.ViewHolder{

       ImageView roomImage;
       ImageButton  deleteButton;
       TextView eMail, nameRoom, mDate,  mSubject;
       public MeetingViewHolder(@NonNull View itemView) {
           super(itemView);
           roomImage = itemView.findViewById(R.id.item_list_user_avatar);
           deleteButton = itemView.findViewById(R.id.poubelle);
           eMail = itemView.findViewById(R.id.email);
           nameRoom = itemView.findViewById(R.id.NomSalle);
           mDate = itemView.findViewById(R.id.heure);
           mSubject = itemView.findViewById(R.id.sujet);

            deleteButton.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMeetingClickInterface.onDelete(getAdapterPosition());
                }
            }));
       }

        public void bind(Meeting meeting) {
           mDate.setText(meeting.getDate());
        }
    }
    public interface MeetingClickInterface {
        public void onDelete(int position);

        void onDelete();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onDeleteClick(int Position) {

    }

}
