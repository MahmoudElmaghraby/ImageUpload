package com.mrpistonapp2.android.imageupload;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.mrpistonapp2.android.imageupload.MainActivity.mrPistonDBRef;

public class Choose extends AppCompatActivity {

    private Spinner modelSpinner , yearSpinner ;
    private Button okButton;
    private ImageView toyotaImage, kiaImage, hyundaiImage;

    public static String brand = "Toyota" , model , chosenModel  ;
    public static String year , chosenYear ;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        MobileAds.initialize(this, "ca-app-pub-3430687372646829~3752500494");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toyotaImage = findViewById(R.id.toyota_image);
        kiaImage = findViewById(R.id.kia_image);
        hyundaiImage = findViewById(R.id.hyundai_image);

        modelSpinner = findViewById(R.id.model_spinner);
        yearSpinner = findViewById(R.id.year_spinner);

        okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chosenYear =  yearSpinner.getSelectedItem().toString();
                Intent intent = new Intent(Choose.this , FourButtons.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<CharSequence> firstAdapter = ArrayAdapter.createFromResource(Choose.this , R.array.modelArray , android.R.layout.simple_spinner_item);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(firstAdapter);

        ArrayAdapter<CharSequence> secondAdapter = ArrayAdapter.createFromResource(Choose.this , R.array.yearArray , android.R.layout.simple_spinner_item);
        secondAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(secondAdapter);

        toyotaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brand = "Toyota" ;
                modelSpinner.setVisibility(View.VISIBLE);
                yearSpinner.setVisibility(View.VISIBLE);
                okButton.setVisibility(View.VISIBLE);

                getModelsFromDatabase();

            }
        });

        kiaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brand = "Kia" ;
                modelSpinner.setVisibility(View.VISIBLE);
                yearSpinner.setVisibility(View.VISIBLE);
                okButton.setVisibility(View.VISIBLE);

                getModelsFromDatabase();

            }
        });

        hyundaiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                brand = "Hyundai" ;
                modelSpinner.setVisibility(View.VISIBLE);
                yearSpinner.setVisibility(View.VISIBLE);
                okButton.setVisibility(View.VISIBLE);

                getModelsFromDatabase();
            }
        });


        //L7AD HENAAAAA !!!!!!!!!!!!!!
        modelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                chosenModel = modelSpinner.getSelectedItem().toString();
                getYearFromDatabase();
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void getModelsFromDatabase(){

        mrPistonDBRef.child("Cars").child(brand).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final List<String> Cars = new ArrayList<String>();

                for (DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                    String carModel = areaSnapshot.getKey();
                    Cars.add(carModel);
                }

                ArrayAdapter<String> areasAdapter = new ArrayAdapter<String>(Choose.this, android.R.layout.simple_spinner_item, Cars);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                modelSpinner.setAdapter(areasAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public void getYearFromDatabase(){


        //HAGARRAB MN HNA!!!!!!!!!!!!!!222222  Bageeb Car Years bi dih!   22222222222222

        mrPistonDBRef.child("Cars").child(brand).child(chosenModel).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> yearss = new ArrayList<>();

                for (DataSnapshot areaSnapshot: dataSnapshot.getChildren()) {
                    String carYear = areaSnapshot.getKey();
                    yearss.add(carYear);
                }

                ArrayAdapter<String> areasAdapter = new ArrayAdapter<>(Choose.this, android.R.layout.simple_spinner_item, yearss);
                areasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                yearSpinner.setAdapter(areasAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError2) {

            }
        });


        //L7AD HENAAAAA !!!!!!!!!!!!!!

    }

}
