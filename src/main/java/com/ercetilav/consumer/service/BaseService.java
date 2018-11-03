package com.ercetilav.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.*;
import com.ercetilav.consumer.config.*;
import org.slf4j.*;

public abstract class BaseService {
    public static final String API_V_3 = "api/v3";
    private final ConsumerConfig mConsumerConfig;
    private final RestTemplate mRestTemplate;
    Logger logger = LoggerFactory.getLogger(JwtTokenHeaderInterceptor.class);
    
    @Autowired
    public BaseService(ConsumerConfig aConsumerConfig, RestTemplate aRestTemplate) {
        mConsumerConfig = aConsumerConfig;
        mRestTemplate = aRestTemplate;
    }
    
    public RestTemplate getRestTemplate() {
        return mRestTemplate;
    }
    
    public ConsumerConfig getConsumerConfig() {
        return mConsumerConfig;
    }
    
    protected UriComponents getUri(String aLoginPath) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance().scheme(getConsumerConfig().getHost().getScheme()).host(getConsumerConfig().getHost().getDomain());
        return uriComponentsBuilder.pathSegment(API_V_3, aLoginPath).build();
    }
}
