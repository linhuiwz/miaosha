package com.imooc.miaosha.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qianmi.ms.starter.rocketmq.annotation.RocketMQMessageListener;
import com.qianmi.ms.starter.rocketmq.core.RocketMQListener;

@Service
@RocketMQMessageListener(topic = "test_queue", consumerGroup = "my-consumer_test_queue")
public class TestMQReceiver implements RocketMQListener<String> {

	private static Logger log = LoggerFactory.getLogger(TestMQReceiver.class);

	@Override
	public void onMessage(String message) {
		log.info("==================receive message:" + message);
	}

}
