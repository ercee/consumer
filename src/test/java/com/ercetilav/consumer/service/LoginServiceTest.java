package com.ercetilav.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.ercetilav.consumer.ConsumerApplication;
import com.ercetilav.consumer.config.RequestContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = {ConsumerApplication.class})
@ExtendWith({SpringExtension.class})
@TestPropertySource(locations = {"classpath:application.properties"})
public class LoginServiceTest {
    
    @Autowired
    LoginService mLoginService;
    
    @Test
    public void login() {
        mLoginService.login();
        assertNotNull(RequestContext.getContext().getToken(), "Token not set to context!");
    }
}