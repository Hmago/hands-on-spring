package com.hmago.learn.spring.exceptionhandling.exception;

public class AppRestException extends AppRuntimeException {
    public AppRestException() {
        super();
    }

    public AppRestException(String message) {
        super(message);
    }

    public AppRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppRestException(Throwable cause) {
        super(cause);
    }

    protected AppRestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public AppRestException(String message, Object... args){
        super(message);
        super.args=args;
    }
}
