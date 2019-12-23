package com.hmago.learn.spring.jsonparse.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerClient {

    @Autowired
    private RestTemplate restTemplate;

    public String searchCustomer() {
        String uri = "http://localhost:8080/cust-profile/customer/search";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Api-Client", "G8HMqxq7d6");
        requestHeaders.put("Content-Type", "application/json");

        Map<String, Object> inputData = new HashMap<>();
        inputData.put("msisdn", "08034618972");
        HttpEntity<Map> request = new HttpEntity<>(inputData, this.getHeaders(requestHeaders));

        return getAPIResponse(restTemplate, uri, request, new String());
    }

    public static <I, R> R getAPIResponse(RestTemplate restTemplate, String uri, HttpEntity<I> request, R r) {
        return (R) restTemplate.postForEntity(uri, request, r.getClass()).getBody();
    }

    public static HttpHeaders getHeaders(Map<String, String> headersMap) {
        HttpHeaders headers = new HttpHeaders();
        for (Map.Entry<String, String> entry : headersMap.entrySet())
            headers.add(entry.getKey(), entry.getValue());
        return headers;
    }
}
