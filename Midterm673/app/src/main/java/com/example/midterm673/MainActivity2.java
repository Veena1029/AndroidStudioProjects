package com.example.midterm673;

import static com.example.midterm673.R.id.content673;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {
    TextView t;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t = findViewById(content673);
        Intent intent = getIntent();
        String str673 = intent.getStringExtra("Order confirmation");
        t.setText(str673);


    }
}