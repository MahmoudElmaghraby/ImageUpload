package com.mrpistonapp2.android.imageupload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactWithUs extends AppCompatActivity {

    private Button faceBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_with_us);

        faceBtn = findViewById(R.id.my_facebook_button);
        faceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContactWithUs.this, "facebook", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
