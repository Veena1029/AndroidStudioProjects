package com.example.appoint673;

import static com.example.appoint673.R.id.textView3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView t;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = findViewById(textView3);
        Intent i = getIntent();
        int ag = i.getIntExtra("age",0);
        String n = i.getStringExtra("name");
        String a = i.getStringExtra("symptom");

        t.setText("Name :"+n+"\n"+"Age:"+ag+"\n"+"Symptom:"+a);
    }
}