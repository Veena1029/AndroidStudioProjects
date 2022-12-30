package com.example.stationary673;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox calculator,pen,A4 sheet,battery cell,gift paper;
    Button buttonOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        calculator=(CheckBox)findViewById(R.id.checkBox);
        pen=(CheckBox)findViewById(R.id.checkBox2);
        A4 sheet=(CheckBox)findViewById(R.id.checkBox3);
        battery cell=(CheckBox)findViewById(R.id.checkBox4);
        gift paper=(CheckBox)findViewById(R.id.checkBox5);
        buttonOrder=(Button)findViewById(R.id.button);

        //Applying the Listener on the Button click
        buttonOrder.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder result=new StringBuilder();
                result.append("Selected Items:");
                if(pizza.isChecked()){
                    result.append("\ncalculator");
                    totalamount+=450;
                }
                if(coffe.isChecked()){
                    result.append("\npen");
                    totalamount+=20;
                }
                if(burger.isChecked()){
                    result.append("\nA4 sheet");
                    totalamount+=120;
                }
                if(burger.isChecked()){
                    result.append("\nbattery cell");
                    totalamount+=120;
                }
                if(burger.isChecked()){
                    result.append("\ngift paper");
                    totalamount+=;
                }
                result.append("\nTotal: "+totalamount+"Rs");
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}