package com.cheng.stream.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * mq连接源定义
 *
 * 其中类中的2个属性的值和properties里的配置需要一致
 **/
public interface MqMessageSource2 {
	@Output("delayedQueueOutput")
	MessageChannel delayedQueueOutput();
}