package com.hmago.learn.spring.springschedular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableAsync
@EnableScheduling
public class SpringSchedularApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSchedularApplication.class, args);
    }

}
