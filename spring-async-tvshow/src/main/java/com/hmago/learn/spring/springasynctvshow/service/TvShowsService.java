package com.hmago.learn.spring.springasynctvshow.service;

import com.hmago.learn.spring.springasynctvshow.client.TvShowRestClient;
import com.hmago.learn.spring.springasynctvshow.exception.BaseRestException;
import com.hmago.learn.spring.springasynctvshow.exception.ErrorCodes;
import com.hmago.learn.spring.springasynctvshow.pojo.Cast;
import com.hmago.learn.spring.springasynctvshow.pojo.Episode;
import com.hmago.learn.spring.springasynctvshow.pojo.Show;
import com.hmago.learn.spring.springasynctvshow.pojo.ShowResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class TvShowsService {

    private TvShowAsyncService asyncTvShowService;

    @Autowired
    public TvShowsService(TvShowAsyncService asyncTvShowService) {
        this.asyncTvShowService = asyncTvShowService;
    }

    public ShowResponse showResponse(Long id){
        log.info("===main starts===");
        CompletableFuture<Show> show= asyncTvShowService.getShowDetails(id);
        CompletableFuture<List<Cast>> casts = asyncTvShowService.getShowsCastById(id);
        CompletableFuture<List<Episode>> episodes = asyncTvShowService.getShowsEpisodesById(id);

        CompletableFuture.allOf(show, casts, episodes);

        ShowResponse showResponse = null;
        try {
            showResponse = ShowResponse.baseResponse().success(true).code("200").show(show.get()).casts(casts.get()).episodes(episodes.get()).build();
        } catch (Exception e) {
            log.info("===1===");
            e.printStackTrace();
            throw new BaseRestException(ErrorCodes.DOWNSTREAM_DOWN.getCode(), ErrorCodes.DOWNSTREAM_DOWN.name());
        }
        log.info("==main ends==");
        return showResponse;
    }
}
