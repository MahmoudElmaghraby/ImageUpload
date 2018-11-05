package com.mrpistonapp.android.imageupload;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FourButtons extends AppCompatActivity {

    private Toolbar toolbar;

    private Button img1, img2, img3, img4;
    public static String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_buttons);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Braking System";

                if (isNetworkConnected()) {

                    Intent intent = new Intent(FourButtons.this, LeftButton.class);
                    startActivity(intent);

                }else {

                    Toast.makeText(FourButtons.this, "Please check your internet connection ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Electrical System";

                if (isNetworkConnected()) {

                    Intent intent = new Intent(FourButtons.this, LeftButton.class);
                    startActivity(intent);

                }else {

                    Toast.makeText(FourButtons.this, "Please check your internet connection ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Power-train System";

                if (isNetworkConnected()) {

                    Intent intent = new Intent(FourButtons.this, LeftButton.class);
                    startActivity(intent);

                }else {

                    Toast.makeText(FourButtons.this, "Please check your internet connection ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Suspension System";

                if (isNetworkConnected()) {

                    Intent intent = new Intent(FourButtons.this, LeftButton.class);
                    startActivity(intent);

                }else {

                    Toast.makeText(FourButtons.this, "Please check your internet connection ", Toast.LENGTH_SHORT).show();
                }
            }
        });


//        brakingButton = findViewById(R.id.braking_btn);
//        electricalButton = findViewById(R.id.electrical_btn);
//        transmissionButton = findViewById(R.id.transmission_btn);
//        suspensionButton = findViewById(R.id.suspension_btn);
//
//        brakingButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FourButtons.this , LeftButton.class);
//                startActivity(intent);
//            }
//        });
//
//        electricalButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FourButtons.this , LeftButton.class);
//                startActivity(intent);
//            }
//        });
//
//        transmissionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FourButtons.this , LeftButton.class);
//                startActivity(intent);
//            }
//        });
//
//        suspensionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(FourButtons.this , LeftButton.class);
//                startActivity(intent);
//            }
//        });


    }

    public boolean isNetworkConnected() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;

    }

}
