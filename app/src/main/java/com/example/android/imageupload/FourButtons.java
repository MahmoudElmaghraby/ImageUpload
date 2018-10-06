package com.example.android.imageupload;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FourButtons extends AppCompatActivity {

    private Toolbar toolbar ;

    private Button img1 , img2 , img3 , img4 ;
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
                type = "Breaking System" ;

                Intent intent = new Intent(FourButtons.this , LeftButton.class);
                startActivity(intent);
            }
        });


        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Electrical System";

                Intent intent = new Intent(FourButtons.this , LeftButton.class);
                startActivity(intent);
            }
        });

        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Power-train System" ;

                Intent intent = new Intent(FourButtons.this , LeftButton.class);
                startActivity(intent);
            }
        });

        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Suspension System";

                Intent intent = new Intent(FourButtons.this , LeftButton.class);
                startActivity(intent);
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
}
