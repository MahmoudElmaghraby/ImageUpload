package com.mrpistonapp2.android.imageupload;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    public static List<Order> cartList ;
    private Context cartContext ;


    public class CartViewHolder extends RecyclerView.ViewHolder {

        TextView cartProductName ;
        TextView cartProductQuantity ;
        TextView cartProductPrice ;
        ImageView cartImageView ;
        Button cartDeleteButton ;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            cartProductName = itemView.findViewById(R.id.cart_product_name);
            cartProductQuantity = itemView.findViewById(R.id.cart_product_quantity);
            cartProductPrice = itemView.findViewById(R.id.cart_product_price);
            cartImageView = itemView.findViewById(R.id.cart_item_image_view);
            cartDeleteButton = itemView.findViewById(R.id.cart_delete_btn);



        }
    }

    public CartAdapter(List<Order> cartList, Context cartContext) {
        this.cartList = cartList;
        this.cartContext = cartContext;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(cartContext).inflate(R.layout.cart_single_item , viewGroup , false);
        CartViewHolder cartViewHolder = new CartViewHolder(view);
        return cartViewHolder ;

    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder cartViewHolder, int i) {

        Order currentOrder = cartList.get(i);

        cartViewHolder.cartProductName.setText(currentOrder.getOrderNamePt());
        cartViewHolder.cartProductQuantity.setText("" + currentOrder.getOrderQuantity());
        cartViewHolder.cartProductPrice.setText("" + currentOrder.getOrderPrice());

        cartViewHolder.cartDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mrPistonDBRef.child("Carts").child(MainActivity.loggedName).child(cartViewHolder.cartProductName.getText().toString()).removeValue();
            }
        });

        Picasso.with(cartContext)
                .load(currentOrder.getCartImageUrl())
                .placeholder(R.mipmap.app_icon)
                .fit()
                .into(cartViewHolder.cartImageView);

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}

