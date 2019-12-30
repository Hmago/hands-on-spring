package com.hmago.learn.spring.springintegration.si.step3_tranformer;

import lombok.NoArgsConstructor;
import org.springframework.integration.transformer.AbstractPayloadTransformer;

@NoArgsConstructor
public class StudentToPersonTransformer extends AbstractPayloadTransformer<Student, Person> {

    @Override
    protected Person transformPayload(Student payload) {
        return Person.builder().id(payload.getId()).name(payload.getName()).build();
    }
}
