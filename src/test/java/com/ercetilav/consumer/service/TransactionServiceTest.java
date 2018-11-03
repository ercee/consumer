package com.ercetilav.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.ercetilav.consumer.ConsumerApplication;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@SpringBootTest(classes = {ConsumerApplication.class})
@ExtendWith({SpringExtension.class})
@TestPropertySource(locations = {"classpath:application.properties"})
class TransactionServiceTest {
    @Autowired
    LoginService mLoginService;
    
    @Autowired
    TransactionService mTransactionService;
    
    @BeforeEach
    void setup() {
        mLoginService.login();
    }
    
    @Test
    void report() {
        mTransactionService.report();
    }
}