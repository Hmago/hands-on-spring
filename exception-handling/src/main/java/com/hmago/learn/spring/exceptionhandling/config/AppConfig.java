package com.hmago.learn.spring.exceptionhandling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename("i18n/messages");

        // Cache For An Hour
        rs.setCacheSeconds(3600);
        rs.setUseCodeAsDefaultMessage(true);
        return rs;
    }
}
