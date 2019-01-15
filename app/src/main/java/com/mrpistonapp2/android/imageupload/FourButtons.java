package com.mrpistonapp2.android.imageupload;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class FourButtons extends AppCompatActivity {

    private Toolbar toolbar;

    private Button img1, img2, img3, img4;
    public static String type;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_buttons);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, "ca-app-pub-3430687372646829~3752500494");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


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
                type = "Engine";

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


    }

    public boolean isNetworkConnected() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;

    }

}
