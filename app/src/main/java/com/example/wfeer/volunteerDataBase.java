package com.example.wfeer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class volunteerDataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "VolunteerDataBase";
    public static final String TABLE_NAME = "VolunteerInfo";

    public static final String col_0 = "ID";
    public static final String col_1 = "NAME";
    public static final String col_2 = "ADDRESS";
    public static final String col_3 = "EMAIL";
    public static final String col_4 = "MOBILE_NUMBER";
    public static final String col_5 = "AGE";
    public static final String col_6 = "NATIONAL_ID";
    public static final String col_7 = "IMAGE_URI";




    public volunteerDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, ADDRESS TEXT, Email TEXT, MOBILE_NUMBER TEXT, AGE TEXT, NATIONAL_ID TEXT, IMAGE_URI TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String address, String email, String mobile, /*String legalID,*/
                           String age, String nationalID, String imageUri){
        //addData method is a method to write data to the data base
        SQLiteDatabase db = getWritableDatabase();
        //connecting each data with its correct row
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1, name);
        contentValues.put(col_2, address);
        contentValues.put(col_3, email);
        contentValues.put(col_4, mobile);
//        contentValues.put(col_5, legalID);
        contentValues.put(col_6, age);
        contentValues.put(col_7, nationalID);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1 ) {
            return false;
        }
        else {
            return true;
        }
    }//End addData

    public Cursor getAllData(){ //This method is to extract all the data from the database
        SQLiteDatabase db = this.getWritableDatabase(); //this line is used so we can make sure our database is created
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }
}
