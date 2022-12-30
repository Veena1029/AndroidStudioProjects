package com.example.voting;

import static com.example.voting.R.id.textView3;

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
        String n = i.getStringExtra("name");
        String c = i.getStringExtra("contact");

        t.setText("Name:"+n+"\nContact:"+c);


    }
}