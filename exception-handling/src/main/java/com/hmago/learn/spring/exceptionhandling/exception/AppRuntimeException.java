package com.hmago.learn.spring.exceptionhandling.exception;

public abstract class AppRuntimeException extends RuntimeException {
    Object[] args;

    public AppRuntimeException() {
        super();
    }

    public AppRuntimeException(String message) {
        super(message);
    }

    public AppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppRuntimeException(Throwable cause) {
        super(cause);
    }

    protected AppRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
