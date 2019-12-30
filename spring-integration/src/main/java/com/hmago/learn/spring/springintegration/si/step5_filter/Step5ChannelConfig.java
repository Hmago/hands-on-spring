package com.hmago.learn.spring.springintegration.si.step5_filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.filter.MessageFilter;
import org.springframework.messaging.Message;

@Configuration
public class Step5ChannelConfig {

    @Bean(name="step5InputChannel")
    public DirectChannel  step5InputChannel(){
        return new DirectChannel();
    }

    @Bean(name="step5FilterChannel")
    public DirectChannel step5FilterChannel(){
        return new DirectChannel();
    }

    @Bean(name="step5OutputChannel")
    public DirectChannel outputChannel(){
        return new DirectChannel();
    }

    @Bean
    @Filter(inputChannel = "step5InputChannel")
    public MessageFilter filterEven(){
        MessageFilter filter = new MessageFilter(new MessageSelector() {
            @Override
            public boolean accept(Message<?> message) {
                Integer number = (Integer) message.getPayload();

                if(number%2==0){
                    return true;
                }

                return false;
            }
        });

        filter.setOutputChannelName("step5FilterChannel");
        return filter;
    }
}
