package com.hmago.learn.spring.springintegration.si.step4_router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Step4StringServiceActivator {

    @ServiceActivator(inputChannel = "step4StringChannel")
    public void stringActivator(Message<String> message) {
        log.info("===String activator==={}", message);
    }
}
