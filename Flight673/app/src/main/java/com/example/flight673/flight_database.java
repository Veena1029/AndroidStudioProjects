package com.example.flight673;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class flight_database extends SQLiteOpenHelper {
    public static final String col = "ID";
    public flight_database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table Flight673(FID varchar(20), Flight_name varchar(25),Ffrom varchar(30),Fto varchar(30))");
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,int i, int i1){

    }
    void insertrow(String id, String name, String src,String des)
    {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FID",id);
        cv.put("Flight_name",name);
        cv.put("Ffrom",src);
        cv.put("Fto",des);
        sq.insert("Flight673",null,cv);
        sq.close();
    }
    String display(){
        String result = "";
        SQLiteDatabase sq = this.getReadableDatabase();
        Cursor c = sq.rawQuery("select * from Flight673", null);
        while(c.moveToNext())
        {
            String id = c.getString(0);
            String name = c.getString(1);
            String frm = c.getString(2);
            String des = c.getString(3);
            result = result + "Flight id: "+id+"\t"+"Flight name: "+name+"\n"+"FROM: "+frm+"\t"+"TO: "+des+"\n";
        }
        sq.close();
        return result;
    }
    void remove(String id){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("delete from Flight673 where FID="+"'"+id+"'");
    }
    void update(String oid,String nid){
        SQLiteDatabase sq = this.getWritableDatabase();
        sq.execSQL("update Flight673 set FID="+"'"+nid+"'"+"where FID="+"'"+oid+"'");

    }
}

