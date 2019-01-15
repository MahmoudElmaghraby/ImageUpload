package com.mrpistonapp2.android.imageupload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Maintenance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        Toolbar toolbar = findViewById(R.id.maintenance_toolbar);
        setSupportActionBar(toolbar);

    }
}
