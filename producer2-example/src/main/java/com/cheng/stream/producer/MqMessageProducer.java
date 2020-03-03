package com.cheng.stream.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cheng.stream.RabbitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MqMessageProducer implements CommandLineRunner {

	private String routingKey = "bbbb";
	
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
	@Override
	public void run(String... args) throws Exception {
		int count = 500;
		for (int index = 1; index <= count; index++) {
			Thread.sleep(500);
			log.info("msg-" + index);
			rabbitTemplate.convertAndSend(RabbitConfig.CRM_EXCHANGE, routingKey, "msg-" + index);
		}
	}
}