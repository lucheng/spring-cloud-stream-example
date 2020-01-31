package com.cheng.stream.customer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderMqService {
	
	@Value("${spring.profiles.active}")
	private String profiles;
	
	@RabbitListener(bindings = 
			@QueueBinding(value = @Queue(name = "crm_exchange.crm_group_dev2"), 
			exchange = @Exchange(name = "crm_exchange", type = ExchangeTypes.TOPIC), key = "#"))
	@RabbitHandler
	public void receive(String message) {
		log.info(profiles + "接收33333333参数={}", message);
	}
}
