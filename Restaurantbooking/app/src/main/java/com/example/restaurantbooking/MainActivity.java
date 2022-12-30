package com.example.restaurantbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    database db;
    Spinner time;
    Button btn;
    EditText name,num,deln;
    TextView res;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new database(getApplicationContext(),"rest",null,1);
        name = findViewById(R.id.editTextTextPersonName);
        deln = findViewById(R.id.editTextTextPersonName2);
        num = findViewById(R.id.editTextPhone);
        btn = findViewById(R.id.button);
        res = findViewById(R.id.textView3);
        time = findViewById(R.id.spinner);
        populatesubject();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub = time.getSelectedItem().toString();
                //Toast.makeText(getApplicationContext(), "Subject\t" + sub, Toast.LENGTH_LONG).show();
            }
        });
        time.setOnItemSelectedListener(this);
    }

    private void populatesubject() {
        ArrayAdapter sa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.slot));
        sa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time.setAdapter(sa);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner) {
            String selectedsubject = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), selectedsubject, Toast.LENGTH_SHORT).show();
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}