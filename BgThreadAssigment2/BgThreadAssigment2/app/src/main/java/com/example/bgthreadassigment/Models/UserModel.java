package com.example.bgthreadassigment.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserModel implements Parcelable {
    private String username, fullname;
    private int profileImage;

    public UserModel(String username, String fullname, int profileImage) {
        this.username = username;
        this.fullname = fullname;
        this.profileImage = profileImage;
    }

    protected UserModel(Parcel in) {
        username = in.readString();
        fullname = in.readString();
        profileImage = in.readInt();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(fullname);
        dest.writeInt(profileImage);
    }
}
