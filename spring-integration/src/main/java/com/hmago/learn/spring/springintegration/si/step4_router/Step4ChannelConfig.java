package com.hmago.learn.spring.springintegration.si.step4_router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.integration.router.RecipientListRouter;

@Configuration
public class Step4ChannelConfig {

    @Bean(name = "step4InputChannel")
    public PublishSubscribeChannel step4InputChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean(name = "step4StringChannel")
    public DirectChannel step4StringChannel() {
        return new DirectChannel();
    }

    @Bean(name = "step4IntegerChannel")
    public DirectChannel step4IntegerChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "step4InputChannel")
    public PayloadTypeRouter payloadTypeRouter() {
        PayloadTypeRouter router = new PayloadTypeRouter();
        router.setChannelMapping(String.class.getName(), "step4StringChannel");
        router.setChannelMapping(Integer.class.getName(), "step4IntegerChannel");
        return router;
    }

    @Bean
    @ServiceActivator(inputChannel = "oneToMany")
    public RecipientListRouter broadcastMessage(){
        RecipientListRouter router = new RecipientListRouter();
        router.addRecipient("consumer1Channel");
        router.addRecipient("consumer2Channel");
        return router;
    }
}
