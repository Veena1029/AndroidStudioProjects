package com.example.restaurantbooking;


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
        db.execSQL("create table rest(bid varchar(20),bname varchar(25),dep varchar(30))");
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){

    }
    void insertrow(String id, String name, String tym)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("bid",id);
        cv.put("bname",name);
        cv.put("dep",tym);
        sq.insert("rest",null,cv);
        sq.close();
    }
    String display(){
        String result = "";
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from rest", null);
        while(c.moveToNext())
        {
            String id = c.getString(0);
            String name = c.getString(1);
            String tym = c.getString(2);
            result = result + "Name : "+name+"\n"+" Phone number: "+id+"\t"+" Slot: "+tym+"\n";
        }
        sq.close();
        return result;
    }
    void remove(String name){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("delete from rest where bid="+"'"+name+"'");
    }

}

