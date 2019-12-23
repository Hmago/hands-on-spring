package com.hmago.learn.spring.exceptionhandling.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    INVALID_REQUEST("APP_1000"),
    INVALID_USER("APP_10001");

    private String code;
}
