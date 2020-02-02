package com.cheng.stream.customer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(MqMessageSource.class)
public class StreamListenerReceiveService {

	/**
	 * 消费ECM的货柜模板变更
	 *
	 * @param message
	 */
	@StreamListener(value = MqMessageSource.ECM_SHOP_TEMPLATE_INPUT)
	public void receive(String message) {
		log.info("接收1111111111111111参数={}", message);
	}

	/**
	 * 消费ECM的货柜模板变更
	 *
	 * @param message
	 *//*
		 * @StreamListener(MqMessageSource.ECM_SHOP_TEMPLATE_INPUT) public void
		 * receive2(String message) { log.info("接收222222222222222参数={}", message); }
		 */
}