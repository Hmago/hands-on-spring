package com.hmago.learn.spring.exceptionhandling.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
public class LoginResponse extends BaseResponse{

    private String customerId;

    @Builder(builderMethodName = "loginResponse")
    LoginResponse(Boolean success, String code, String msg, String devErrorMessage, Set<String> validationErrors, String customerId) {
        super(success, code, msg, devErrorMessage, validationErrors);
        this.customerId = customerId;
    }
}
