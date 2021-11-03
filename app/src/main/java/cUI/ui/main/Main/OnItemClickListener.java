package cUI.ui.main.Main;

import android.view.View;
import android.widget.AdapterView;

public interface OnItemClickListener {
    void onItemClick(long meetingId);


    void onItemClickFirst(int position);

    void onDeleteClick(long meetingId);
    void onItemSelected(AdapterView<?> parent, View view, int position, long id);

    void onNothingSelected(AdapterView<?> parent);
}
