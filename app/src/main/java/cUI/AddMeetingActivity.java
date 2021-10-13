package cUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.maru.R;
import com.example.maru.databinding.ActivityAddMeetingBinding;
import com.example.maru.databinding.ActivityMainBinding;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

public class AddMeetingActivity extends AppCompatActivity {
 ActivityAddMeetingBinding mMeetingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMeetingBinding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        setContentView(mMeetingBinding.getRoot());

        MaterialDatePicker datePicker=MaterialDatePicker.Builder.datePicker()
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        mMeetingBinding.buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show(getSupportFragmentManager(),"Material_date_picker");
                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        mMeetingBinding.editTextDate.setText(datePicker.getHeaderText());
                    }
                });

            }


    });
}
}