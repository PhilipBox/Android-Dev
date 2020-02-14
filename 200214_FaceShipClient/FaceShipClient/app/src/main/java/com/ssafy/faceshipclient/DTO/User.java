package com.ssafy.faceshipclient.DTO;

import java.io.Serializable;

public class User implements Serializable{
    int uID;
    String uName;
    String uPhone;
    String uImage;
    boolean isOwner;

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    public String getuImage() {
        return uImage;
    }

    public void setuImage(String uImage) {
        this.uImage = uImage;
    }

    public boolean getisOwner() {
        return isOwner;
    }

    public void setisOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }
}
