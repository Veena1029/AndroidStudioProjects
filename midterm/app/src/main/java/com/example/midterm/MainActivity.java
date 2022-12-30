package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etname, etmailid, etph;
    Spinner models;
    Button btn,cal;
    TextView txt;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;
    AutoCompleteTextView loc;
    private int mYear, mMonth, mDay, mHour, mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.editTextTextPersonName);
        etmailid = findViewById(R.id.editTextTextPersonName3);
        etph = findViewById(R.id.editTextTextPersonName2);
        btn = findViewById(R.id.button);
        models = findViewById(R.id.spinner);
        Button selectDate = findViewById(R.id.button2);
        TextView date = findViewById(R.id.textView4);
        String[] locations = {"Bangalore", "Chennai", "Hyderabad", "Uttar_Pradesh"};
        loc = findViewById(R.id.autoCompleteTextView);
        populatesubject();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, locations);
        loc.setThreshold(1);
        loc.setAdapter(adapter);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                date.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }

        });

    }


    private void populatesubject() {
        ArrayAdapter sa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.types));
        sa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        models.setAdapter(sa);
    }

    public void onItemSelected(AdapterView<?> parent,View view,int position,long id){
        if(parent.getId()==R.id.spinner){
            String selectedmodel=parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), selectedmodel, Toast.LENGTH_SHORT).show();
        }
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

