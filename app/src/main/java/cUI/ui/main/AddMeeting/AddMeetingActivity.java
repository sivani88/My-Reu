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

import com.example.maru.R;

import java.util.Calendar;

import cUI.ui.main.Main.MainActivity;

public class AddMeetingActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mSubject;
    Button buttonDate, buttonHour;
    EditText textDate, textHour;
    int mHour, mMinute, mYear, mMonth, mDay;
    AddMeetingViewModel viewModel;

    public static void  navigate(MainActivity mainActivity) {
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
        textHour = findViewById(R.id.editTextDate);
        Button buttonSave = findViewById(R.id.buttonSubmit);
        Button buttonFindMeeting = findViewById(R.id.flotingactionbuttonADD);
        EditText mSubject = findViewById(R.id.editTextTextPersonName);
        MultiAutoCompleteTextView mMail = findViewById(R.id.multiAutoCompleteTextView);


        buttonDate.setOnClickListener(this);
        buttonHour.setOnClickListener(this);
        buttonFindMeeting.setOnClickListener(this);
        buttonSave.setOnClickListener(this);

       bindName(viewModel, mSubject);
       bindAddButton(viewModel, mSubject, mMail, textDate, textHour,
                buttonSave);
       viewModel.getCloseActivitySingleLiveEvent().observe(this, avoid -> finish());


    }
    public static Intent navigate(View.OnClickListener context) {
        return  new Intent((Context) context, AddMeetingActivity.class);
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
                    textHour.setText(hourOfDay + ":" + minute);
                }
            }, mHour, mMinute, false);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home ) {
            finish();
            return  true;
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
                viewModel.onNamechanged(s.toString());
            }
        });
    }
    private void bindAddButton(AddMeetingViewModel viewModel, EditText mSubject,
                               MultiAutoCompleteTextView mMail, EditText textDate, EditText textHour,
                               Button buttonSave) {
        buttonSave.setOnClickListener(v-> viewModel.onAddButtonClicked(mMail.getText().toString(),
                mSubject.getText().toString(),
                textHour.getText().toString(),
                textDate.getText().toString()));
        viewModel.getIsSaveButtonEnabledLiveData().observe(this, isSaveButtonEnabled -> buttonSave.setEnabled(isSaveButtonEnabled));
    }
}