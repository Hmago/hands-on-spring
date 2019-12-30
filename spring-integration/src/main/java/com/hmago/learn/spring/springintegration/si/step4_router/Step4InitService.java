package com.hmago.learn.spring.springintegration.si.step4_router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

//@Service
public class Step4InitService implements CommandLineRunner {

    @Autowired
    private Step4MessageGateway gateway;

    @Override
    public void run(String... args) throws Exception {
        Message<String> stringMessage = MessageBuilder.withPayload("This is a string message").build();
        Message<Integer> integerMessage = MessageBuilder.withPayload(9).build();

        gateway.sendMessage(stringMessage);
        gateway.sendMessage(integerMessage);
        gateway.sendMessage(integerMessage);
    }
}
