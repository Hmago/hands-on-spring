package com.hmago.learn.spring.springintegration.si.step3_tranformer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.integration.transformer.ObjectToStringTransformer;

@Configuration
public class Step3ChannelConfig {

    @Bean(name="step3InputChannel")
    public PublishSubscribeChannel inputChannel(){
        return new PublishSubscribeChannel();
    }

    @Bean(name="step3OutputChannel")
    public PublishSubscribeChannel objectToJsonChannel(){
        return new PublishSubscribeChannel();
    }


    @Bean
    @Transformer(inputChannel = "step3InputChannel", outputChannel = "step3OutputChannel")
    public ObjectToJsonTransformer objectToJsonTransformer() {
        return new ObjectToJsonTransformer(getMapper());
    }

    @Bean
    public Jackson2JsonObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return new Jackson2JsonObjectMapper(mapper);
    }

    @Bean
    @Transformer(inputChannel = "step3InputChannel", outputChannel = "step3OutputChannel")
    public ObjectToStringTransformer objectToStringTransformer(){
        return new ObjectToStringTransformer();
    }

    @Bean
    @Transformer(inputChannel = "step3InputChannel", outputChannel = "step3OutputChannel")
    public StudentToPersonTransformer studentToPersonTransformer(){
        return new StudentToPersonTransformer();
    }

}

