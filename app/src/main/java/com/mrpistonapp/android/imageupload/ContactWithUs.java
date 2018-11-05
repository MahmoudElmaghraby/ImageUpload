package com.mrpistonapp.android.imageupload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactWithUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);

        Button facebookBtn = findViewById(R.id.facebook_button);
        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContactWithUs.this, "test", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
