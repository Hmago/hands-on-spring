package com.hmago.learn.spring.springasynctvshow.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {
    protected boolean success;
    protected String code;
    protected String msg;
    protected String details;

    @Builder(builderMethodName = "builder")
    public BaseResponse(boolean success, String code, String msg, String details) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.details =details;
    }
}
