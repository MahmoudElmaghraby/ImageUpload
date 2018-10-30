package com.example.android.imageupload;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ProductDetails extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView productNameTV, productPriceTV, productTypeTV, productCountry;
    private NumberPicker numPicker;
    private ImageView productImage;
    protected Button productButton;
    private Dialog dialog ;

    private TextView confirmationName , confirmationType , confirmationQuantity , confirmationOrderPrice ;
    private Button confirmationConfirmButton , confirmationCancelButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        productNameTV = findViewById(R.id.product_name_text_view);
        productPriceTV = findViewById(R.id.product_price_text_view);
        productTypeTV = findViewById(R.id.product_type_text_view);
        productCountry = findViewById(R.id.product_country_text_view);

        productNameTV.setText(MainActivity.productName);
        productPriceTV.setText("" + MainActivity.productPrice);
        productTypeTV.setText(MainActivity.productType);
        productCountry.setText(MainActivity.productCountry);

        numPicker = findViewById(R.id.num_picker);
        numPicker.setMinValue(0);
        numPicker.setMaxValue(5);
        numPicker.setWrapSelectorWheel(false);

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
                    confirmationQuantity.setText("Products quantity : " + numPicker.getValue());
                    float orderPrice = numPicker.getValue() * MainActivity.productPrice ;
                    confirmationOrderPrice.setText("The price is : " +  orderPrice + " L.E");

                    confirmationConfirmButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String id = MainActivity.mrPistonDBRef.push().getKey();
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
                            MainActivity.mrPistonDBRef.child("Orders").child(id).setValue(myOrder);
                            Toast.makeText(ProductDetails.this, "Purchase Successful ", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ProductDetails.this, MainActivity.class);
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


    }
}
