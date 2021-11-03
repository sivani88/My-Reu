package cUI.ui.main.AddMeeting;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.maru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

import cUI.ui.main.Main.MainActivity;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener {
   // private MeetingApiService mApiService;
    private String mMeetinImage;
    EditText mSubject;
    Button buttonDate, buttonHour;
    EditText textDate, textHour;
    int mHour, mMinute, mYear, mMonth, mDay;
    AddMeetingViewModel viewModel;

    public static void navigate(MainActivity mainActivity) {
        Intent intent = new Intent(mainActivity, AddMeetingActivity.class);
        ActivityCompat.startActivity(mainActivity, intent, null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        buttonDate = findViewById(R.id.buttonDate);
        buttonHour = findViewById(R.id.buttonHaour);
        textDate = findViewById(R.id.editTextDate);
        textHour = findViewById(R.id.editTextTime);
        Button buttonSave = findViewById(R.id.buttonSubmit);
        FloatingActionButton buttonFindMeeting = findViewById(R.id.flotingactionbuttonADD);
        EditText mSubject = findViewById(R.id.editTextTextPersonName);
        MultiAutoCompleteTextView mMail = findViewById(R.id.multiAutoCompleteTextView);
        //mApiService = DI.getMeetingApiService();
        viewModel = new ViewModelProvider(this).get(AddMeetingViewModel.class);

        buttonDate.setOnClickListener(this);
        buttonHour.setOnClickListener(this);
        buttonFindMeeting.setOnClickListener(this);
        buttonSave.setOnClickListener(this);

        bindName(viewModel, mSubject);
        bindAddButton(viewModel, mSubject, mMail, textDate, textHour,
                buttonSave);
        //viewModel.getClass(this).observe(this, avoid -> finish());


    }

   public static void navigate(Context activity) {
        Intent intent = new Intent(activity, AddMeetingActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
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
                    textHour.setText(hourOfDay + ":00");

                }
            }, mHour, mMinute, false);
            timePickerDialog.show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void bindName(AddMeetingViewModel viewModel, EditText mSubject) {
        mSubject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.onNameChanged(s.toString());
            }
        });
    }

    private void onAddButtonClicked(String mMail, String mDate, String mHour, String mSubject) {
        viewModel.saveNewMeeting(mMail, mDate, mHour, mSubject);
        finish();
    }

    private void bindAddButton(AddMeetingViewModel viewModel, EditText mSubject,
                               MultiAutoCompleteTextView mMail, EditText textDate, EditText textHour,
                               Button buttonSave) {
        buttonSave.setOnClickListener(v -> onAddButtonClicked(mMail.getText().toString(),
                mSubject.getText().toString(),
                textHour.getText().toString(),
                textDate.getText().toString()));
        viewModel.getIsSaveButtonEnabledLiveData().observe(this, isSaveButtonEnabled -> buttonSave.setEnabled(isSaveButtonEnabled));

    }
}