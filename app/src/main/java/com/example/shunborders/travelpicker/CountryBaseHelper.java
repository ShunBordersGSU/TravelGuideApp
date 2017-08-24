package com.example.shunborders.travelpicker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shunborders.travelpicker.CountryDBSchema.CountryTable;

/**
 * Created by shunborders on 3/4/2017.
 */

public class CountryBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "countryDatabase.db";
    public CountryBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CountryTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CountryTable.Cols.UUID + ", " +
                CountryTable.Cols.COUNTRYNAME + ", " +
                CountryTable.Cols.CONTINENT + ", " +
                CountryTable.Cols.FLAG + ", " +
                CountryTable.Cols.INFO + ", " +
                CountryTable.Cols.PIC + ", " +
                CountryTable.Cols.COMMENTS + ", " +
                CountryTable.Cols.RATING +
                ")"
        );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
