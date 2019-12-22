package com.hmago.learn.spring.configurationproperties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.integration")
public class ApplicationConfig {

    private Microservice1 microservice1 = new Microservice1();
    private Microservice2 microservice2 = new Microservice2();
    private Microservice3 microservice3 = new Microservice3();

    @Data
    public class Microservice1 extends BaseRequestParams{

    }

    @Data
    public class Microservice2 extends BaseRequestParams{

    }

    @Data
    public class Microservice3{
        private String serviceName;
        private String uri;
    }

    @Data
    public class BaseRequestParams{
        private int requestTimeout;
        private int maxConnection;
        private int poolSize;
    }
}
