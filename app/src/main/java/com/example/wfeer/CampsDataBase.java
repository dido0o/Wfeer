package com.example.wfeer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Arrays;

public class CampsDataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "CampsDataBase1";
    public static final String TABLE_NAME = "CampInfo";
    /* Its good to know that columns names defined below, must be exactly the same as the names in
    the onCreate method */

    /*database mistake might cost a lot of time: if you added a new column and you did not remove the
     old database, the new column will not be added, and if you didn't handle it will cause the app to crush*/
    public static final String col_0 = "ID";
    public static final String col_1 = "NAME";
    public static final String col_2 = "CAMP_ADDRESS";
    public static final String col_3 = "EMAIL";
    public static final String col_4 = "MOBILE_NUMBER";
    public static final String col_5 = "LEGAL_ID";
    public static final String col_6 = "FOOD_TYPE";
    public static final String col_7 = "FOOD_AMOUNT";
    public static final String col_8 = "EXPIRE_DATE";
    public static final String col_9 = "IMAGE_URI";

    String name;
    String foodType;
    String email;
    boolean added = true;


    public CampsDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, CAMP_ADDRESS TEXT, Email TEXT, MOBILE_NUMBER TEXT, LEGAL_ID TEXT, FOOD_TYPE TEXT, FOOD_AMOUNT TEXT, EXPIRE_DATE TEXT, IMAGE_URI TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String name, String address, String email, String mobile, /*String legalID,*/
                           String foodType, String foodAmount, String expireDate, String imageUri){
        //addData method is a method to write data to the data base
        SQLiteDatabase db = getWritableDatabase();
        //connecting each data with its correct row
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1, name);
        contentValues.put(col_2, address);
        contentValues.put(col_3, email);
        contentValues.put(col_4, mobile);
//        contentValues.put(col_5, legalID);
        contentValues.put(col_6, foodType);
        contentValues.put(col_7, foodAmount);
        contentValues.put(col_8, expireDate);
        contentValues.put(col_9, imageUri);


        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1 ) {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllData(){ //This method is to extract all the data from the database
        SQLiteDatabase db = this.getWritableDatabase(); //this line is used so we can make sure our database is created
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }
}
