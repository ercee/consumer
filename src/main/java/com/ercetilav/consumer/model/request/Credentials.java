package com.ercetilav.consumer.model.request;

import java.io.Serializable;

public class Credentials implements Serializable {
    private static final long serialVersionUID = 4591114316413823870L;
    private String mEmail;
    private String mPassword;
    
    public String getEmail() {
        return mEmail;
    }
    
    public void setEmail(String aEmail) {
        mEmail = aEmail;
    }
    
    public String getPassword() {
        return mPassword;
    }
    
    public void setPassword(String aPassword) {
        mPassword = aPassword;
    }
    
    @Override
    public String toString() {
        return "Credentials{" +
                "mEmail='" + mEmail + '\'' +
                ", mPassword='" + mPassword + '\'' +
                '}';
    }
}
