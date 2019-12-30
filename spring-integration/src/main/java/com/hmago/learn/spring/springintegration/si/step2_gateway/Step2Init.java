package com.hmago.learn.spring.springintegration.si.step2_gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
//@Component
public class Step2Init implements CommandLineRunner {

    @Autowired
    private MessageGateway gateway;

    @Autowired
    @Qualifier("inputChannel")
    private PublishSubscribeChannel inputChannel;

    @Autowired
    @Qualifier("outputChannel")
    private DirectChannel outputChannel;

    @Override
    public void run(String... args) throws Exception {
        log.info("reply=={}", gateway.sendMessage("input message"));

        outputChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                log.info("==subscribe of output channel={}", message);
            }
        });

        inputChannel.send(MessageBuilder.withPayload("from input channel").build());
    }
}
