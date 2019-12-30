package com.hmago.learn.spring.springintegration.si.step5_filter;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface Step5MessageGateway {

    @Gateway(requestChannel = "step5InputChannel")
    public void sendMessage(Message<?> message);

}
