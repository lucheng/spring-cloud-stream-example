package com.cheng.stream.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.cheng.stream.entity.DelayModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableBinding(MqMessageSource2.class)
public class DelayedQueueProducer {
	 @Autowired
     private MqMessageSource2 messageSource;

     public void publish(DelayModel model) {
         long delay = model.getDelay();
         Message<DelayModel> message = MessageBuilder.withPayload(model).setHeader("x-delay", delay).build();
         messageSource.delayedQueueOutput().send(message);
         log.info("发布延迟队列消息: {}", model);
     }
}
