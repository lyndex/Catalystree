package com.example.catalystreeapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentProfile extends Fragment {


    public FragmentProfile() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        return rootView;
    }

////    create cursor
//    public Cursor retrieveRecords(int category)
//    {
//        Cursor c = null;
//
//        c =db.rawQuery("SELECT id, username FROM people WHERE username = ?", new String[] {""});
//        return c;
//    }
//
////    retrieve data from cursor
//    public void getDataFromDatabase()
//    {
//        try
//        {
//            Cursor cursor = null;
//            db.OpenDatabase();
//            cursor = db.retrieveRecords();
//            if (cursor.getCount() != 0)
//            {
//                if (cursor.moveToFirst())
//                {
//                    do
//                    {
//                        titleArrayList.add(cursor.getString(cursor.getColumnIndex("title")));
//                        bodyArrayList.add(cursor.getString(cursor.getColumnIndex("body")));
//                    } while (cursor.moveToNext());
//                }
//                db.closeDatabase();
//            }
//            cursor.close();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
}
