package com.hmago.learn.spring.configurationproperties;

import com.hmago.learn.spring.configurationproperties.config.ApplicationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class ConfigurationPropertiesApplication implements CommandLineRunner {

	@Autowired
	private ApplicationConfig config;

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("== Microservice1 request timeut={} ms", config.getMicroservice1().getRequestTimeout());
		log.info("== Microservice1 request max Connection={}", config.getMicroservice1().getMaxConnection());
		log.info("== Microservice1 request Pool Size={}", config.getMicroservice1().getPoolSize());

		log.info("== Microservice2 request timeut={} ms", config.getMicroservice2().getRequestTimeout());
		log.info("== Microservice2 request max Connection={}", config.getMicroservice2().getMaxConnection());
		log.info("== Microservice2 request Pool Size={}", config.getMicroservice2().getPoolSize());

		log.info("== Microservice3 serviceName={}", config.getMicroservice3().getServiceName());
		log.info("== Microservice3 request uri ={}", config.getMicroservice3().getUri());
	}
}
