package com.example.todolist;
import android.annotation.SuppressLint;
import android.app.LauncherActivity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList items;
    ArrayAdapter arrayAdapter;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.listview);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });
        items=new ArrayList();
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        list.setAdapter(arrayAdapter);
        setUpListViewListner();
    }
    private void setUpListViewListner() {
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context=getApplicationContext();
                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();
                items.remove(position);
                arrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
    private void addItem(View v){
        EditText et=findViewById(R.id.editText);
        String itemText=et.getText().toString();
        if(!(itemText.equals(""))){
            arrayAdapter.add(itemText);
            et.setText(" ");
        }
        else {
            Toast.makeText(getApplicationContext()," ",Toast.LENGTH_LONG).show();
        }
    }
}