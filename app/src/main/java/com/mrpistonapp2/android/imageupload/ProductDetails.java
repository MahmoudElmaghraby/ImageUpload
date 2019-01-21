package com.mrpistonapp2.android.imageupload;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.squareup.picasso.Picasso;

public class ProductDetails extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView productNameTV, productPriceTV, productTypeTV, productCountry;
    private ImageView productImage;
    protected Button productButton;
    private Dialog dialog ;
    private String orderPartName;
    private TextView confirmationName , confirmationType , confirmationQuantity , confirmationOrderPrice ;
    private Button confirmationConfirmButton , confirmationCancelButton ;

    private AdView mAdView;
    private Spinner quantitySpinner ;
    public static int quantity = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        quantitySpinner = findViewById(R.id.quantity_spinner);
        ArrayAdapter<CharSequence> quantityAdapter = ArrayAdapter.createFromResource(ProductDetails.this , R.array.quantity , android.R.layout.simple_spinner_item);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(quantityAdapter);
        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                quantity = Integer.parseInt(adapterView.getItemAtPosition(i).toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        MobileAds.initialize(this, "ca-app-pub-3430687372646829~3752500494");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        // to not popup the keyboard when the app begin
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        productNameTV = findViewById(R.id.product_name_text_view);
        productPriceTV = findViewById(R.id.product_price_text_view);
        productTypeTV = findViewById(R.id.product_type_text_view);
        productCountry = findViewById(R.id.product_country_text_view);

        productNameTV.setText(MainActivity.productName);
        productPriceTV.setText("" + MainActivity.productPrice);
        productTypeTV.setText(MainActivity.productYear);
        productCountry.setText(MainActivity.productCountry);

        productImage = findViewById(R.id.product_image_view);
        Picasso.with(this)
                .load(MainActivity.productImage)
                .fit()
                .into(productImage);

        productButton = findViewById(R.id.product_button);
        productButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MainActivity.loggedIn == 0) {

                    Toast.makeText(ProductDetails.this, "Please logged in first !", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ProductDetails.this, MainActivity.class);
                    startActivity(intent);
                } else if (MainActivity.loggedIn == 1) {

                    /*String id = MainActivity.mrPistonDBRef.push().getKey();
                    Order myOrder = new Order(id,
                            MainActivity.productName,
                            (float) MainActivity.productPrice,
                            MainActivity.loggedLocation,
                            MainActivity.loggedPhone,
                            MainActivity.loggedEmail,
                            MainActivity.productPtNo,
                            MainActivity.loggedName,
                            (int) numPicker.getValue(),
                            (int) 500);
                    MainActivity.mrPistonDBRef.child("Carts").child(id).setValue(myOrder);
                    Toast.makeText(ProductDetails.this, "Added to cart ... ", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(ProductDetails.this , MyCartRV.class);
                    startActivity(intent);
                    */




                    dialog = new Dialog(ProductDetails.this, R.style.NewDialog);
                    dialog.setContentView(R.layout.confirmation);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    confirmationName = dialog.findViewById(R.id.confirmation_name);
                    confirmationQuantity = dialog.findViewById(R.id.confirmation_quantity);
                    confirmationType = dialog.findViewById(R.id.confirmation_type);
                    confirmationOrderPrice = dialog.findViewById(R.id.confirmation_order_price);
                    confirmationConfirmButton = dialog.findViewById(R.id.confirmation_confirm_button);
                    confirmationCancelButton = dialog.findViewById(R.id.confirmation_cancel_button);

                    confirmationName.setText("Product Name : " + MainActivity.productName);
                    confirmationType.setText("Product Type : " + MainActivity.productType);
                    confirmationQuantity.setText("Products quantity : " + quantity);
                    float orderPrice = quantity * MainActivity.productPrice ;
                    confirmationOrderPrice.setText("The price is : " +  orderPrice + " L.E");

                    confirmationConfirmButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String id = MainActivity.mrPistonDBRef.push().getKey();
                            Order myOrder = new Order(
                                    MainActivity.productNameEn,
                                    MainActivity.productName,
                                    (float) MainActivity.productPrice,
                                    MainActivity.loggedLocation,
                                    MainActivity.loggedPhone,
                                    MainActivity.loggedEmail,
                                    MainActivity.productPtNo,
                                    MainActivity.loggedName,
                                    (int) quantity,
                                    (int) 500 ,
                                    MainActivity.productImage);
                            orderPartName = myOrder.getOrderNamePt();
                            MainActivity.mrPistonDBRef.child("Carts").child(MainActivity.loggedName).child(orderPartName).setValue(myOrder);
                            Toast.makeText(ProductDetails.this, "Added to cart successfully ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ProductDetails.this, LeftButton.class);
                            startActivity(intent);
                            finish();
                        }
                    });

                    confirmationCancelButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                }

            }
        });


//        ArrayAdapter<CharSequence> firstAdapter = ArrayAdapter.createFromResource(Choose.this , R.array.modelArray , android.R.layout.simple_spinner_item);
//        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        modelSpinner.setAdapter(firstAdapter);





    }
}
