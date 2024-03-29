package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner subject;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        subject = findViewById(R.id.spinner1);
        populatesubject();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub = subject.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), "Subject\t" + sub, Toast.LENGTH_LONG).show();
            }
        });
        subject.setOnItemSelectedListener(this);
    }

    private void populatesubject() {
        ArrayAdapter sa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.subjectlist));
        sa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject.setAdapter(sa);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.spinner1) {
            String selectedsubject = parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), selectedsubject, Toast.LENGTH_SHORT).show();
        }
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }
}