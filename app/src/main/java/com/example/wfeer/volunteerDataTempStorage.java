package com.example.wfeer;

import android.util.Log;

public class volunteerDataTempStorage {

    private static final String TAG = "voluDataTempStorage";

     public String name, address, email, mobile, age, legalID;

    public volunteerDataTempStorage(String name, String address, String email, String mobile, String age, String legalID) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.legalID = legalID;
    }

    public volunteerDataTempStorage() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLegalID() {
        return legalID;
    }

    public void setLegalID(String legalID) {
        this.legalID = legalID;
    }
}
