package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.androidanimations.library.Techniques;

public class MainActivity extends AppCompatActivity {
Button btn;
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        txt = findViewById(R.id.textView2);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                YoYo.with(Techniques.Swing)
                        .duration(1000)
                        .playOn(txt);
            }
        });
    }
}