package com.hmago.learn.spring.annotations;

import com.hmago.learn.spring.annotations.annotation.RateLimiter;
import com.hmago.learn.spring.annotations.exception.RateLimiterException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Aspect
@Component
public class RateLimiterAspect {

    Map<String, Integer> occurrence = new ConcurrentHashMap<>();

    @Before("@annotation(limiter)")
    public void rateLimit(JoinPoint jp, RateLimiter limiter) {
        String minuteKey = getMinuteKey(jp, limiter);
        String hourKey = getHourKey(jp, limiter);

        int minOccurrence = getOccurrence(minuteKey);
        int hourOccurrence = getOccurrence(hourKey);

        if((limiter.permitsPerMinutes()>0 && minOccurrence>=limiter.permitsPerMinutes()) || (limiter.permitsPerHour()>0 && hourOccurrence>=limiter.permitsPerHour())){
            throw new RateLimiterException("1001", "LIMIT EXCEEDED");
        }

        incrementOccurrence(hourKey);
        incrementOccurrence(minuteKey);
    }

    private void incrementOccurrence(String key){
        int count=0;
        if(occurrence.containsKey(key)){
            count=occurrence.get(key);
        }
        count++;
        occurrence.put(key, count);
    }

    private int getOccurrence(String key) {
        if(occurrence.containsKey(key)){
            return occurrence.get(key);
        }

        return 0;
    }

    private String getHourKey(JoinPoint jp, RateLimiter rateLimiter) {
        String username = "", key;
        boolean is_invalid = true;
        for (int i = 0; i < jp.getArgs().length; i++) {
            if (jp.getArgs()[i] instanceof Principal) {
                is_invalid = false;
                username = ((Principal) jp.getArgs()[i]).getName();
            }
        }

        if (is_invalid) {
            throw new RateLimiterException("1000", "INVALID INTEGRATION OF RateLimiter");
        }
        return username + jp.getSignature().toString()+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH"));
    }

    private String getMinuteKey(JoinPoint jp, RateLimiter rateLimiter) {
        String username = "", key;
        boolean is_invalid = true;
        for (int i = 0; i < jp.getArgs().length; i++) {
            if (jp.getArgs()[i] instanceof Principal) {
                is_invalid = false;
                username = ((Principal) jp.getArgs()[i]).getName();
            }
        }

        if (is_invalid) {
            throw new RateLimiterException("1000", "INVALID INTEGRATION OF RateLimiter");
        }
        return username + jp.getSignature().toString()+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
