package com.hmago.learn.spring.springasynctvshow.client;

import com.hmago.learn.spring.springasynctvshow.service.WebRequestLogService;
import com.sun.deploy.net.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class RestTemplateRequestInterceptor implements ClientHttpRequestInterceptor {

    private WebRequestLogService logService;

    @Autowired
    public RestTemplateRequestInterceptor(WebRequestLogService logService) {
        this.logService = logService;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        Long startTime = System.currentTimeMillis();

        ClientHttpResponse response= execution.execute(request, body);
        Long endTime = System.currentTimeMillis();
        logService.logWebRequest(request, body, response, endTime-startTime);

        return response;
    }
}
