package com.hmago.learn.spring.springintegration.si.channel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@Configuration
public class PrintService {

//    @Bean
//    public Message<String> message(){
//        return MessageBuilder.withPayload("Message from bean").build();
//    }
//    @Bean
//    @ServiceActivator(inputChannel = "inputChannel")
//    public Message<String> printMessage(Message<String> message){
//        log.info("===message in print service={}", message);
//        return MessageBuilder.withPayload("from endpoint").setHeader("key", "value").build();
//
//    }
}
