package com.ercetilav.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import com.ercetilav.consumer.model.request.*;

@Configuration
@ConfigurationProperties(prefix = "consumer")
@PropertySource("classpath:application.properties")
public class ConsumerConfig {
    
    private Credentials credentials;
    private Host host;
    private ReportParam reportParam;
    
    public Credentials getCredentials() {
        return credentials;
    }
    
    public void setCredentials(Credentials aCredentials) {
        credentials = aCredentials;
    }
    
    public Host getHost() {
        return host;
    }
    
    public void setHost(Host aHost) {
        host = aHost;
    }
    
    public ReportParam getReportParam() {
        return reportParam;
    }
    
    public void setReportParam(ReportParam aReportParam) {
        reportParam = aReportParam;
    }
}

