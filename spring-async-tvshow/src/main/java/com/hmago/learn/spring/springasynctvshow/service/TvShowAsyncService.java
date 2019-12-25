package com.hmago.learn.spring.springasynctvshow.service;

import com.hmago.learn.spring.springasynctvshow.client.TvShowRestClient;
import com.hmago.learn.spring.springasynctvshow.pojo.Cast;
import com.hmago.learn.spring.springasynctvshow.pojo.Episode;
import com.hmago.learn.spring.springasynctvshow.pojo.Show;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TvShowAsyncService {
    private TvShowRestClient tvShowRestClient;

    @Autowired
    public TvShowAsyncService(TvShowRestClient tvShowRestClient) {
        this.tvShowRestClient = tvShowRestClient;
    }

    @Async("asyncExecutor")
    public CompletableFuture<Show> getShowDetails(Long id) {
        log.info("==Getting show details");
        Show show = tvShowRestClient.getShowById(id);
        log.info("Show request completed");
        return CompletableFuture.completedFuture(show);
    }

    @Async("asyncExecutor")
    public CompletableFuture<List<Cast>> getShowsCastById(Long id){
        log.info("==Getting cast details");
        List<Cast> casts = tvShowRestClient.getShowsCastById(id);
        log.info("Show Cast completed");
        return CompletableFuture.completedFuture(casts);
    }

    @Async("asyncExecutor")
    public CompletableFuture<List<Episode>> getShowsEpisodesById(Long id){
        log.info("==getting episodes==");
        List<Episode> episodes = tvShowRestClient.getShowsEpisodesById(id);
        log.info("==episode done==");
        return CompletableFuture.completedFuture(episodes);
    }
}
