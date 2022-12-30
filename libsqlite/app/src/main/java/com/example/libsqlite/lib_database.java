package com.example.libsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class lib_database extends SQLiteOpenHelper {
    public static final String col = "ID";
    public lib_database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table library(bid varchar(20),bname varchar(25),dep varchar(30))");
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){

    }
    void insertrow(String id, String name, String dept)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("bid",id);
        cv.put("bname",name);
        cv.put("dep",dept);
        sq.insert("library",null,cv);
        sq.close();
    }
    String display(){
        String result = "";
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from library", null);
        while(c.moveToNext())
        {
            String id = c.getString(0);
            String name = c.getString(1);
            String dept = c.getString(2);
            result = result + "Book id: "+id+"\t"+" Book name: "+name+"\t"+" Department: "+dept+"\n";
        }
        sq.close();
        return result;
    }
    void remove(String id){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("delete from library where bid="+"'"+id+"'");
    }
   void updateid(String oid,String nid){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("update library set bid="+"'"+nid+"'"+"where bid="+"'"+oid+"'");

    }
}

