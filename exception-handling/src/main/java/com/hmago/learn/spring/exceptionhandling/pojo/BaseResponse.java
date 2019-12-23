package com.hmago.learn.spring.exceptionhandling.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Builder
public class BaseResponse {

    private boolean success;

    private String code;

    private String msg;

    private String devErrorMessage;

    private Set<String> validationErrors;
}
