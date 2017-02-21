package com.example.letha.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";
    private static final String TABLE_USERS = "users";

    static final String COLUMN_ID = "id";
    static final String COLUMN_EMAIL = "email";
    static final String COLUMN_USERNAME = "username";
    static final String COLUMN_PASSWORD = "password";

    MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE" + TABLE_USERS + "(" + COLUMN_ID + "INTEGER PRIMARY COLUMN," + COLUMN_EMAIL + "TEXT," + COLUMN_USERNAME + "TEXT," + COLUMN_PASSWORD + "TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_USERS);
        onCreate(db);
    }

    boolean addUser(String email, String username, String password) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_PASSWORD, password);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USERS, null, contentValues);
        return true;
    }

    boolean updateUser(Integer id, String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_PASSWORD, password);
        db.update(TABLE_USERS, contentValues, COLUMN_ID + "=?", new String[] { Integer.toString(id)});
        return true;
    }

    Cursor getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM" + TABLE_USERS + "WHERE" + COLUMN_ID + "=?", new String[] { Integer.toString(id) } );
    }

    Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery( "SELECT * FROM" + TABLE_USERS, null);
    }

    Integer deleteUser (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_USERS, COLUMN_ID + "=?", new String[] { Integer.toString(id)});
    }
}






