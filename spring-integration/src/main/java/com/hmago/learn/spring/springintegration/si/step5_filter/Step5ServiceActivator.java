package com.hmago.learn.spring.springintegration.si.step5_filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Step5ServiceActivator {

    @ServiceActivator(inputChannel = "step5FilterChannel")
    public void printService(Message<?> message) {
        log.info("==message=={}", message);
    }
}
