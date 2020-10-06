package com.example.wfeer;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class ListItem implements Parcelable {

    //the objective of this class is to get the data and return the data
    private String campName;
    private String phoneNumber;
    private String email;
    private String foodDescription;
    private String imageUri;


    public ListItem(String campName, String phoneNumber, String email, String foodDescription,String imageUri) {
        this.campName = campName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.foodDescription = foodDescription;
        this.imageUri = imageUri;

    }

    protected ListItem(Parcel in) {
        campName = in.readString();
        phoneNumber = in.readString();
        email = in.readString();
        foodDescription = in.readString();
        imageUri = in.readString();
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(campName);
        dest.writeString(phoneNumber);
        dest.writeString(email);
        dest.writeString(foodDescription);
        dest.writeString(imageUri);
    }

    public String getCampName() {
        return campName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public String getImageUri() {
        return imageUri;
    }
}
