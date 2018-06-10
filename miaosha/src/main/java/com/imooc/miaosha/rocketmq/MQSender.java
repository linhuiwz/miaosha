package com.imooc.miaosha.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.miaosha.redis.RedisService;
import com.qianmi.ms.starter.rocketmq.core.RocketMQTemplate;

@Service(value="RocketMQSender")
public class MQSender {

	private static Logger log = LoggerFactory.getLogger(MQSender.class);

	@Autowired
	private RocketMQTemplate rocketMQTemplate;

	public void sendMiaoshaMessage(MiaoshaMessage mm) {
		String msg = RedisService.beanToString(mm);
		log.info("send message:" + msg);
		rocketMQTemplate.convertAndSend("miaosha_queue", msg);
	}
	
	public void send(String message) {
		log.info("send message:" + message);
		rocketMQTemplate.convertAndSend("test_queue", message);
	}

}
