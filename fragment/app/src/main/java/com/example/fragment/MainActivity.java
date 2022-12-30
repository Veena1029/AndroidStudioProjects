package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changefragm(View v)
    {
        Fragment fg;
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if(v==findViewById(R.id.button)) {
            fg = new BlankFragment();
            ft.replace(R.id.frag1, fg);
            ft.commit();
        }
        if(v==findViewById(R.id.button2))
        {
            fg=new BlankFragment2();
            ft.replace(R.id.frag1,fg);
            ft.commit();
        }
    }
}