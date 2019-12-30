package com.hmago.learn.spring.springintegration.si.step3_tranformer;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface Step3MessageGateway {

    @Gateway(requestChannel = "step3InputChannel")
    String sendStudentMessage(Student student);
}
