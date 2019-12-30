package com.hmago.learn.spring.springintegration.si.step1_channel_subscribe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;

@Configuration
public class ChannelBeans {

    @Bean(name = "messageChannel")
    public DirectChannel messageChannel() {
        return new DirectChannel();
    }
}
