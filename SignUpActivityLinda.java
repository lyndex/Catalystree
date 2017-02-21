package com.example.letha.login;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.ListView;

public class SignUpActivity extends AppCompatActivity {



    public final static String KEY_COLUMN_ID = "KEY_COLUMN_ID";

    private ListView listView;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        Button button = (Button) findViewById(R.id.button_signin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, CreateOrEditActivity.class);
                intent.putExtra(KEY_COLUMN_ID, 0);
                startActivity(intent);
            }
        });

        dbHandler = new MyDBHandler(this);

        final Cursor cursor = dbHandler.getAllUsers();
        String[] columns = new String[]{
                MyDBHandler.COLUMN_ID,
                MyDBHandler.COLUMN_EMAIL
        };
        int[] widgets = new int[]{
                R.id.userId,
                R.id.email
        };

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.user_info,
                cursor, columns, widgets, 0);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(cursorAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView listView, View view, int position, long id) {
                Cursor itemCursor = (Cursor) SignUpActivity.this.listView.getItemAtPosition(position);
                int personID = itemCursor.getInt(itemCursor.getColumnIndex(MyDBHandler.COLUMN_ID));
                Intent intent = new Intent(getApplicationContext(), CreateOrEditActivity.class);
                intent.putExtra(KEY_COLUMN_ID, personID);
                startActivity(intent);
            }
        });

    }

    public void signUp (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void terms (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void privacy (View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
