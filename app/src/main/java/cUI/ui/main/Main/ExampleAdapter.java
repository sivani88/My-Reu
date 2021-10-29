package cUI.ui.main.Main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.maru.Model.Meeting;
import com.example.maru.R;

import java.util.List;
import java.util.Set;

public class ExampleAdapter extends ListAdapter<MeetingViewStateItem, ExampleAdapter.MeetingViewHolder> implements OnItemClickListener, Filterable {
    private OnItemClickListener mListener;
    private final MutableLiveData<Set<java.util.logging.Filter>> filters = new MutableLiveData<>();
    private LiveData<List<Meeting>> mMeetingList;
    private LiveData<List<Meeting>> mFilterListe;
    private MeetingViewModel mMeetingViewModel;
    private static final String TAG = "ExampleAdapter";


    public ExampleAdapter(OnItemClickListener listener, LiveData<List<Meeting>> meetingList) {
        super(new ListMeetingItemCallback());
        mListener = listener;
        Filterable  mFilterable;
        this.mMeetingList = meetingList;


    }


    protected ExampleAdapter(@NonNull DiffUtil.ItemCallback diffCallback) {
        super(diffCallback);
    }

    protected ExampleAdapter(@NonNull OnItemClickListener config) {
        super((DiffUtil.ItemCallback<MeetingViewStateItem>) config);
    }

    @NonNull
    @Override
    public MeetingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeetingViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false));
       // Log.e(TAG, "ca marche pas", getItem());
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {
        holder.bind(getItem(position), mListener);
    }

    @Override
    public void onItemClick(long meetingId) {

    }

    @Override
    public void onDeleteClick(long meetingId) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void setMeetingList(List<Meeting> meetings) {

    }

    @Override
    public Filter getFilter() {
        return null;
    }

  /*
    private final Filter mFilter = new Filter() {
         @Override
         protected FilterResults performFiltering(CharSequence constraint) {
             LiveData<List<Meeting>> mFilterListe;
             if (constraint == null || constraint.length() ==0 ) {

          }
         }

         @Override
         protected void publishResults(CharSequence constraint, FilterResults results) {

         }
     };*/


    class MeetingViewHolder extends RecyclerView.ViewHolder {

        ImageView roomImage;
        ImageButton deleteButton;
        TextView eMail, nameRoom, mDate, mSubject;

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);
            roomImage = itemView.findViewById(R.id.item_list_user_avatar);
            deleteButton = itemView.findViewById(R.id.poubelle);
            eMail = itemView.findViewById(R.id.email);
            nameRoom = itemView.findViewById(R.id.NomSalle);
            mDate = itemView.findViewById(R.id.heure);
            mSubject = itemView.findViewById(R.id.sujet);


        }

        public void bind(MeetingViewStateItem item, OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onItemClick(item.getId()));
            Glide.with(roomImage)
                    .load(item.getAvatarUrl())
                    .apply(RequestOptions.centerCropTransform())
                    .into(roomImage);
            nameRoom.setText(item.getName());
            mSubject.setText(item.getSubject());
            eMail.setText(item.getMail());
            mDate.setText(item.getDate());
            mDate.setText(item.getHour());
            deleteButton.setOnClickListener(v -> listener.onDeleteClick(item.getId()));
        }
    }

    private static class ListMeetingItemCallback extends DiffUtil.ItemCallback<MeetingViewStateItem> {

        @Override
        public boolean areItemsTheSame(@NonNull MeetingViewStateItem oldItem, @NonNull MeetingViewStateItem newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull MeetingViewStateItem oldItem, @NonNull MeetingViewStateItem newItem) {
            return oldItem.equals(newItem);
        }
    }


}
