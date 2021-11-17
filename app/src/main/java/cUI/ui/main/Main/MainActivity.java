package cUI.ui.main.Main;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;

import Service.MeetingApiService;
import cUI.ui.main.AddMeeting.AddMeetingActivity;
import cUI.ui.main.MyMeetinProfile.MyMeetingProfileActivity;
import configure.injection.DI;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private MeetingApiService mApiService;
    private ArrayList<Meeting> mMeetings;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Spinner mSpinner;
    Button mButtonDateFilter;
    EditText mEditTextDate;
    private static final String MEETING_EXTR = "meeting";
    int mYear, mMonth, mDay;


    public MainActivity() {
        super(R.layout.activity_main2);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEditTextDate = findViewById(R.id.editDate);
        mApiService = DI.getMeetingApiService();
        buildRecyclerView();
        beginFlotingActionButton();
        beginSpinner();
        mButtonDateFilter = findViewById(R.id.button_picker_date);
        mButtonDateFilter.setOnClickListener(v -> onButtonDateClick());
        onTextChangeFilterByDate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        buildRecyclerView();
    }

    public void onTextChangeFilterByDate() {
        mEditTextDate.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String dateInput = mEditTextDate.getText().toString();
                mAdapter.getFilter().filter(dateInput);


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void onButtonDateClick() {
        final Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String jour;
                String mois;
                if (dayOfMonth < 10) { jour = "0" + dayOfMonth; } else { jour = String.valueOf(dayOfMonth);}
                if (month <9 ) { mois = "0" + (month+1); } else { mois = String.valueOf(month+1);}

                mEditTextDate.setText(jour + "/" + mois + "/" + year);


            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }


    public void beginSpinner() {
        Spinner spinner = findViewById(R.id.spinnerRoom);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.roomms, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }


    public void beginFlotingActionButton() {
        FloatingActionButton fab = findViewById(R.id.floatingActionButtonadd);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMeetingActivity.navigate(v.getContext());
            }
        });
    }

    public void buildRecyclerView() {
        mMeetings = mApiService.getMeetings();
        mRecyclerView = findViewById(R.id.recyclerviewMain);
       // mRecyclerView.setHasFixedSize(true);
        mAdapter = new ExampleAdapter(mMeetings);
        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemclickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, MyMeetingProfileActivity.class);
                intent.putExtra(MEETING_EXTR, (Parcelable) mMeetings.get(position));
                startActivity(intent);
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void removeItem(int position) {
        mMeetings.remove(position);
        mAdapter.notifyItemRemoved(position);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), choice, Toast.LENGTH_SHORT).show();
        mAdapter.getFilter().filter(choice);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}