package com.mrpistonapp2.android.imageupload;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyCartRV extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;

    private String id;
    private Order cartOrderUpload;
    private Button parchusAllButton;

    private DatabaseReference cartDatabaseRef;
    private ValueEventListener cartDBListener;

    private String string5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart_rv);

        parchusAllButton = findViewById(R.id.purchase_all_button);

        cartRecyclerView = findViewById(R.id.my_cart_recycler_view);
        cartRecyclerView.setHasFixedSize(true);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainActivity.cartList = new ArrayList<>();

        cartAdapter = new CartAdapter(MainActivity.cartList, MyCartRV.this);
        cartRecyclerView.setAdapter(cartAdapter);

//        cartDatabaseRef = FirebaseDatabase.getInstance().getReference("Carts");

//        cartDBListener = cartDatabaseRef.addValueEventListener(new ValueEventListener() {
        cartDBListener = MainActivity.mrPistonDBRef.child("Carts").child(MainActivity.loggedName).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                MainActivity.cartList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {


                    Order Myorder = new Order();
                    Myorder = postSnapshot.getValue(Order.class);

                    Myorder.setOrderKey(postSnapshot.getKey());

                    if (MainActivity.loggedName.equals(Myorder.getOrderNameUser())) {

                        MainActivity.cartList.add(Myorder);

                    }

                }

                cartAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(MyCartRV.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        parchusAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sizeOfList = MainActivity.cartList.size();
                id = MainActivity.mrPistonDBRef.push().getKey();
                for (int i = 0 ; i < sizeOfList ; i++) {

                    cartOrderUpload = MainActivity.cartList.get(i);

                    MainActivity.mrPistonDBRef.child("Orders").child(id).child(MainActivity.productNameEn).setValue(cartOrderUpload);

//                    MainActivity.mrPistonDBRef.child("Orders").child(id).child(cartOrderUpload.getOrderNamePt()).setValue(cartOrderUpload);
                    MainActivity.mrPistonDBRef.child("Carts").child(MainActivity.loggedName).child(cartOrderUpload.getOrderNamePt()).removeValue();
                }
                MainActivity.cartList.clear();
                Toast.makeText(MyCartRV.this, "Successfully Purchased your items !!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyCartRV.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        /*cartDBListener = cartDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                cartList.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Order cart = postSnapshot.getValue(Order.class);
                    cart.setOrderKey(postSnapshot.getKey());

                    string5 = cart.getOrderNameUser() ;

                    if (string5.equals(MainActivity.loggedName)){

                        cartList.add(cart);

                    }

                }

                cartAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MyCartRV.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

*/


//        orderPrice = ProductDetails.numPicker.getValue() * MainActivity.productPrice ;
/*
        for (int i = 0 ; i < cartList.size() ; i++){

            Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();

            Carts myCart = new Carts(MainActivity.productName ,MainActivity.productType ,ProductDetails.numPicker.getValue() , Float.parseFloat(orderPrice + " L.E" ));

            cartList.add(myCart);

*//*
            cartViewHolder.cartProductName.setText("Product Name : " + MainActivity.productName);
            cartViewHolder.cartProductType.setText("Product Type : " + MainActivity.productType);
            cartViewHolder.cartProductQuantity.setText("Products quantity : " + ProductDetails.numPicker.getValue());
            float orderPrice = ProductDetails.numPicker.getValue() * MainActivity.productPrice ;
            cartViewHolder.cartProductPrice.setText("The price is : " +  orderPrice + " L.E");
*//*



        }*/

    }

/*

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cartDatabaseRef.removeEventListener(cartDBListener);
    }
*/


}
