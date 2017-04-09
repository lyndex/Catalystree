package com.example.catalystreeapp.Transportation;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class CarDataBaseAdapter {

    private static String TAG = "CarDataBaseAdapter";
    private static final String DATABASE_NAME = "catalystree.db";
    private static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    private static final String DATABASE_TABLE = "CAR";

    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_TYPE = "TYPE";
    public static final String COLUMN_DISTANCE = "DISTANCE";
    public static final String COLUMN_TIME = "TIME";

    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table" + " CAR" +
            "( " + "USERNAME text, DATE text, TYPE text, DISTANCE int, TIME int);";
    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private CarDataBaseHelper dbHelper;

    public CarDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new CarDataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public CarDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }


    public void insertEntry(String username, String date, String type, Integer distance, Integer time) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", username);
        newValues.put("DATE", date);
        newValues.put("TYPE", type);
        newValues.put("DISTANCE", distance);
        newValues.put("TIME", time);

        // Insert the row into your table
        db.insert("CAR", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

//    public int deleteEntry(String username) {
//        //String id=String.valueOf(ID);
//        String where = "ID=?";
//        int numberOFEntriesDeleted = db.delete("CAR", where, new String[]{username});
//        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
//        return numberOFEntriesDeleted;
//    }
//
//    public String getSinlgeEntry(String username) {
//        Cursor cursor = db.query("CAR", null, " USERNAME=?", new String[]{username}, null, null, null);
//        if (cursor.getCount() < 1) // UserName Not Exist
//        {
//            cursor.close();
//            return "NOT EXIST";
//        }
//        cursor.moveToFirst();
//        String type = cursor.getString(cursor.getColumnIndex("TYPE"));
//        cursor.close();
//        return type;
//    }


    public Cursor getCarEntry(String username) {
        Cursor carcursor = db.query("CAR", null, " USERNAME=?", new String[]{username}, null, null, null);
        if (carcursor.getCount() < 1) // UserName Not Exist
        {
            carcursor.close();
        }
        carcursor.moveToFirst();
        int counter = 0;
        while (counter < 7) {
            String type = carcursor.getString(carcursor.getColumnIndex("DATE"));
            Integer time = carcursor.getInt(carcursor.getColumnIndex("TIME"));
            counter = counter + 1;
            carcursor.moveToNext();
        }
        carcursor.close();
        return carcursor;
    }
}
//    public void updateEntry(String username, String password, String email) {
//        // Define the updated row content.
//        ContentValues updatedValues = new ContentValues();
//        // Assign values for each row.
//        updatedValues.put("USERNAME", username);
//        updatedValues.put("PASSWORD", password);
//        updatedValues.put("Email", email);
//
//        String where = "USERNAME = ?";
//        db.update("LOGIN", updatedValues, where, new String[]{username});