package cUI.ui.main.Main;

import android.view.View;
import android.widget.AdapterView;

public interface OnItemClickListener {
    void onItemClick(long meetingId);
    void onDeleteClick(long meetingId);

    void onItemClick(AdapterView<?> parent, View view, int position, long id);

    void onPointerCaptureChanged(boolean hasCapture);
}
