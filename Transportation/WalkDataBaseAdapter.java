package com.example.catalystreeapp.Transportation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.catalystreeapp.Main.MasterDataBaseHelper;

public class WalkDataBaseAdapter {

    private static final String DATABASE_NAME = "catalystree.db";
    private static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    private static final String DATABASE_TABLE ="WALK";

    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_DISTANCE = "DISTANCE";
    public static final String COLUMN_TIME = "TIME";

    // Variable to hold the database instance
    public SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private MasterDataBaseHelper dbHelper;

    public WalkDataBaseAdapter(Context _context) {
        context = _context;
        dbHelper = new MasterDataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public WalkDataBaseAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDatabaseInstance() {
        return db;
    }

    public void insertEntry(String USERNAME, String date, Integer distance, Integer time) {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", USERNAME);
        newValues.put("DATE", date);
        newValues.put("DISTANCE", distance);
        newValues.put("TIME", time);

        // Insert the row into your table
        db.insert("CAR", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String UserName) {
        //String id=String.valueOf(ID);
        String where = "ID=?";
        int numberOFEntriesDeleted = db.delete("LOGIN", where, new String[]{UserName});
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }

    public String getSinlgeEntry(String userName) {
        Cursor cursor = db.query("CAR", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String type = cursor.getString(cursor.getColumnIndex("TYPE"));
        cursor.close();
        return type;
    }

    public void updateEntry(String userName, String password, String email) {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD", password);
        updatedValues.put("Email", email);

        String where = "USERNAME = ?";
        db.update("LOGIN", updatedValues, where, new String[]{userName});
    }
}
