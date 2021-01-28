package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String name = getIntent().getExtras().getString("studentsname");
        TextView nameTextView;
        nameTextView = findViewById(R.id.textViewhome);
        nameTextView.setText(name);
    }
}