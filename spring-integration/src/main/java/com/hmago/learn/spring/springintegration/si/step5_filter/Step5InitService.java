package com.hmago.learn.spring.springintegration.si.step5_filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Step5InitService implements CommandLineRunner {

    @Autowired
    private Step5MessageGateway gateway;

    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1,10).forEach(k->{
            gateway.sendMessage(MessageBuilder.withPayload(k).build());
        });

    }
}
