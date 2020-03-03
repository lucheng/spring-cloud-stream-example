package com.cheng.stream;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public final static String CRM_EXCHANGE = "universe.distribution.test";

    @Bean
    public TopicExchange exchange(){
        TopicExchange exchange = new TopicExchange(CRM_EXCHANGE);
        return exchange;
    }

}
