package com.cheng.stream.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@EnableBinding(MqMessageSource.class)
@Slf4j
public class MqMessageProducer implements CommandLineRunner {
	@Autowired
	@Output(MqMessageSource.MESSAGE_OUTPUT)
	private MessageChannel channel;

	@Override
	public void run(String... args) throws Exception {
//			Thread.sleep(5000);
		int count = 50;
		for (int index = 1; index <= count; index++) {
			Thread.sleep(500);
			log.info("msg-" + index);
			channel.send(MessageBuilder.withPayload("msg-" + index).build()); // 3
		}
	}
}