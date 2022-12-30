package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.textView);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number;
                Random rnd = new Random();
                number=rnd.nextInt(100);
                //txt.setText(String.valueOf(number));
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("number1",Integer.toString(number));
                startActivity(intent);
            }
        });
    }
}