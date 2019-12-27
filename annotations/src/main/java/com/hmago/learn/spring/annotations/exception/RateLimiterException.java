package com.hmago.learn.spring.annotations.exception;

public class RateLimiterException extends RuntimeException {
    public RateLimiterException(String code, String message) {
        super(code+": "+message);
    }
}
