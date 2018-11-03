package com.ercetilav.consumer.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ercetilav.consumer.config.*;
import com.ercetilav.consumer.model.request.Credentials;
import com.ercetilav.consumer.model.response.Token;
import org.slf4j.*;

@Service
public class LoginService extends BaseService {
    public static final String LOGIN_PATH = "merchant/user/login";
    Logger logger = LoggerFactory.getLogger(LoginService.class);
    
    public LoginService(ConsumerConfig aConsumerConfig, RestTemplate aRestTemplate) {
        super(aConsumerConfig, aRestTemplate);
    }
    
    
    public void login() {
        Credentials credentaials = new Credentials();
        credentaials.setEmail(getConsumerConfig().getCredentials().getEmail());
        credentaials.setPassword(getConsumerConfig().getCredentials().getPassword());
        logger.info("Login request!");
        ResponseEntity<Token> exchange = getRestTemplate().exchange(getUri(LOGIN_PATH).toUri(), HttpMethod.POST, new HttpEntity<Credentials>(credentaials), Token.class);
        if (HttpStatus.OK.equals(exchange.getStatusCode())) {
            RequestContext.getContext().setToken(exchange.getBody().getToken());
            logger.info("Login succeeded!");
            logger.info("Token set to context!");
        } else {
            logger.warn("Login failed!");
        }
    }
    
    
}
