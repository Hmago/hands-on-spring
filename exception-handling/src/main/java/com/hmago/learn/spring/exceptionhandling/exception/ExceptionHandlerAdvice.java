package com.hmago.learn.spring.exceptionhandling.exception;

import com.hmago.learn.spring.exceptionhandling.pojo.BaseResponse;
import com.hmago.learn.spring.exceptionhandling.config.Translator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerAdvice {
    private final String PREFIX = ".ERROR";

    @Autowired
    private Translator translator;

    @ExceptionHandler({AppRestException.class, DatabaseException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponse appRestException(AppRuntimeException e){
        return BaseResponse.builder().code(e.getMessage()).msg(this.translator.getMessage(e.getMessage()+PREFIX, e.args)).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse internalServerError(Exception e){
        return BaseResponse.builder().code("500").msg(e.getMessage()).build();
    }
}

