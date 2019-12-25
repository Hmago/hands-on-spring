package com.hmago.learn.spring.springasynctvshow.config;

import com.hmago.learn.spring.springasynctvshow.exception.BaseRestException;
import com.hmago.learn.spring.springasynctvshow.pojo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
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
public class ApplicationExceptionAdvice {

    //TODO: add translator for error message description

    @ExceptionHandler(BaseRestException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BaseResponse baseRestException(BaseRestException ex){
        return BaseResponse.builder().success(false).code(ex.getMessage()).msg(ex.getMessage()).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse exception(Exception e){
        return BaseResponse.builder().success(false).code("500").msg(e.getMessage()).build();
    }
}
