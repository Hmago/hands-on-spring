package com.hmago.learn.spring.springintegration.si.step3_tranformer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Slf4j
//@Service
public class Step3InitService implements CommandLineRunner {

    @Autowired
    private Step3MessageGateway gateway;

    @Override
    public void run(String... args) throws Exception {
        Student student = Student.builder().id(1).name("stu1").course("cour1").build();
        log.info("===reply=={}", gateway.sendStudentMessage(student));
    }
}

