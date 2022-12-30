package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView tx1,tx2,txt3;
    Button btn3;
    String intValue,intValue2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tx1=findViewById(R.id.textView3);
        tx2=findViewById(R.id.textView4);
        txt3=findViewById(R.id.textView5);
        btn3=findViewById(R.id.button3);
        Intent intent2=getIntent();
        intValue = intent2.getStringExtra("number1");
        intValue2=intent2.getStringExtra("number2");
        tx1.setText(intValue);
        tx2.setText(intValue2.toString());
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result,num1,num2;
                num1=Integer.parseInt(intValue);
                num2=Integer.parseInt(intValue2);
                result=num1+num2;
                txt3.setText("Addition ="+result);
            }
        });
    }
}