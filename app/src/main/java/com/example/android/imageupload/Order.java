package com.example.android.imageupload;

public class Order {
    private String OrderNo ;
    private String OrderNamePt ;
    private float OrderPrice ;
    private String OrderLocation ;
    private String OrderPhone ;
    private String OrderEmail ;
    private String OrderPartNo ;
    private String OrderNameUser ;
    private String OrderStatus ;
    private int OrderQuantity ;
    private float OrderDeliveryFee ;

    public Order(String OrderNo , String orderNamePt, float orderPrice, String orderLocation, String orderPhone, String orderEmail, String orderPartNo, String orderNameUser, int orderQuantity, float orderDeliveryFee) {
        this.OrderNo = OrderNo;
        OrderNamePt = orderNamePt;
        OrderPrice = orderPrice;
        OrderLocation = orderLocation;
        OrderPhone = orderPhone;
        OrderEmail = orderEmail;
        OrderPartNo = orderPartNo;
        OrderNameUser = orderNameUser;
        OrderQuantity = orderQuantity;
        OrderDeliveryFee = orderDeliveryFee;
    }

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public String getOrderNamePt() {
        return OrderNamePt;
    }

    public void setOrderNamePt(String orderNamePt) {
        OrderNamePt = orderNamePt;
    }

    public float getOrderPrice() {
        return OrderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        OrderPrice = orderPrice;
    }

    public String getOrderLocation() {
        return OrderLocation;
    }

    public void setOrderLocation(String orderLocation) {
        OrderLocation = orderLocation;
    }

    public String getOrderPhone() {
        return OrderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        OrderPhone = orderPhone;
    }

    public String getOrderEmail() {
        return OrderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        OrderEmail = orderEmail;
    }

    public String getOrderPartNo() {
        return OrderPartNo;
    }

    public void setOrderPartNo(String orderPartNo) {
        OrderPartNo = orderPartNo;
    }

    public String getOrderNameUser() {
        return OrderNameUser;
    }

    public void setOrderNameUser(String orderNameUser) {
        OrderNameUser = orderNameUser;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getOrderQuantity() {
        return OrderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        OrderQuantity = orderQuantity;
    }

    public float getOrderDeliveryFee() {
        return OrderDeliveryFee;
    }

    public void setOrderDeliveryFee(float orderDeliveryFee) {
        OrderDeliveryFee = orderDeliveryFee;
    }
}
