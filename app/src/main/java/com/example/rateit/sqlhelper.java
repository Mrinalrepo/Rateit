package com.example.rateit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class sqlhelp extends SQLiteOpenHelper {
    public static final String Database_name = "Records";
    public static String Table_name = "rate_record";
    public static String Col1 = "Date_time";

    public sqlhelp(Context context) {
        super(context, Database_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + Table_name + "(Date_time String)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(db);

    }

    public boolean insertData(String Date_time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col1, Date_time);
        long result = db.insert(Table_name, null, contentValues);
        return result != -1;
    }

}


