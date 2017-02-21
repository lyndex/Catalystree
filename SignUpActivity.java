package com.example.sam_2.catalystree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void signUp (View view) {
        Intent intent = new Intent(this, ActivityWelcome.class);
        startActivity(intent);
    }

    public void terms (View view) {
        Intent intent = new Intent(this, ActivityWelcome.class);
        startActivity(intent);
    }

    public void privacy (View view) {
        Intent intent = new Intent(this, ActivityWelcome.class);
        startActivity(intent);
    }
    }
