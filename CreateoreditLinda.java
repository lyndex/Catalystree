package com.example.letha.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CreateOrEditActivity extends AppCompatActivity implements View.OnClickListener {

    private MyDBHandler dbHandler ;
    EditText emailEditText;
    EditText usernameEditText;
    EditText passwordEditText;

    Button saveButton;
    LinearLayout buttonLayout;
    Button editButton, deleteButton;

    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userId = getIntent().getIntExtra(SignUpActivity.KEY_COLUMN_ID, 0);

        setContentView(R.layout.user_info);
        emailEditText = (EditText) findViewById(R.id.editText_email);
        usernameEditText = (EditText) findViewById(R.id.editText_username);
        passwordEditText = (EditText) findViewById(R.id.editText_password);

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);
        buttonLayout = (LinearLayout) findViewById(R.id.buttonLayout);
        editButton = (Button) findViewById(R.id.editButton);
        editButton.setOnClickListener(this);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(this);

        dbHandler = new MyDBHandler(this);

        if(userId > 0) {
            saveButton.setVisibility(View.GONE);
            buttonLayout.setVisibility(View.VISIBLE);

            Cursor rs = dbHandler.getUser(userId);
            rs.moveToFirst();
            String email = rs.getString(rs.getColumnIndex(MyDBHandler.COLUMN_EMAIL));
            String username = rs.getString(rs.getColumnIndex(MyDBHandler.COLUMN_USERNAME));
            String password = rs.getString(rs.getColumnIndex(MyDBHandler. COLUMN_PASSWORD));
            if (!rs.isClosed()) {
                rs.close();
            }

            emailEditText.setText(email);
            emailEditText.setFocusable(false);
            emailEditText.setClickable(false);

            usernameEditText.setText(username);
            usernameEditText.setFocusable(false);
            usernameEditText.setClickable(false);

            passwordEditText.setText(password);
            passwordEditText.setFocusable(false);
            passwordEditText.setClickable(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.saveButton:
                persistUser();
                return;
            case R.id.editButton:
                saveButton.setVisibility(View.VISIBLE);
                buttonLayout.setVisibility(View.GONE);
                emailEditText.setEnabled(true);
                emailEditText.setFocusableInTouchMode(true);
                emailEditText.setClickable(true);

                usernameEditText.setEnabled(true);
                usernameEditText.setFocusableInTouchMode(true);
                usernameEditText.setClickable(true);

                passwordEditText.setEnabled(true);
                passwordEditText.setFocusableInTouchMode(true);
                passwordEditText.setClickable(true);
                return;
            case R.id.deleteButton:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.delete_user)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dbHandler.deleteUser (userId);
                                Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog d = builder.create();
                d.setTitle("Delete Person?");
                d.show();
        }
    }

    public void persistUser() {
        if(userId > 0) {
            if(dbHandler.updateUser(userId, emailEditText.getText().toString(),
                    usernameEditText.getText().toString(),passwordEditText.getText().toString())) {
                Toast.makeText(getApplicationContext(), "User Update Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "User Update Failed", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            if(dbHandler.addUser(emailEditText.getText().toString(),
                    usernameEditText.getText().toString(),
                    passwordEditText.getText().toString())) {
                Toast.makeText(getApplicationContext(), "User Added", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Could not add user", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
