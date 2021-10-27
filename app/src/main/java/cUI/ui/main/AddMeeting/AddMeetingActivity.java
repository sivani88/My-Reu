package cUI.ui.main.AddMeeting;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maru.R;

import java.util.Calendar;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonDate, buttonHour;
    EditText textDate, textehour;
    int mHour, mMinute, mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        buttonDate = findViewById(R.id.buttonDate);
        buttonHour = findViewById(R.id.buttonHaour);
        textDate = findViewById(R.id.editTextDate);
        textehour = findViewById(R.id.editTextDate);


        buttonDate.setOnClickListener(this);
       buttonHour.setOnClickListener(this);


    }

    // @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if (v == buttonDate) {
            final Calendar calendar = Calendar.getInstance();
            mYear = calendar.get(calendar.YEAR);
            mMonth = calendar.get(Calendar.MONTH);
            mDay = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                   textDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);


                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == buttonHour) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            // mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                  textehour.setText(hourOfDay + ":" + minute);
                }
            }, mHour, mMinute, false);
        }

    }


}