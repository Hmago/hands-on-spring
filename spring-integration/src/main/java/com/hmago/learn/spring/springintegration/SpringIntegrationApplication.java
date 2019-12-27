package com.hmago.learn.spring.springintegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableIntegration
public class SpringIntegrationApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("inputChannel")
	private MessageChannel inputChannel;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inputChannel.send(MessageBuilder.withPayload("Message from main file").build());
	}
}
