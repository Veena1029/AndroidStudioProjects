package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    Button add,sub,mul,div;
    TextView result;
    Double n1,n2,res;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.editTextTextPersonName5);
        num2 = findViewById(R.id.editTextTextPersonName6);
        add = findViewById(R.id.button5);
        sub = findViewById(R.id.button6);
        mul = findViewById(R.id.button7);
        div = findViewById(R.id.button8);
        result = findViewById(R.id.textView);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                res = n1+n2;
                //result.setText(Double.toString(res));
                Toast.makeText(getApplicationContext(),res.toString(),Toast.LENGTH_LONG).show();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                res = n1-n2;
                //result.setText(Double.toString(res));
                Toast.makeText(getApplicationContext(),res.toString(),Toast.LENGTH_LONG).show();
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                res = n1*n2;
                //result.setText(Double.toString(res));
                Toast.makeText(getApplicationContext(),res.toString(),Toast.LENGTH_LONG).show();
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n1=Double.parseDouble(num1.getText().toString());
                n2=Double.parseDouble(num2.getText().toString());
                res = n1/n2;
                //result.setText(Double.toString(res));
                Toast.makeText(getApplicationContext(),res.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}