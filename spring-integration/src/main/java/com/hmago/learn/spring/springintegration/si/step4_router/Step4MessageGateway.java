package com.hmago.learn.spring.springintegration.si.step4_router;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface Step4MessageGateway {

    @Gateway(requestChannel = "step4InputChannel")
    void sendMessage(Message<?> message);
}
