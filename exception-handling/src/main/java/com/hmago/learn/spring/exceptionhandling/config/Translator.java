package com.hmago.learn.spring.exceptionhandling.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Slf4j
public class Translator {
    ResourceBundleMessageSource messageSource;

    @Autowired
    public Translator(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;

    }

    public String getMessage(String msgCode, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        log.info("Locale is {}", locale);
        return messageSource.getMessage(msgCode, args, locale);
    }
}
