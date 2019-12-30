package com.hmago.learn.spring.springintegration.si.step2_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;

@Configuration
public class Step2Config {

    @Bean(name = "inputChannel")
    public PublishSubscribeChannel inputChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean(name = "intermediateChannel")
    public DirectChannel intermediateChannel() {
        return new DirectChannel();
    }

    @Bean(name = "outputChannel")
    public DirectChannel outputChannel() {
        return new DirectChannel();
    }
}
