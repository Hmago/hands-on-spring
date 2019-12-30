package com.hmago.learn.spring.springintegration.si.step3_tranformer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Step3ServiceActivator {

    @ServiceActivator(inputChannel = "step3OutputChannel")
    public void activator1(Message<?> message) {
        log.info("===activator 1===={}", message);

    }

    @ServiceActivator(inputChannel = "step3OutputChannel")
    public void activator2(Message<?> message) {
        log.info("===activator 2===={}", message);
    }

    @ServiceActivator(inputChannel = "step3OutputChannel")
    public void activator3(Message<?> message) {
        log.info("===activator 3===={}", message);

        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        replyChannel.send(MessageBuilder.withPayload(message.getPayload() + " ==== reply 3====").build());
    }
}
