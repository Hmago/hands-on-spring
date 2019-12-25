package com.hmago.learn.spring.springasynctvshow.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="webRequestLog")
public class WebRequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String requestUrl;

    private String requestHeader;

    private String requestBody;

    private String responseBody;

    private String responseStatus;

    private long timeTakenInMs;

    private LocalDateTime created_on=LocalDateTime.now();
}
