package com.example.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fname,lname;
    Button btn;
    AutoCompleteTextView loc;
    String[] locations = {"Bangalore","Chennai","Hyderabad","UttarPradesh","Mumbai"};
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname=findViewById(R.id.editTextTextPersonName);
        lname=findViewById(R.id.editTextTextPersonName2);
        btn=findViewById(R.id.button);
        loc=findViewById(R.id.autoCompleteTextView);
        result=findViewById(R.id.textView2);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,locations);
        loc.setThreshold(1);
        loc.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stuname = fname.getText().toString();
                String lastname = lname.getText().toString();
                String place = loc.getText().toString();

                Toast.makeText(getApplicationContext(),"Student_name : "+stuname+" "+"Father_name : "+lastname+" "+"Place : "+place,Toast.LENGTH_LONG).show();
            }
        });
    }
}