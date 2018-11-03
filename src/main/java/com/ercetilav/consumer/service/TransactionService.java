package com.ercetilav.consumer.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ercetilav.consumer.config.ConsumerConfig;
import com.ercetilav.consumer.model.base.ResponseWrapper;
import com.ercetilav.consumer.model.request.ReportParam;
import com.ercetilav.consumer.model.response.ReportResponse;

@Service
public class TransactionService extends BaseService {
    private static final String REPORT_PATH = "transactions/report";
    
    public TransactionService(ConsumerConfig aConsumerConfig, RestTemplate aRestTemplate) {
        super(aConsumerConfig, aRestTemplate);
    }
    
    public ResponseWrapper<ReportResponse> report() {
        ResponseEntity<ResponseWrapper<ReportResponse>> exchange = getRestTemplate().exchange(getUri(REPORT_PATH).toUri(), HttpMethod.POST, new HttpEntity<ReportParam>(getConsumerConfig().getReportParam()), new ParameterizedTypeReference<ResponseWrapper<ReportResponse>>() {});
        return exchange.getBody();
    }
    
}
