package com.hmago.learn.spring.jsonparse;

import com.hmago.learn.spring.jsonparse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonParseApplication implements CommandLineRunner {
	@Autowired
	private CustomerService service;

	public static void main(String[] args) {
		SpringApplication.run(JsonParseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.getCustomerDetails();
	}
}
