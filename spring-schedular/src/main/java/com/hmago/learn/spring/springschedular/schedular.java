package com.hmago.learn.spring.springschedular;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class schedular {

    /*
     * fixedRate makes Spring run the task on periodic intervals even if the last invocation may be still running.
     *  fixedDelay specifically controls the next execution time when the last execution finishes.
     *   cron is a feature originating from Unix cron utility and has various options based on your requirements.
     */
    @Async
    @Scheduled(fixedRate = 1000)
    public void cron1() throws InterruptedException {
        Thread.sleep(1000);
        log.info("=== cron1");
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void cron2() throws InterruptedException {
        Thread.sleep(1000);
        log.info("=== cron2");
    }
}
