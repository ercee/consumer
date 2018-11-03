package com.ercetilav.consumer;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import com.ercetilav.consumer.config.JwtTokenHeaderInterceptor;

@SpringBootApplication
public class ConsumerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
    
    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors.add(new JwtTokenHeaderInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
    
}
