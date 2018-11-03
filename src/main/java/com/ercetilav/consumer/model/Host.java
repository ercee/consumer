package com.ercetilav.consumer.model;

import java.io.Serializable;

public class Host implements Serializable {
    private static final long serialVersionUID = -6247290557434110829L;
    private String mScheme;
    private String mDomain;
    
    public String getScheme() {
        return mScheme;
    }
    
    public void setScheme(String aScheme) {
        mScheme = aScheme;
    }
    
    public String getDomain() {
        return mDomain;
    }
    
    public void setDomain(String aDomain) {
        mDomain = aDomain;
    }
}
