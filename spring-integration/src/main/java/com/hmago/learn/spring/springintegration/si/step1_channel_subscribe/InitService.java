package com.hmago.learn.spring.springintegration.si.step1_channel_subscribe;

import com.hmago.learn.spring.springintegration.si.common.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

//@Service
public class InitService implements CommandLineRunner {

    @Autowired
    @Qualifier("messageChannel")
    private DirectChannel messageChannel;

    @Autowired
    private PrintService simpleMessageService;

    @Override
    public void run(String... args) throws Exception {
        messageChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                simpleMessageService.print((Message<String>) message);
            }
        });

        Message<String> message = MessageBuilder.withPayload("message 1").setHeader("auth", "asdas").build();
//        messageChannel.send(message);
    }
}
