package com.example.foysal.onlineexamination;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Foysal on 4/13/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "login.sqLiteDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user(email text primary key,name text, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");

    }
    public boolean insert(String email, String password, String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("name", name);
        long ins = sqLiteDatabase.insert("user", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }
    public String getStudentName(String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where email=? and password=?",new String []{email,password});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            return cursor.getString(cursor.getColumnIndex("name"));
        }else {
            return "foysal";
        }
    }

    public boolean chkemail(String email){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where email=?",new String[]{email});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    public boolean emailPassword(String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user where email=? and password=?",new String []{email,password});
        if (cursor.getCount()>0) return true;
        else  return false;
    }

}
