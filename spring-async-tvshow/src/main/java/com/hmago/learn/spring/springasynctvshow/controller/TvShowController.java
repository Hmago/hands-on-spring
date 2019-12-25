package com.hmago.learn.spring.springasynctvshow.controller;

import com.hmago.learn.spring.springasynctvshow.pojo.Cast;
import com.hmago.learn.spring.springasynctvshow.pojo.Episode;
import com.hmago.learn.spring.springasynctvshow.pojo.Show;
import com.hmago.learn.spring.springasynctvshow.pojo.ShowResponse;
import com.hmago.learn.spring.springasynctvshow.service.TvShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/show")
public class TvShowController {

    private TvShowsService service;

    @Autowired
    public TvShowController(TvShowsService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ShowResponse getShowDetails(@PathVariable Long id){
        return service.showResponse(id);
    }
}
