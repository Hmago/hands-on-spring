package com.hmago.learn.spring.springasynctvshow.client;

import com.hmago.learn.spring.springasynctvshow.config.ApplicationProperties;
import com.hmago.learn.spring.springasynctvshow.pojo.Cast;
import com.hmago.learn.spring.springasynctvshow.pojo.Episode;
import com.hmago.learn.spring.springasynctvshow.pojo.Show;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TvShowRestClient {

    @Qualifier("tvShowRestTemplate")
    private RestTemplate restTemplate;

    private ApplicationProperties properties;

    @Autowired
    public TvShowRestClient(RestTemplate restTemplate, ApplicationProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @HystrixCommand(fallbackMethod = "getShowdetails_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public Show getShowById(Long id) {
        String uri = properties.getTvmaze().getShowUrl().replaceAll("_id_", Long.toString(id));
        return restTemplate.getForObject(uri, Show.class);
    }

    public Show getShowdetails_fallback(Long id){
        return new Show();
    }

    @HystrixCommand(fallbackMethod = "getShowsCastById_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public List<Cast> getShowsCastById(Long id) {
        String uri = properties.getTvmaze().getShowCastUrl().replaceAll("_id_", Long.toString(id));
        return restTemplate.getForObject(uri, List.class);
    }

    public List<Cast> getShowsCastById_fallback(Long id){
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "getShowsEpisodesById_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public List<Episode> getShowsEpisodesById(Long id) {
        String uri = properties.getTvmaze().getShowEpisodesUrl().replaceAll("_id_", Long.toString(id));
        return restTemplate.getForObject(uri, List.class);
    }

    public List<Episode> getShowsEpisodesById_fallback(Long id){
        return new ArrayList<>();
    }
}
