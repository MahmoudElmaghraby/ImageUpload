package com.mrpistonapp.android.imageupload;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class LeftButton extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;
    private String nameAchieved;
    private String string1 , string2 , string4 ;
    private int string3;

    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;

    private List<Upload> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_button);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mUploads = new ArrayList<>();

        mAdapter = new ImageAdapter(LeftButton.this, mUploads);
        mRecyclerView.setAdapter(mAdapter);


        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mUploads.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    nameAchieved = postSnapshot.child("mName").toString();
                    Upload upload = postSnapshot.getValue(Upload.class);
                    upload.setmKey(postSnapshot.getKey());
                    string1 = upload.getmModel();
                    string2 = upload.getmSubModel();
                    string3 = upload.getmYear();
                    string4 = upload.getmCat();

                    if(string1.equals(Choose.brand)
                            &&
                            string2.equals(Choose.chosenModel)
                            &&
                            string3 == Choose.chosenYear
                            &&
                            string4.equals(FourButtons.type)) {
//                        Upload upload = postSnapshot.getValue(Upload.class);
                        mUploads.add(upload);
                    }

                }

                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(LeftButton.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        mAdapter.setOnItemClickListener(new ImageAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Upload currentUpload = mUploads.get(position);
                MainActivity.productName = currentUpload.getName();
                MainActivity.productPtNo = currentUpload.getmPartNo();
                MainActivity.productType = currentUpload.getmType();
                MainActivity.productPrice = currentUpload.getmSPrice();
                MainActivity.productImage = currentUpload.getImageUrl();
                MainActivity.productCountry = currentUpload.getmCountry();

                Intent intent = new Intent(LeftButton.this, ProductDetails.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
    }


}

