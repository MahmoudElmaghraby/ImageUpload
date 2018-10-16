package com.example.android.imageupload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Lubricants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lubricants);

        Toolbar toolbar = findViewById(R.id.laubricants_toolbar);
        setSupportActionBar(toolbar);

    }
}
