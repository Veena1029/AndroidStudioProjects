package com.example.libsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    lib_database db;
    EditText id,name,eid,dept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new lib_database(getApplicationContext(),"library",null,1);
        id = findViewById(R.id.editTextTextPersonName);
        name = findViewById(R.id.editTextTextPersonName2);
        eid = findViewById(R.id.editTextTextPersonName3);
        dept = findViewById(R.id.editTextTextPersonName4);

    }
    public void setmethod(View v)
    {
        String id1 = id.getText().toString();
        String name1 = name.getText().toString();
        String dept1 = dept.getText().toString();
        if(id1==" " && name1==" " && dept1==" ")
        {
            Toast.makeText(this, "Input appropriate Values", Toast.LENGTH_SHORT).show();
        }
        else
        {
            db.insertrow(id1,name1,dept1);
            Toast.makeText(this, "Created Succesfully", Toast.LENGTH_SHORT).show();

        }
    }
    public void getmethod(View v)
    {
        String data = db.display();
        Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
    }
    public void deleteid(View v){
        String delid =  eid.getText().toString();
        db.remove(delid);
        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_SHORT).show();
    }
    public void updateid(View v){
        String newid =  eid.getText().toString();
        String oldid= id.getText().toString();
        db.updateid(oldid,newid);
        Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
    }
}