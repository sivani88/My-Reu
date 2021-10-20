package cUI.ui.main.AddMeeting;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.maru.databinding.ActivityAddMeetingBinding;

import java.util.Calendar;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityAddMeetingBinding mMeetingBinding;
    int mHour, mMinute, mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMeetingBinding = ActivityAddMeetingBinding.inflate(getLayoutInflater());
        setContentView(mMeetingBinding.getRoot());

        //  MaterialDatePicker datePicker=MaterialDatePicker.Builder.datePicker()
        //       .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        //    .build();

        mMeetingBinding.buttonDate.setOnClickListener(this);
        mMeetingBinding.buttonHaour.setOnClickListener(this);


    }

   // @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == mMeetingBinding.buttonDate) {
            final Calendar calendar = Calendar.getInstance();
            mYear = calendar.get(calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    mMeetingBinding.editTextDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);


                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if(v==mMeetingBinding.buttonHaour){
            final  Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
           // mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    mMeetingBinding.editTextTime.setText(hourOfDay+":"+minute);
                }
            },mHour,mMinute, false);
        }

        }




}