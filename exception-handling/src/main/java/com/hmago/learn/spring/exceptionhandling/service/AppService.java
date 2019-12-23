package com.hmago.learn.spring.exceptionhandling.service;

import com.hmago.learn.spring.exceptionhandling.exception.AppRestException;
import com.hmago.learn.spring.exceptionhandling.exception.DatabaseException;
import com.hmago.learn.spring.exceptionhandling.exception.ExceptionCode;
import com.hmago.learn.spring.exceptionhandling.pojo.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    public LoginResponse login() {
        throw new AppRestException(ExceptionCode.INVALID_USER.getCode(), ExceptionCode.INVALID_USER.name());
    }

    public LoginResponse insertDataInDB() {
        throw new DatabaseException(ExceptionCode.INVALID_REQUEST.getCode(), ExceptionCode.INVALID_REQUEST.name());
    }

    public int calculate() {
        return 1 / 0;
    }
}
