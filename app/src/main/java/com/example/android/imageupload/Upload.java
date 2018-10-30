package com.example.android.imageupload;

public class Upload {
    private String name;
    private String mModel;
    private String mSubModel;
    private String mProvider;
    private int mYear;
    private String mPartNo;
    private String mCat;
    private float mBPrice;
    private float mSPrice;
    private float mProfit;

    private String mType = "my Type" ;

    private String imageUrl;
    private String mKey;

    private String mCountry ;
    private String nameAR ;

    public Upload() {
        //empty constructor needed
    }

    public Upload(String name, String mModel, String mSubModel, String mProvider, int mYear, String mPartNo, String mCat, float mBPrice, float mSPrice, float mProfit, String imageUrl , String mCountry , String nameAR) {
        this.name = name;
        this.mModel = mModel;
        this.mSubModel = mSubModel;
        this.mProvider = mProvider;
        this.mYear = mYear;
        this.mPartNo = mPartNo;
        this.mCat = mCat;
        this.mBPrice = mBPrice;
        this.mSPrice = mSPrice;
        this.mProfit = mProfit;
        this.imageUrl = imageUrl;
        this.mCountry = mCountry;
        this.nameAR = nameAR;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmModel() {
        return mModel;
    }

    public void setmModel(String mModel) {
        this.mModel = mModel;
    }

    public String getmSubModel() {
        return mSubModel;
    }

    public void setmSubModel(String mSubModel) {
        this.mSubModel = mSubModel;
    }

    public String getmProvider() {
        return mProvider;
    }

    public void setmProvider(String mProvider) {
        this.mProvider = mProvider;
    }

    public int getmYear() {
        return mYear;
    }

    public void setmYear(int mYear) {
        this.mYear = mYear;
    }

    public String getmPartNo() {
        return mPartNo;
    }

    public void setmPartNo(String mPartNo) {
        this.mPartNo = mPartNo;
    }

    public String getmCat() {
        return mCat;
    }

    public void setmCat(String mCat) {
        this.mCat = mCat;
    }

    public float getmBPrice() {
        return mBPrice;
    }

    public void setmBPrice(float mBPrice) {
        this.mBPrice = mBPrice;
    }

    public float getmSPrice() {
        return mSPrice;
    }

    public void setmSPrice(float mSPrice) {
        this.mSPrice = mSPrice;
    }

    public float getmProfit() {
        return mProfit;
    }

    public void setmProfit(float mProfit) {
        this.mProfit = mProfit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }


    public String getmCountry() {
        return mCountry;
    }

    public String getNameAR() {
        return nameAR;
    }

    //    public Upload(String name, String imageUrl) {
//        if (name.trim().equals("")) {
//            name = "No Name";
//        }
//
//        name = name;
//        imageUrl = imageUrl;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        name = name;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        imageUrl = imageUrl;
//    }
//
//    @Exclude
//    public String getKey() {
//        return mKey;
//    }
//
//    @Exclude
//    public void setKey(String key) {
//        mKey = key;
//    }
}