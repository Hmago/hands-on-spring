package com.hmago.learn.spring.jsonparse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmago.learn.spring.jsonparse.client.CustomerClient;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ObjectMapper mapper;

    public void getCustomerDetails() throws JsonProcessingException {
        log.info("==Client Call starts==");
        String customerData_json = customerClient.searchCustomer();
        log.info("==Client Call ends.. Data={}==", customerData_json);

        JsonNode customerNode = mapper.readTree(customerData_json);
        log.info("==Customer profile data using path method=={}", customerNode.path("profile"));

        Map<String, String> responseStructure = new HashMap<>();
        responseStructure.put("st", "$.st");
        responseStructure.put("customerId", "$.profile.customerId");
        responseStructure.put("primaryIdNumber", "$.profile.primaryIdNumber");
        responseStructure.put("subcriptions", "$.profile.subcriptions[?(@.productType == 'AIRTELMONEYWALLET')]");
        responseStructure.put("geoHierarchy", "$.profile.address.geoHierarchy[?(@.level>2)]");
        responseStructure.put("bioMetricAuthenticated", "$.profile.idDetails[0].bioMetricAuthenticated");
        responseStructure.put("idTypes", "$.profile.idDetails[*].idType");

        Map<String, Object> responseData = new HashMap<>();
        DocumentContext context = JsonPath.parse(customerData_json);
        responseStructure.forEach((key, path)->{
            responseData.put(key, context.read(path));
        });

        log.info("==final response={}", responseData);
    }

}
