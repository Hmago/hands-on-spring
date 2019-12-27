package com.hmago.learn.spring.jsonparse.service;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.hmago.learn.spring.jsonparse.client.CustomerClient;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

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
        responseStructure.put("/st", "$.st");
        responseStructure.put("/profile/customerId", "$.profile.customerId");
        responseStructure.put("/profile/primaryIdNumber", "$.profile.primaryIdNumber");
        responseStructure.put("/profile/subcriptions", "$.profile.subcriptions[?(@.productType == 'AIRTELMONEYWALLET')]");
        responseStructure.put("/profile/address/geoHierarchy", "$.profile.address.geoHierarchy[?(@.level>2)]");
        responseStructure.put("/profile/idDetails/bioMetricAuthenticated", "$.profile.idDetails[0].bioMetricAuthenticated");
        responseStructure.put("/profile/idDetails/idDetails", "$.profile.idDetails[*].idType");

        Map<String, Object> responseData = new HashMap<>();

        ObjectNode recreationRequest = mapper.createObjectNode();

        DocumentContext context = JsonPath.parse(customerData_json);
        responseStructure.forEach((key, path)->{
            responseData.put(key, context.read(path));
            setJsonPointerValue(recreationRequest, JsonPointer.compile(key), new TextNode(context.read(path).toString()));
        });

        log.info("===response Data =={}", responseData);
        log.info("==recreationnresponse==={}", recreationRequest);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(recreationRequest));

    }

    private void setJsonPointerValue(ObjectNode node, JsonPointer pointer, JsonNode value) {
        JsonPointer parentPointer = pointer.head();
        JsonNode parentNode = node.at(parentPointer);
        String fieldName = pointer.last().toString().substring(1);

        if (parentNode.isMissingNode() || parentNode.isNull()) {
            parentNode = StringUtils.isNumeric(fieldName) ? mapper.createArrayNode() : mapper.createObjectNode();
            setJsonPointerValue(node, parentPointer, parentNode); // recursively reconstruct hierarchy
        }

        if (parentNode.isArray()) {
            ArrayNode arrayNode = (ArrayNode) parentNode;
            int index = Integer.valueOf(fieldName);
            // expand array in case index is greater than array size (like JavaScript does)
            for (int i = arrayNode.size(); i <= index; i++) {
                arrayNode.addNull();
            }
            arrayNode.set(index, value);
        } else if (parentNode.isObject()) {
            ((ObjectNode) parentNode).set(fieldName, value);
        } else {
            throw new IllegalArgumentException("`" + fieldName + "` can't be set for parent node `"
                    + parentPointer + "` because parent is not a container but " + parentNode.getNodeType().name());
        }
    }
}
