package com.example.myapplication;

public class Home {
    final private int NO_IMAGE = -1;

    private String homeName;

    public void setType(String type) {
        this.type = type;
    }
    private String type;
    private  int mImageResouce = NO_IMAGE;
    private int homePrice;
    private String homeDescription;
    private String telfon;

    public Home(String homeName, int mImageResouce, int
                homePrice,String type, String homeDescription, String telfon){
        this.homeName = homeName;
        this.mImageResouce = mImageResouce;
        this.type = type;
        this.homePrice = homePrice;
        this.homeDescription = homeDescription;
        this.telfon = telfon;

    }

    public String getHomeName(){
        return homeName;
    }

    public String getType(){
        return type;
    }
    public int getmImageResouce(){
        return mImageResouce;
    }
    public int getHomePrice(){
        return homePrice;
    }
    public String getHomeDescription(){
        return homeDescription;
    }
    public String getTelfon() { return telfon; }
}

//Disini tempat untuk menambahkan identitas baru pada detail activity
