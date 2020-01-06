package com.cheng.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableBinding({ Source.class }) // 1
public class ProducerAppliction {
	public static void main(String[] args) {
		SpringApplication.run(ProducerAppliction.class, args);
	}
}
