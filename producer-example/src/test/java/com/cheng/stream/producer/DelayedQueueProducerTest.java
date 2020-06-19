package com.cheng.stream.producer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.test.context.junit4.SpringRunner;

import com.cheng.stream.entity.DelayModel;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding({ MqMessageSource.class, MqMessageSource2.class })
class DelayedQueueProducerTest {

	@Autowired
	private DelayedQueueProducer delayedQueueProducer;

	@Test
	void test() {
		for (int i = 0; i < 1; i++) {
			// 随机延迟 3-8 秒
			long delay = 8000;
			delayedQueueProducer.publish(new DelayModel(delay));
		}
	}

}
