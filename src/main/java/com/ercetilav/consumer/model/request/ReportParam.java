package com.ercetilav.consumer.model.request;

import java.io.Serializable;

public class ReportParam implements Serializable {
    private String fromDate;
    private String toDate;
    private Integer merchant;
    private Integer acquirer;
    
    public String getFromDate() {
        return fromDate;
    }
    
    public void setFromDate(String aFromDate) {
        fromDate = aFromDate;
    }
    
    public String getToDate() {
        return toDate;
    }
    
    public void setToDate(String aToDate) {
        toDate = aToDate;
    }
    
    public Integer getMerchant() {
        return merchant;
    }
    
    public void setMerchant(Integer aMerchant) {
        merchant = aMerchant;
    }
    
    public Integer getAcquirer() {
        return acquirer;
    }
    
    public void setAcquirer(Integer aAcquirer) {
        acquirer = aAcquirer;
    }
    
    @Override
    public String toString() {
        return "ReportParam{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", merchant=" + merchant +
                ", acquirer=" + acquirer +
                '}';
    }
}
