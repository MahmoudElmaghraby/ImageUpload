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
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Choose extends AppCompatActivity {

//    private Spinner mainSpinner, supSpinner1, supSpinner2, supSpinner3;
//    private RadioGroup subRG1_1, subRG1_2, subRG1_3, subRG2_1, subRG2_2, subRG2_3, subRG3_1, subRG3_2, subRG3_3;
    private Button okButton , button1 , button2 , button3 , button1_1 , button1_2;
    private ImageView toyotaImage , kinImage , hyundaiImage ;
    private LinearLayout sup1 , sup1_1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toyotaImage = findViewById(R.id.toyota_image);
        kinImage = findViewById(R.id.kin_image);
        hyundaiImage = findViewById(R.id.hyundai_image);

        sup1 = findViewById(R.id.sup1);
        sup1_1 = findViewById(R.id.sub1_1);

        okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Choose.this , FourButtons.class);
                startActivity(intent);
            }
        });

        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button1_1 = findViewById(R.id.button_1_1);
        button1_2 = findViewById(R.id.button_1_2);

        toyotaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sup1.setVisibility(View.VISIBLE);
                sup1_1.setVisibility(View.GONE);

                button1.setText("Toyota 1");
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);
                        button1_1.setText("Toyota 1_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Toyota-->Toyota 1 -->Toyota 1_1
                                 */
                            }
                        });


                        button1_2.setText("Toyota 1_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Toyota-->Toyota 1 -->Toyota 1_2
                                 */
                            }
                        });

                    }
                });

                button2.setText("Toyota 2");
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Toyota 2_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Toyota-->Toyota 2 -->Toyota 2_1
                                 */
                            }
                        });

                        button1_2.setText("Toyota 2_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Toyota-->Toyota 2 -->Toyota 2_2
                                 */
                            }
                        });

                    }
                });

                button3.setText("Toyota 3");
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Toyota 3_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Toyota-->Toyota 3 -->Toyota 3_1
                                 */
                            }
                        });

                        button1_2.setText("Toyota 3_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Toyota-->Toyota 3 -->Toyota 3_2
                                 */
                            }
                        });
                    }
                });

            }
        });



        kinImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sup1.setVisibility(View.VISIBLE);
                sup1_1.setVisibility(View.GONE);

                button1.setText("Kin 1");
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Kin 1_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Kin-->Kin 1 -->Kin 1_1
                                 */
                            }
                        });

                        button1_2.setText("Kin 1_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Kin-->Kin 1 -->Kin 1_2
                                 */
                            }
                        });

                    }
                });

                button2.setText("Kin 2");
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Kin 2_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Kin-->Kin 2 -->Kin 2_1
                                 */
                            }
                        });

                        button1_2.setText("Kin 2_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Kin-->Kin 2 -->Kin 2_2
                                 */
                            }
                        });

                    }
                });

                button3.setText("Kin 3");
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Kin 3_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Kin-->Kin 3 -->Kin 3_1
                                 */
                            }
                        });

                        button1_2.setText("Kin 3_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Kin-->Kin 3 -->Kin 3_2
                                 */
                            }
                        });
                    }
                });

            }
        });



        hyundaiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sup1.setVisibility(View.VISIBLE);
                sup1_1.setVisibility(View.GONE);

                button1.setText("Hyundai 1");
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Hyundai 1_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Hyundai-->Hyundai 1 -->Hyundai 1_1
                                 */
                            }
                        });

                        button1_2.setText("Hyundai 1_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Hyundai-->Hyundai 1 -->Hyundai 1_2
                                 */
                            }
                        });


                    }
                });

                button2.setText("Hyundai 2");
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Hyundai 2_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Hyundai-->Hyundai 2 -->Hyundai 2_1
                                 */
                            }
                        });


                        button1_2.setText("Hyundai 2_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Hyundai-->Hyundai 2 -->Hyundai 2_2
                                 */
                            }
                        });

                    }
                });

                button3.setText("Hyundai 3");
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sup1_1.setVisibility(View.VISIBLE);

                        button1_1.setText("Hyundai 3_1");
                        button1_1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Hyundai-->Hyundai 3 -->Hyundai 3_1
                                 */
                            }
                        });

                        button1_2.setText("Hyundai 3_2");
                        button1_2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                /**
                                 * Type here what will happen if the user select
                                 * Hyundai-->Hyundai 3 -->Hyundai 3_2
                                 */
                            }
                        });


                    }
                });

            }
        });




//        subRG1_1 = findViewById(R.id.sub_radio_group_1_1);
//        subRG1_2 = findViewById(R.id.sub_radio_group_1_2);
//        subRG1_3 = findViewById(R.id.sub_radio_group_1_3);
//        subRG2_1 = findViewById(R.id.sub_radio_group_2_1);
//        subRG2_2 = findViewById(R.id.sub_radio_group_2_2);
//        subRG2_3 = findViewById(R.id.sub_radio_group_2_3);
//        subRG3_1 = findViewById(R.id.sub_radio_group_3_1);
//        subRG3_2 = findViewById(R.id.sub_radio_group_3_2);
//        subRG3_3 = findViewById(R.id.sub_radio_group_3_3);
//
//        mainSpinner = findViewById(R.id.main_spinner);
//        ArrayAdapter<CharSequence> mainAdapter = ArrayAdapter.createFromResource(this, R.array.mainStringArray, android.R.layout.simple_spinner_item);
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
//        ArrayAdapter<CharSequence> subAdapter1 = ArrayAdapter.createFromResource(this, R.array.subStringArray1, android.R.layout.simple_spinner_item);
//        subAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        supSpinner1.setAdapter(subAdapter1);
//        supSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                switch (i) {
//                    case 0:
//                        subRG1_1.setVisibility(View.VISIBLE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 1:
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.VISIBLE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 2:
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.VISIBLE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.GONE);
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
//        ArrayAdapter<CharSequence> subAdapter2 = ArrayAdapter.createFromResource(this, R.array.subStringArray2, android.R.layout.simple_spinner_item);
//        subAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        supSpinner2.setAdapter(subAdapter2);
//        supSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                switch (i) {
//                    case 0:
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.VISIBLE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 1:
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.VISIBLE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 2:
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.VISIBLE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.GONE);
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
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.VISIBLE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 1:
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.VISIBLE);
//                        subRG3_3.setVisibility(View.GONE);
//                        break;
//                    case 2:
//                        subRG1_1.setVisibility(View.GONE);
//                        subRG1_2.setVisibility(View.GONE);
//                        subRG1_3.setVisibility(View.GONE);
//                        subRG2_1.setVisibility(View.GONE);
//                        subRG2_2.setVisibility(View.GONE);
//                        subRG2_3.setVisibility(View.GONE);
//                        subRG3_1.setVisibility(View.GONE);
//                        subRG3_2.setVisibility(View.GONE);
//                        subRG3_3.setVisibility(View.VISIBLE);
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
}
