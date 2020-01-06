package com.cheng.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

import com.cheng.stream.customer.Sink1;

@SpringBootApplication
@EnableBinding({ Sink.class, Sink1.class })
public class CustomerAppliction {
	public static void main(String[] args) {
		SpringApplication.run(CustomerAppliction.class, args);
	}
}
