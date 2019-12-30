package com.hmago.learn.spring.springintegration.si.step2_gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Step2MessageService {

    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void getMessage(Message<String> message) {
        log.info("===Activator 1=== header={}", message.getHeaders());
        log.info("===Activator 1===body={}", message.getPayload());
        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();

        Message<String> replyMessage = MessageBuilder.withPayload("reply from activator").build();
        replyChannel.send(replyMessage);
    }

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "intermediateChannel")
    public Message<String> activator2(Message<String> message) {
        log.info("===Activator 2===header={}", message.getHeaders());
        log.info("===Activator 2===body={}", message.getPayload());

        return MessageBuilder.withPayload("reply from activator2 through intermediate channel").build();
    }

    @ServiceActivator(inputChannel = "intermediateChannel", outputChannel = "outputChannel")
    public Message<String> activator3(Message<String> message) {
        log.info("===Activator 3===header={}", message.getHeaders());
        log.info("===Activator 3===body={}", message.getPayload());

        return MessageBuilder.withPayload("reply from activator3 through output channel").build();
    }

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "outputChannel")
    public Message<String> activator4(Message<String> message) {
        log.info("===Activator 4===header={}", message.getHeaders());
        log.info("===Activator 4==body={}", message.getPayload());

        return MessageBuilder.withPayload("reply from activator4 through output channel").build();
    }


}
