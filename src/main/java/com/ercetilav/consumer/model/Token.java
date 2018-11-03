package com.ercetilav.consumer.model;

import java.io.Serializable;

public class Token implements Serializable {
    
    private static final long serialVersionUID = 1493710656995964548L;
    private String mToken;
    private String mStatus;
    
    public String getToken() {
        return mToken;
    }
    
    public void setToken(String aToken) {
        mToken = aToken;
    }
    
    public String getStatus() {
        return mStatus;
    }
    
    public void setStatus(String aStatus) {
        mStatus = aStatus;
    }
    
    @Override
    public String toString() {
        return "Token{" +
                "mToken='" + mToken + '\'' +
                ", mStatus='" + mStatus + '\'' +
                '}';
    }
}
