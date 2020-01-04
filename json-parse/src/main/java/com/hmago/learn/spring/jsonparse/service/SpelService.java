package com.hmago.learn.spring.jsonparse.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
public class SpelService {

    String PLACE_HOLDER = "value";

    public LocalDate castToLocalDate() {
        String expression = "T(java.time.LocalDate).parse(#value, T(java.time.format.DateTimeFormatter).ofPattern('dd-MM-yyyy'))";

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable(PLACE_HOLDER, "01-01-2020");

        Expression exp = parser.parseExpression(expression);
        log.info("===1==={}", exp.getValue(context));
        LocalDate message = exp.getValue(context, LocalDate.class);

        return message;
    }

    public void cast() {
        ExpressionParser parser = new SpelExpressionParser();
        LocalDate temp = (LocalDate) parser.parseExpression("01-01-2020").getValue();
        log.info("=======temp={}", temp);
    }
}
