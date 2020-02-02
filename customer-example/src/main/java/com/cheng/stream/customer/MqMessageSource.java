package com.cheng.stream.customer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

/**
 * mq连接源定义
 *
 * 其中类中的2个属性的值和properties里的配置需要一致
 **/
public interface MqMessageSource {
	// ECM消费者
	String ECM_SHOP_TEMPLATE_INPUT = "ecm_shop_template";

	@Input(ECM_SHOP_TEMPLATE_INPUT)
	MessageChannel messageInput();
}