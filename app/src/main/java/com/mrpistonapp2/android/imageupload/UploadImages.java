package com.mrpistonapp2.android.imageupload;

import com.google.firebase.database.Exclude;

public class UploadImages {

    private String name ;
    private String desc ;
    private String imageUrl ;
    private String mKey;

    public UploadImages() {
    }

    public UploadImages(String name, String desc , String imageUrl) {

        if (name.trim().equals("")){
            name = "No Name " ;
        }
        if (desc.trim().equals("")){
            desc = "No Description ";
        }

        this.name = name;
        this.desc = desc ;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
