package com.example.gokul.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by Gokul on 8/22/2015.
 */
public class DB extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "StudentDB";

    public DB(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE student(regno varchar,name varchar,dob varchar,tyype varchar,board varchar,tot varchar,cut varchar,mob varchar,GPA1 varchar, GPA2 varchar, GPA3 varchar, GPA4 varchar, GPA5 varchar,CGPA varchar,famob varchar,mamob varchar);");
        db.execSQL("INSERT INTO student VALUES ('410712205012','Gokul.G','27/9/95','GOVT','GOVT','997','155.5','91719343000','7.69','7.2&1','6.90','6.400','7.2&2','7.1','9171934300','9171934300');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }
    public boolean insertContact (String regno, String name, String dob, String tyype,String board,String tot,String cut,String mob,String GPA1,String GPA2,String GPA3,String GPA4,String GPA5,String CGPA,String famob,String mamob)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("regno", regno);
        contentValues.put("name", name);
        contentValues.put("dob", dob);
        contentValues.put("tyype", tyype);
        contentValues.put("board", board);
        contentValues.put("tot", tot);
        contentValues.put("cut", cut);
        contentValues.put("mob", mob);
        contentValues.put("GPA1", GPA1);
        contentValues.put("GPA2", GPA2);
        contentValues.put("GPA3", GPA3);
        contentValues.put("GPA4", GPA4);
        contentValues.put("GPA5", GPA5);
        contentValues.put("CGPA", CGPA);
        contentValues.put("famob", famob);
        contentValues.put("mamob", mamob);
        db.insert("student", null, contentValues);
        return true;
    }

    public Cursor getData(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from student where regno="+id+"", null );
        return res;
    }

}
