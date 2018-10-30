package com.example.android.imageupload;

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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.imageupload.MainActivity.mrPistonDBRef;

public class Choose extends AppCompatActivity {

    private Spinner modelSpinner , yearSpinner ;
   // private RadioGroup subRG1_1, subRG1_2, subRG1_3, subRG2_1, subRG2_2, subRG2_3, subRG3_1, subRG3_2, subRG3_3;
    private Button okButton; // button1 , button2 , button3 , button1_1 , button1_2;
    private ImageView toyotaImage, kiaImage, hyundaiImage;


//    private LinearLayout sup1, sup1_1;

    public static String brand = "Toyota" , model , chosenModel  ;
    public static int year , chosenYear ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

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
                chosenYear =  Integer.parseInt(yearSpinner.getSelectedItem().toString());
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

//        yearSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                chosenYear = (Integer) yearSpinner.getSelectedItem();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });





//
//        modelSpinner = findViewById(R.id.model_spinner);
//        yearSpinner = findViewById(R.id.year_spinner);

//        toyotaAdapter = ArrayAdapter.createFromResource(this, R.array.toyotaArray1, android.R.layout.simple_spinner_item);
//        kiaAdapter = ArrayAdapter.createFromResource(this, R.array.kiaArray1, android.R.layout.simple_spinner_item);
//        hyundaiAdapter = ArrayAdapter.createFromResource(this, R.array.hyundaiArray1, android.R.layout.simple_spinner_item);
//
//        toyota1Adapter = ArrayAdapter.createFromResource(this , R.array.toyotaArray1_1 , android.R.layout.simple_spinner_item);
//        toyota2Adapter = ArrayAdapter.createFromResource(this , R.array.toyotaArray1_2 , android.R.layout.simple_spinner_item);
//        toyota3Adapter = ArrayAdapter.createFromResource(this , R.array.toyotaArray1_3 , android.R.layout.simple_spinner_item);
//        kia1Adapter = ArrayAdapter.createFromResource(this , R.array.kiaArray1_1 , android.R.layout.simple_spinner_item);
//        kia2Adapter = ArrayAdapter.createFromResource(this , R.array.kiaArray1_2 , android.R.layout.simple_spinner_item);
//        kia3Adapter = ArrayAdapter.createFromResource(this , R.array.kiaArray1_3 , android.R.layout.simple_spinner_item);
//        hyundai1Adapter = ArrayAdapter.createFromResource(this , R.array.hyundaiArray1_1 , android.R.layout.simple_spinner_item);
//        hyundai2Adapter = ArrayAdapter.createFromResource(this , R.array.hyundaiArray1_2 , android.R.layout.simple_spinner_item);
//        hyundai3Adapter = ArrayAdapter.createFromResource(this , R.array.hyundaiArray1_3 , android.R.layout.simple_spinner_item);


//        sup1 = findViewById(R.id.sup1);
//        sup1_1 = findViewById(R.id.sub1_1);
//
//        okButton = findViewById(R.id.ok_button);
//        okButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Choose.this , FourButtons.class);
//                startActivity(intent);
//            }
//        });
//
////        button1 = findViewById(R.id.button_1);
////        button2 = findViewById(R.id.button_2);
////        button3 = findViewById(R.id.button_3);
////        button1_1 = findViewById(R.id.button_1_1);
////        button1_2 = findViewById(R.id.button_1_2);
//
//        toyotaImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                brand = "Toyota";
//
////                sup1.setVisibility(View.VISIBLE);
////                sup1_1.setVisibility(View.GONE);
////                okButton.setVisibility(View.GONE);
////

////                button1.setText("Corolla");
////                button1.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View view) {
////                        model = "Corolla";
////                        sup1_1.setVisibility(View.VISIBLE);
////                        button1_1.setText("2005");
////                        button1_1.setOnClickListener(new View.OnClickListener() {
////                            @Override
////                            public void onClick(View view) {
////                                year = 2005;
////                                okButton.setVisibility(View.VISIBLE);
////                                /**
////                                 * Type here what will happen if the user select
////                                 * Toyota-->Toyota 1 -->Toyota 1_1
////                                 */
//                            }
//                        });
//
//
////                        button1_2.setText("2007");
////                        button1_2.setOnClickListener(new View.OnClickListener() {
////                            @Override
////                            public void onClick(View view) {
////                                year = 2007 ;
////                                okButton.setVisibility(View.VISIBLE);
////                                /**
////                                 * Type here what will happen if the user select
////                                 * Toyota-->Toyota 1 -->Toyota 1_2
////                                 */
////                            }
////                        });
//
//                    }
//                });
//
//                button2.setText("Avalon");
//                button2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        model = "Avalon" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2010");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2010 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Toyota-->Toyota 2 -->Toyota 2_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2012");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2012 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Toyota-->Toyota 2 -->Toyota 2_2
//                                 */
//                            }
//                        });
//
//                    }
//                });
//
//                button3.setText("Camry");
//                button3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        model = "Camry" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2015");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2015 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Toyota-->Toyota 3 -->Toyota 3_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2013");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2013 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Toyota-->Toyota 3 -->Toyota 3_2
//                                 */
//                            }
//                        });
//                    }
//                });
//
//            }
//        });
//
//
//
//        kinImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                brand = "Kia" ;
//                sup1.setVisibility(View.VISIBLE);
//                sup1_1.setVisibility(View.GONE);
//                okButton.setVisibility(View.GONE);
//
//                button1.setText("Cadenza");
//                button1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        model = "Cadenza" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2012");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2012 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Kin-->Kin 1 -->Kin 1_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2011");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2011 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Kin-->Kin 1 -->Kin 1_2
//                                 */
//                            }
//                        });
//
//                    }
//                });
//
//                button2.setText("Forte");
//                button2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        brand = "Forte" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2006");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2006 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Kin-->Kin 2 -->Kin 2_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2007");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2007 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Kin-->Kin 2 -->Kin 2_2
//                                 */
//                            }
//                        });
//
//                    }
//                });
//
//                button3.setText("Optima");
//                button3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        model = "Optima" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2017");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2017 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Kin-->Kin 3 -->Kin 3_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2018");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2018 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Kin-->Kin 3 -->Kin 3_2
//                                 */
//                            }
//                        });
//                    }
//                });
//
//            }
//        });
//
//
//
//        hyundaiImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                brand = "Hyundai" ;
//                sup1.setVisibility(View.VISIBLE);
//                sup1_1.setVisibility(View.GONE);
//                okButton.setVisibility(View.GONE);
//
//                button1.setText("Elantra");
//                button1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        model = "Elantra" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2018");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2018 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Hyundai-->Hyundai 1 -->Hyundai 1_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2016");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2016 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Hyundai-->Hyundai 1 -->Hyundai 1_2
//                                 */
//                            }
//                        });
//
//
//                    }
//                });
//
//                button2.setText("Veloster");
//                button2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        model = "Veloster" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2019");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2019 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Hyundai-->Hyundai 2 -->Hyundai 2_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2017");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2017 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Hyundai-->Hyundai 2 -->Hyundai 2_2
//                                 */
//                            }
//                        });
//
//                    }
//                });
//
//                button3.setText("Tucson");
//                button3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        model = "Tucson" ;
//                        sup1_1.setVisibility(View.VISIBLE);
//
//                        button1_1.setText("2017");
//                        button1_1.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2017 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Hyundai-->Hyundai 3 -->Hyundai 3_1
//                                 */
//                            }
//                        });
//
//                        button1_2.setText("2016");
//                        button1_2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                year = 2016 ;
//                                okButton.setVisibility(View.VISIBLE);
//                                /**
//                                 * Type here what will happen if the user select
//                                 * Hyundai-->Hyundai 3 -->Hyundai 3_2
//                                 */
//                            }
//                        });
//
//
//                    }
//                });
//
//            }
//        });

//
//        subRG1_1 = findViewById(R.id.sub_radio_group_1_1);
//        subRG1_2 = findViewById(R.id.sub_radio_group_1_2);
//        subRG1_3 = findViewById(R.id.sub_radio_group_1_3);
//        subRG2_1 = findViewById(R.id.sub_radio_group_2_1);
//        subRG2_2 = findViewById(R.id.sub_radio_group_2_2);
//        subRG2_3 = findViewById(R.id.sub_radio_group_2_3);
//        subRG3_1 = findViewById(R.id.sub_radio_group_3_1);
//        subRG3_2 = findViewById(R.id.sub_radio_group_3_2);
//        subRG3_3 = findViewById(R.id.sub_radio_group_3_3);

//        mainSpinner = findViewById(R.id.main_spinner);
//        ArrayAdapter<CharSequence> mainAdapter = ArrayAdapter.createFromResource(this, R.array.toyotaMainStringArray, android.R.layout.simple_spinner_item);
//        mainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mainSpinner.setAdapter(mainAdapter);
//        mainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                switch (i) {
//                    case 0:
//                        supSpinner1.setVisibility(View.VISIBLE);
//                        supSpinner2.setVisibility(View.GONE);
//                        supSpinner3.setVisibility(View.GONE);
//                        break;
//                    case 1:
//                        supSpinner1.setVisibility(View.GONE);
//                        supSpinner2.setVisibility(View.VISIBLE);
//                        supSpinner3.setVisibility(View.GONE);
//                        break;
//                    case 2:
//                        supSpinner1.setVisibility(View.GONE);
//                        supSpinner2.setVisibility(View.GONE);
//                        supSpinner3.setVisibility(View.VISIBLE);
//                        break;
//                    default:
//                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//
//        supSpinner1 = findViewById(R.id.sub_spinner1);
//        ArrayAdapter<CharSequence> subAdapter1 = ArrayAdapter.createFromResource(this, R.array.toyotaSubStringArray1, android.R.layout.simple_spinner_item);
//        subAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        supSpinner1.setAdapter(subAdapter1);
//        supSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                switch (i) {
//                    case 0:
////                        subRG1_1.setVisibility(View.VISIBLE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 1:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.VISIBLE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 2:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.VISIBLE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    default:
//                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        supSpinner2 = findViewById(R.id.sub_spinner2);
//        ArrayAdapter<CharSequence> subAdapter2 = ArrayAdapter.createFromResource(this, R.array.toyotaSubStringArray2, android.R.layout.simple_spinner_item);
//        subAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        supSpinner2.setAdapter(subAdapter2);
//        supSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                switch (i) {
//                    case 0:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.VISIBLE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 1:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.VISIBLE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 2:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.VISIBLE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    default:
//                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        supSpinner3 = findViewById(R.id.sub_spinner3);
//        ArrayAdapter<CharSequence> subAdapter3 = ArrayAdapter.createFromResource(this, R.array.subStringArray3, android.R.layout.simple_spinner_item);
//        subAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        supSpinner3.setAdapter(subAdapter3);
//        supSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                switch (i) {
//                    case 0:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.VISIBLE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 1:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.VISIBLE);
////                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 2:
////                        subRG1_1.setVisibility(View.GONE);
////                        subRG1_2.setVisibility(View.GONE);
////                        subRG1_3.setVisibility(View.GONE);
////                        subRG2_1.setVisibility(View.GONE);
////                        subRG2_2.setVisibility(View.GONE);
////                        subRG2_3.setVisibility(View.GONE);
////                        subRG3_1.setVisibility(View.GONE);
////                        subRG3_2.setVisibility(View.GONE);
////                        subRG3_3.setVisibility(View.VISIBLE);
//                        break;
//                    default:
//                        Toast.makeText(Choose.this, "ERROR", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

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
