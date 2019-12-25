package com.hmago.learn.spring.springasynctvshow.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {
    private Long id;
    private String name;
    private int season;
    private int number;
    private LocalDate airdate;
    private String airtime;
    private int runtime;
    private Image image;
    private String summary;

}
