package com.hmago.learn.spring.auditing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            if(SecurityContextHolder.getContext().getAuthentication()==null || StringUtils.isEmpty(SecurityContextHolder.getContext().getAuthentication().getName())){
                return Optional.of("SYSTEM");
            }

            return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
        };
    }

}