package cUI.ui.main.AddMeeting;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.maru.R;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import Service.MeetingApiService;
import configure.injection.DI;

public class AddMeetingActivity extends AppCompatActivity {
    private MeetingApiService mApiService;
    EditText mSubject;
    Button buttonDate, buttonHour, buttonSave;
    EditText textDate, textHour;
    int mHour, mMinute, mYear, mMonth, mDay;
    MultiAutoCompleteTextView mMail;

    public static void navigate(Context context) {
        Intent intent = new Intent(context, AddMeetingActivity.class);
        ActivityCompat.startActivity(context, intent, null);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        buttonDate = findViewById(R.id.buttonDate);
        buttonHour = findViewById(R.id.buttonHaour);
        textDate = findViewById(R.id.editTextDate);
        textHour = findViewById(R.id.editTextTime);
        buttonSave = findViewById(R.id.buttonSubmit);
        mSubject = findViewById(R.id.editTextTextPersonName);
        mMail = findViewById(R.id.multiAutoCompleteTextView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApiService = DI.getMeetingApiService();
        init();


        buttonDate.setOnClickListener(v -> onButtonDateClick());
        buttonHour.setOnClickListener(v -> onButtonHourClick());
        buttonSave.setOnClickListener(v -> onButtonSaveClick());


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        textDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                buttonSave.setEnabled(s.length() > 0);
            }
        });
    }

    public void onButtonDateClick() {
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

    public void onButtonHourClick() {
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);


        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textHour.setText(hourOfDay + ":00");

            }
        }, mHour, mMinute, false);
        timePickerDialog.show();

    }

    public void onButtonSaveClick() {
        String room = mApiService.getAvailableRoom(textDate.getText().toString(), textHour.getText().toString());
        if (room == null) {
            Toast.makeText(this, "No Room Available", Toast.LENGTH_LONG).show();

        } else {
            mApiService.createMeeting(
                    mSubject.getText().toString(),
                    mMail.getText().toString(),
                    room,
                    textDate.getText().toString(),
                    textHour.getText().toString()
            );
            Toast.makeText(this, room, Toast.LENGTH_LONG).show();
            finish();
        }

    }


    private static class MeetingPlace {

        public String mName;

        public MeetingPlace(String name) {

            mName = name;
        }

        public String getName() {
            return mName;
        }
    }

    private static List<MeetingPlace> MEETING_Place = Arrays.asList(
            new MeetingPlace("London"),
            new MeetingPlace("Paris"),
            new MeetingPlace("Vienna"),
            new MeetingPlace("Venise"),
            new MeetingPlace("Barcelona"),
            new MeetingPlace("Berlin"),
            new MeetingPlace("NewYork"),
            new MeetingPlace("Moscou"),
            new MeetingPlace("Laponie"),
            new MeetingPlace("Pekin"));


}