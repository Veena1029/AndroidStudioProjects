package com.example.flight673;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    flight_database db;
    EditText id,name,from,des,eid,uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new flight_database(getApplicationContext(),"Flight673",null,1);
        id = findViewById(R.id.editTextTextPersonName);
        name = findViewById(R.id.editTextTextPersonName2);
        from = findViewById(R.id.editTextTextPersonName3);
        des = findViewById(R.id.editTextTextPersonName4);
        eid = findViewById(R.id.editTextTextPersonName6);
        uid = findViewById(R.id.editTextTextPersonName7);
    }
    public void setmethod(View v)
    {
        String id1 = id.getText().toString();
        String name1 = name.getText().toString();
        String from1 = from.getText().toString();
        String to1 = des.getText().toString();
        if(id1=="" || name1=="" || from1=="" || to1=="")
        {
            Toast.makeText(this, "Please Input all Values", Toast.LENGTH_SHORT).show();
        }
        else
        {
            db.insertrow(id1,name1,from1,to1);
            Toast.makeText(this, "Created Successfully", Toast.LENGTH_SHORT).show();

        }
    }
    public void retrieve(View v)
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
        String newid =  uid.getText().toString();
        String oldid= id.getText().toString();
        db.update(oldid,newid);
        Toast.makeText(this, "Updated Successfully", Toast.LENGTH_SHORT).show();
    }
}