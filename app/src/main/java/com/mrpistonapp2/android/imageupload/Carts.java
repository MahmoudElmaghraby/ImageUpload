package com.mrpistonapp2.android.imageupload;

public class Carts {

    private String cartProductName ;
    private String cartProductType ;
    private int cartProductQuantity ;
    private float cartProductPrice ;

    public Carts() {
    }

    public Carts(String cartProductName, String cartProductType, int cartProductQuantity, float cartProductPrice) {
        this.cartProductName = cartProductName;
        this.cartProductType = cartProductType;
        this.cartProductQuantity = cartProductQuantity;
        this.cartProductPrice = cartProductPrice;
    }


    public String getCartProductName() {
        return cartProductName;
    }

    public void setCartProductName(String cartProductName) {
        this.cartProductName = cartProductName;
    }

    public String getCartProductType() {
        return cartProductType;
    }

    public void setCartProductType(String cartProductType) {
        this.cartProductType = cartProductType;
    }

    public int getCartProductQuantity() {
        return cartProductQuantity;
    }

    public void setCartProductQuantity(int cartProductQuantity) {
        this.cartProductQuantity = cartProductQuantity;
    }

    public float getCartProductPrice() {
        return cartProductPrice;
    }

    public void setCartProductPrice(float cartProductPrice) {
        this.cartProductPrice = cartProductPrice;
    }
}
