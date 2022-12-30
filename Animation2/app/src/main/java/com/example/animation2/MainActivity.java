package com.example.animation2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;
Button blink1,fade,zoom,ror,slide,mov,stp;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.imageView2);
        blink1 = findViewById(R.id.button);
        fade = findViewById(R.id.button2f);
        ror = findViewById(R.id.button4r);
        mov = findViewById(R.id.button3m);
        zoom = findViewById(R.id.button6z);
        slide = findViewById(R.id.button5s);
        slide = findViewById(R.id.button5s);
        stp = findViewById(R.id.button7);
        blink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                img.startAnimation(a);
            }
        });

        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
                img.startAnimation(a1);
            }
        });
        mov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                img.startAnimation(a1);
            }
        });
        ror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                img.startAnimation(a1);
            }
        });

        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
                img.startAnimation(a1);
            }
        });

        slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
                img.startAnimation(a1);
            }
        });

        stp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // To stop the animation going on imageview
                img.clearAnimation();
            }
        });
    }
}