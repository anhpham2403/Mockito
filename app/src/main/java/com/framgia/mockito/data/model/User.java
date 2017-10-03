package com.framgia.mockito.data.model;

import java.util.Observable;

/**
 * Created by workspace on 11/09/2017.
 */

public class User extends Observable {
    private int mID;
    private String mUserName;
    private String mPassword;

    public User(int ID, String userName, String password) {
        mID = ID;
        mUserName = userName;
        mPassword = password;
    }

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
