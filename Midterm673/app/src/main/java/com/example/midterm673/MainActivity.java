package com.example.midterm673;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    CheckBox books673,notes673,scis673,pen673,calc673;
    EditText contact673,name673;
    Button btn673;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick(){
        books673 = (CheckBox) findViewById(R.id.book673);
        notes673 = findViewById(R.id.notes673);
        pen673 = findViewById(R.id.pen673);
        scis673 = findViewById(R.id.scis673);
        btn673 = findViewById(R.id.btn673);
        name673 = findViewById(R.id.name673);
        calc673 = findViewById(R.id.calc673);
        contact673 = findViewById(R.id.contact673);
        btn673.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder s673 = new StringBuilder();
                try{
                    int total = 0;
                    s673.append("NAME : " + (name673.getText().toString()) + "\nCONTACT : "
                            + contact673.getText().toString() + "\n\nORDER DETAILS: \n");
                    if(books673.isChecked()) {
                        s673.append("Books \n"); total += 180;
                    }
                    if(notes673.isChecked()) {
                        s673.append("Sticky Notes\n"); total += 60;
                    }
                    if(scis673.isChecked()) {
                        s673.append("Scissors\n"); total += 150;
                    }
                    if(calc673.isChecked()) {
                        s673.append("Calculator\n"); total += 1100;
                    }
                    if(pen673.isChecked()) {
                        s673.append("Pen/Pencil\n"); total += 100;
                    }

                    s673.append( "PRICE : RS. " + total );

                }
                catch(Exception ex){
                    Toast.makeText(MainActivity.this, "Invalid Order Placed", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("Order confirmation", s673.toString());
                startActivity(intent);
                for(int i = 0; i < 50000; i++){
                    //Delay
                }


            }
        });
    }
}