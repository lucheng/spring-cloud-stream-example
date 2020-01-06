package com.cheng.stream.customer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink1 {
	/**
	 * Input channel name.
	 */
	String INPUT = "input1";

	/**
	 * @return input channel.
	 */
	@Input(INPUT)
	SubscribableChannel input();
}
