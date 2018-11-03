package com.ercetilav.consumer.model.response;

import java.io.Serializable;

public class ReportResponse implements Serializable {
    private Integer count;
    private Integer total;
    private String currency;
    
    public Integer getCount() {
        return count;
    }
    
    public void setCount(Integer aCount) {
        count = aCount;
    }
    
    public Integer getTotal() {
        return total;
    }
    
    public void setTotal(Integer aTotal) {
        total = aTotal;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public void setCurrency(String aCurrency) {
        currency = aCurrency;
    }
    
    @Override
    public String toString() {
        return "ReportResponse{" +
                "count=" + count +
                ", total=" + total +
                ", currency='" + currency + '\'' +
                '}';
    }
}
