package com.example.midterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public static final String col = "ID";
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table phone(bid varchar(20),bname varchar(25),mail varchar(30),num int)");
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){

    }
    void insertrow(String model, String name, String mai, int numb)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("bid",model);
        cv.put("bname",name);
        cv.put("mail",mai);
        cv.put("num",numb);
        sq.insert("phone",null,cv);
        sq.close();
    }
    String display(){
        String result = "";
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from phone", null);
        while(c.moveToNext())
        {
            String model = c.getString(0);
            String name = c.getString(1);
            String mai = c.getString(2);
            String numb = c.getString(2);
            result =  "Customer name: "+name+"\t"+" Phone number: "+numb+"\t"+" Model: "+model+"\t"+" Mail id: "+mai+"\n";
        }
        sq.close();
        return result;
    }
}

