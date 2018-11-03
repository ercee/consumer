package com.ercetilav.consumer.model.base;

import java.io.Serializable;
import java.util.List;

public class ResponseWrapper<T> implements Serializable {
    private String status;
    private List<T> response;
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String aStatus) {
        status = aStatus;
    }
    
    public List<T> getResponse() {
        return response;
    }
    
    public void setResponse(List<T> aResponse) {
        response = aResponse;
    }
}
