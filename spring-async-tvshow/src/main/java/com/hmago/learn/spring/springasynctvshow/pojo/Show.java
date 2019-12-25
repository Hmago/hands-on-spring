package com.hmago.learn.spring.springasynctvshow.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Show implements Serializable {
    private Long id;
    private String name;
    private String url;
    private String type;
    private String language;
    private List<String> genres;
    private String status;
    private String summary;
    private long runtime;
    private String officialSite;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate premiered;

    private Image image;
    private External externals;
    private Rating rating;
    private Schedule schedule;
}
