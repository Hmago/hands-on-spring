package com.hmago.learn.spring.springintegration.si.step2_gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateway {

    @Gateway(requestChannel = "integration.gateway.channel")
    public String sendMessage(String message);

}
