package com.mrpistonapp2.android.imageupload;

public class Users {
    private String userName ;
    private String passWord ;
    private String userEmail ;
    private String userPhone ;
    private String location ;
    private String imageUrl ;

    public Users() {
    }

    public Users(String userName, String passWord, String userEmail, String userPhone, String location) {
        this.userName = userName;
        this.passWord = passWord;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.location = location;
    }

    public Users(String userName, String passWord, String userEmail, String userPhone, String location, String imageUrl) {
        this.userName = userName;
        this.passWord = passWord;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
