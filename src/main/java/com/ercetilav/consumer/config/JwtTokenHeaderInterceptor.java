package com.ercetilav.consumer.config;

import java.io.IOException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.stereotype.Component;
import org.slf4j.*;

@Component
public class JwtTokenHeaderInterceptor implements ClientHttpRequestInterceptor {
    Logger logger = LoggerFactory.getLogger(JwtTokenHeaderInterceptor.class);
    
    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        String token = RequestContext.getContext().getToken();
        if (token == null) {
            logger.warn("No token on context!");
        }
        request.getHeaders().add(RequestContext.REQUEST_HEADER_NAME, token);
        return execution.execute(request, body);
    }
}