package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView txt2;
    Button btn2;
    String intValue1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt2=findViewById(R.id.textView2);
        btn2=findViewById(R.id.button2);
        Intent intent = getIntent();
        intValue1 = intent.getStringExtra("number1");
        txt2.setText(intValue1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number2;
                Random rnd = new Random();
                number2=rnd.nextInt(100);
                Intent intent1=new Intent(MainActivity2.this,MainActivity3.class);
                intent1.putExtra("number1",intValue1);
                intent1.putExtra("number2",Integer.toString(number2));
                startActivity(intent1);

            }
        });
    }
}