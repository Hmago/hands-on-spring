package com.hmago.learn.spring.springasynctvshow.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "downstream")
public class ApplicationProperties {

    private Tvmaze tvmaze = new Tvmaze();

    @Data
    @ToString
    public class Tvmaze{
        int readTimeout;
        int requestTimeout;
        int connectionTimeout;

        String showUrl;
        String showCastUrl;
        String showEpisodesUrl;

    }
}
