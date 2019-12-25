package com.hmago.learn.spring.springasynctvshow.config;

import com.hmago.learn.spring.springasynctvshow.client.RestTemplateRequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class RestTemplateConfig {

    private ApplicationProperties properties;

    private RestTemplateRequestInterceptor interceptor;

    @Autowired
    public RestTemplateConfig(ApplicationProperties properties, RestTemplateRequestInterceptor interceptor) {
        this.properties = properties;
        this.interceptor = interceptor;
    }

    @Bean(name="tvShowRestTemplate")
    public RestTemplate tvShowsRestTemplate() {
        log.info("==properties=={}", properties.getTvmaze());
        /* Setting request Factory */
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(properties.getTvmaze().connectionTimeout);
        factory.setReadTimeout(properties.getTvmaze().readTimeout);

        RestTemplate restTemplate = new RestTemplate(factory);

        /* Adding Custom Interceptor */
        List<ClientHttpRequestInterceptor> interceptors;
        if (restTemplate.getInterceptors().isEmpty()) {
            interceptors = new ArrayList<>();
        } else {
            interceptors = restTemplate.getInterceptors();
        }

        interceptors.add(interceptor);
        restTemplate.setInterceptors(interceptors);

        return restTemplate;
    }
}
