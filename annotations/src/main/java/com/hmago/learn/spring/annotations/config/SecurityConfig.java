package com.hmago.learn.spring.annotations.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, status from user where username=?")
                .authoritiesByUsernameQuery("select username, role, status from authority where username=?");
//                .passwordEncoder(encode());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated().and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }
}
