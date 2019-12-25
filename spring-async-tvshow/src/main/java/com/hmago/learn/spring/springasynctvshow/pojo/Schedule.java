package com.hmago.learn.spring.springasynctvshow.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Schedule {
    private String time;
    private List<String> days;
}
