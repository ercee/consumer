package com.ercetilav.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.*;
import com.ercetilav.consumer.config.*;
import com.ercetilav.consumer.model.*;
import org.slf4j.*;

@Component
public class LoginService {
    public static final String LOGIN_PATH = "api/v3/merchant/user/login";
    private final ConsumerConfig mConsumerConfig;
    private final RestTemplate mRestTemplate;
    Logger logger = LoggerFactory.getLogger(JwtTokenHeaderInterceptor.class);
    
    @Autowired
    public LoginService(ConsumerConfig aConsumerConfig, RestTemplate aRestTemplate) {
        mConsumerConfig = aConsumerConfig;
        mRestTemplate = aRestTemplate;
    }
    
    public void login() {
        Credentials credentaials = new Credentials();
        credentaials.setEmail(getConsumerConfig().getCredentials().getEmail());
        credentaials.setPassword(getConsumerConfig().getCredentials().getPassword());
        UriComponents uri = UriComponentsBuilder.newInstance().scheme(getConsumerConfig().getHost().getScheme()).host(getConsumerConfig().getHost().getDomain()).pathSegment(LOGIN_PATH).build();
        logger.info("Login request!");
        ResponseEntity<Token> exchange = getRestTemplate().exchange(uri.toUri(), HttpMethod.POST, new HttpEntity<Credentials>(credentaials), Token.class);
        if (HttpStatus.ACCEPTED.equals(exchange.getStatusCode())) {
            RequestContext.getContext().setToken(exchange.getBody().getToken());
            logger.info("Token set to context!");
        } else {
            logger.warn("Login failed!");
        }
    }
    
    public RestTemplate getRestTemplate() {
        return mRestTemplate;
    }
    
    public ConsumerConfig getConsumerConfig() {
        return mConsumerConfig;
    }
}
