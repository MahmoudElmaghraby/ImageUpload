package com.example.android.imageupload;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Choose extends AppCompatActivity {

    private Spinner mainSpinner, supSpinner1, supSpinner2, supSpinner3;
    private RadioGroup subRG1_1, subRG1_2, subRG1_3, subRG2_1, subRG2_2, subRG2_3, subRG3_1, subRG3_2, subRG3_3;
    private Button okButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose.this , FourButtons.class);
                startActivity(intent);
            }
        });

        subRG1_1 = findViewById(R.id.sub_radio_group_1_1);
        subRG1_2 = findViewById(R.id.sub_radio_group_1_2);
        subRG1_3 = findViewById(R.id.sub_radio_group_1_3);
        subRG2_1 = findViewById(R.id.sub_radio_group_2_1);
        subRG2_2 = findViewById(R.id.sub_radio_group_2_2);
        subRG2_3 = findViewById(R.id.sub_radio_group_2_3);
        subRG3_1 = findViewById(R.id.sub_radio_group_3_1);
        subRG3_2 = findViewById(R.id.sub_radio_group_3_2);
        subRG3_3 = findViewById(R.id.sub_radio_group_3_3);

        mainSpinner = findViewById(R.id.main_spinner);
        ArrayAdapter<CharSequence> mainAdapter = ArrayAdapter.createFromResource(this, R.array.mainStringArray, android.R.layout.simple_spinner_item);
        mainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainSpinner.setAdapter(mainAdapter);
        mainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        supSpinner1.setVisibility(View.VISIBLE);
                        supSpinner2.setVisibility(View.GONE);
                        supSpinner3.setVisibility(View.GONE);
                        break;
                    case 1:
                        supSpinner1.setVisibility(View.GONE);
                        supSpinner2.setVisibility(View.VISIBLE);
                        supSpinner3.setVisibility(View.GONE);
                        break;
                    case 2:
                        supSpinner1.setVisibility(View.GONE);
                        supSpinner2.setVisibility(View.GONE);
                        supSpinner3.setVisibility(View.VISIBLE);
                        break;
                    default:
                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        supSpinner1 = findViewById(R.id.sub_spinner1);
        ArrayAdapter<CharSequence> subAdapter1 = ArrayAdapter.createFromResource(this, R.array.subStringArray1, android.R.layout.simple_spinner_item);
        subAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        supSpinner1.setAdapter(subAdapter1);
        supSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        subRG1_1.setVisibility(View.VISIBLE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    case 1:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.VISIBLE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    case 2:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.VISIBLE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    default:
                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        supSpinner2 = findViewById(R.id.sub_spinner2);
        ArrayAdapter<CharSequence> subAdapter2 = ArrayAdapter.createFromResource(this, R.array.subStringArray2, android.R.layout.simple_spinner_item);
        subAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        supSpinner2.setAdapter(subAdapter2);
        supSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.VISIBLE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    case 1:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.VISIBLE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    case 2:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.VISIBLE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    default:
                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        supSpinner3 = findViewById(R.id.sub_spinner3);
        ArrayAdapter<CharSequence> subAdapter3 = ArrayAdapter.createFromResource(this, R.array.subStringArray3, android.R.layout.simple_spinner_item);
        subAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        supSpinner3.setAdapter(subAdapter3);
        supSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.VISIBLE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    case 1:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.VISIBLE);
                        subRG3_3.setVisibility(View.GONE);
                        break;
                    case 2:
                        subRG1_1.setVisibility(View.GONE);
                        subRG1_2.setVisibility(View.GONE);
                        subRG1_3.setVisibility(View.GONE);
                        subRG2_1.setVisibility(View.GONE);
                        subRG2_2.setVisibility(View.GONE);
                        subRG2_3.setVisibility(View.GONE);
                        subRG3_1.setVisibility(View.GONE);
                        subRG3_2.setVisibility(View.GONE);
                        subRG3_3.setVisibility(View.VISIBLE);
                        break;
                    default:
                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
