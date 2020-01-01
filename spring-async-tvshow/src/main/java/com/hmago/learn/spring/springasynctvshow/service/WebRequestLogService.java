package com.hmago.learn.spring.springasynctvshow.service;

import com.hmago.learn.spring.springasynctvshow.model.WebRequestLog;
import com.hmago.learn.spring.springasynctvshow.repo.WebRequestLogRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

@Slf4j
@Service
public class WebRequestLogService {

    private WebRequestLogRepo repo;

    @Autowired
    public WebRequestLogService(WebRequestLogRepo repo) {
        this.repo = repo;
    }

    @Async
    public void logWebRequest(HttpRequest request, byte[] body, ClientHttpResponse response, Long timeTakenInMs) {
        log.info("== Logging web request");

        try {
            WebRequestLog requestLog = WebRequestLog.builder()
                    .requestBody(new String(body))
                    .requestHeader(request.getHeaders().toString())
                    .requestUrl(request.getURI().toString())
//                    .responseBody(traceResponse(response))
                    .responseStatus(response.getStatusCode().toString())
                    .created_on(LocalDateTime.now())
                    .timeTakenInMs(timeTakenInMs)
                    .build();
            repo.save(requestLog);
        } catch (IOException e) {
            log.info("Error while logging {}", e.getMessage());
        }

        log.info("==Logging web request done");
    }

    private String traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        log.debug("============================response begin==========================================");
        log.debug("Status code  : {}", response.getStatusCode());
        log.debug("Status text  : {}", response.getStatusText());
        log.debug("Headers      : {}", response.getHeaders());
        log.debug("Response body: {}", inputStringBuilder.toString());
        log.debug("=======================response end=================================================");

        return inputStringBuilder.toString();
    }
}
