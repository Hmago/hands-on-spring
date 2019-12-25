package com.hmago.learn.spring.springasynctvshow.exception;

import lombok.Getter;

@Getter
public enum ErrorCodes {
    DOWNSTREAM_DOWN("1000"),
    SOMETHING_WENT_WRONG("1001");

    private String code;

    ErrorCodes(String code){
        this.code = code;
    }
}
