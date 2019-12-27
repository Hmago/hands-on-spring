package com.hmago.learn.spring.annotations.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimiter {
    String key() default "";

    int permitsPerMinutes() default 0;

    int permitsPerHour() default 0;
}
