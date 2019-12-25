package com.hmago.learn.spring.springasynctvshow.exception;

import com.hmago.learn.spring.springasynctvshow.pojo.BaseResponse;

public class BaseRestException extends RuntimeException {
    Object[] objects;

    public BaseRestException() {
        super();
    }

    public BaseRestException(String message) {
        super(message);
    }

    public BaseRestException(String message, Object... objects){
        super(message);
        this.objects = objects;
    }
}
