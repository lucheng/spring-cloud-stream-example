package com.cheng.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomRunner implements CommandLineRunner {

	@Autowired
	private Source source;

	@Override
	public void run(String... args) throws Exception {
		while(true) {
			Thread.sleep(5000);
			int count = 5;
			for (int index = 1; index <= count; index++) {
				source.output().send(MessageBuilder.withPayload("msg-" + index).build()); // 3
			}
		}
		
	}
}