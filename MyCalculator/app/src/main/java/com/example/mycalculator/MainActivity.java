package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{
    private EditText etn1;
    private EditText etn2;
    private TextView textViewResult;
    double n1,n2,sum,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etn1=(EditText) findViewById(R.id.etn1);
        etn2=(EditText) findViewById(R.id.etn2);
        textViewResult=(TextView) findViewById(R.id.textViewResult);

    }

    public void btsum(View view)
    {
        n1=Double.parseDouble(etn1.getText().toString());
        n2=Double.parseDouble(etn2.getText().toString());
        sum= n1+n2;
        Toast.makeText(MainActivity.this, "Value after Addition is "+sum, Toast.LENGTH_SHORT).show();
        textViewResult.setText(String.valueOf(sum));
    }

    public void btmul(View view)
    {
        n1=Double.parseDouble(etn1.getText().toString());
        n2=Double.parseDouble(etn2.getText().toString());
        mul= n1*n2;
        Toast.makeText(MainActivity.this, "Value after Multiplication is "+mul, Toast.LENGTH_SHORT).show();
        textViewResult.setText(String.valueOf(mul));
    }

    public void btsub(View view)
    {
        n1=Double.parseDouble(etn1.getText().toString());
        n2=Double.parseDouble(etn2.getText().toString());
        sub= n1-n2;
        Toast.makeText(MainActivity.this, "Value after Subtraction is "+sub, Toast.LENGTH_SHORT).show();
        textViewResult.setText(String.valueOf(sub));
    }

    public void btdiv(View view)
    {
        n1=Double.parseDouble(etn1.getText().toString());
        n2=Double.parseDouble(etn2.getText().toString());
        div= n1/n2;
        Toast.makeText(MainActivity.this, "Value after Division is "+div, Toast.LENGTH_SHORT).show();
        textViewResult.setText(String.valueOf(div));
    }
    public void btclr(View view)
    {
        etn1.getText().clear();
        etn2.getText().clear();
    }
}