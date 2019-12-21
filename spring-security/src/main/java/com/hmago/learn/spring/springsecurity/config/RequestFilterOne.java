package com.hmago.learn.spring.springsecurity.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class RequestFilterOne extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("== Filter 1 ==");
        /* filter logic */
        if(request.getContentType() != null){
            SecurityContextHolder.clearContext();
        }

        chain.doFilter(request, response);
    }
}
