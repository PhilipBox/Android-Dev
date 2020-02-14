package com.ssafy.faceshipclient.DTO;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Store implements Serializable {

    int sID;
    int uID;
    int image;
    String sName;
    String sPhone;
    String sDesc;
    int coupon;

    public Store() {}

    public Store(int sID, int uID, String sName, String sPhone, String sDesc, int image, int coupon) {
        this.sID = sID;
        this.uID = uID;
        this.sName = sName;
        this.sPhone = sPhone;
        this.sDesc = sDesc;
        this.image = image;
        this.coupon =coupon;
    }

    public Store(int sID, int uID, String sName, String sPhone, String sDesc) {
        this.sID = sID;
        this.uID = uID;
        this.sName = sName;
        this.sPhone = sPhone;
        this.sDesc = sDesc;
    }


    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public int getImage(){ return image; }

    public void setImage(int image){ this.image = image; }

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsDesc() {
        return sDesc;
    }

    public void setsDesc(String sDesc) {
        this.sDesc = sDesc;
    }

    @Override
    public String toString() {
        return "Store{" +
                "sID=" + sID +
                ", uID=" + uID +
                ", image=" + image +
                ", sName='" + sName + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", sDesc='" + sDesc + '\'' +
                ", coupon=" + coupon +
                '}';
    }
}
