package com.hmago.learn.spring.springintegration.si.step4_router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Step4IntegerServiceActivator {

    @ServiceActivator(inputChannel = "step4IntegerChannel")
    public void integerServiceActivator(Message<Integer> message){
        log.info("==== Integer servicer activator ={}", message);
    }
}
