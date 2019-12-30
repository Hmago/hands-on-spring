package com.hmago.learn.spring.springintegration.si.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrintService {

    public Message<String> printAndCreate(Message<String> message) {
        log.info("==Header={}", message.getHeaders());
        log.info("==Payload={}", message.getPayload());

        return MessageBuilder.withPayload("message from print service").setHeader("auth", "value2").build();
    }

    public void print(Message<String> message) {
        log.info("==Headers=={}", message.getHeaders());
        log.info("==Body=={}", message.getPayload());
    }
}
