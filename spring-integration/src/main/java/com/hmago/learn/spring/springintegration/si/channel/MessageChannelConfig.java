package com.hmago.learn.spring.springintegration.si.channel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MessageChannelConfig {

    @Bean(name="inputChannel")
    public MessageChannel inputChannel(){
        return new DirectChannel();
    }
}
