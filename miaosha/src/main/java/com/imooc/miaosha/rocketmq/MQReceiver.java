package com.imooc.miaosha.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.miaosha.domain.MiaoshaOrder;
import com.imooc.miaosha.domain.MiaoshaUser;
import com.imooc.miaosha.redis.RedisService;
import com.imooc.miaosha.service.GoodsService;
import com.imooc.miaosha.service.MiaoshaService;
import com.imooc.miaosha.service.OrderService;
import com.imooc.miaosha.vo.GoodsVo;
import com.qianmi.ms.starter.rocketmq.annotation.RocketMQMessageListener;
import com.qianmi.ms.starter.rocketmq.core.RocketMQListener;

@Service
@RocketMQMessageListener(topic = "miaosha_queue", consumerGroup = "my-consumer_miaosha_queue")
public class MQReceiver implements RocketMQListener<String>{

	private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

	@Autowired
	RedisService redisService;

	@Autowired
	GoodsService goodsService;

	@Autowired
	OrderService orderService;

	@Autowired
	MiaoshaService miaoshaService;

	@Override
	public void onMessage(String message) {
		log.info("receive message:" + message);
		MiaoshaMessage mm = RedisService.stringToBean(message, MiaoshaMessage.class);
		MiaoshaUser user = mm.getUser();
		long goodsId = mm.getGoodsId();

		GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
		int stock = goods.getStockCount();
		if (stock <= 0) {
			return;
		}
		// 判断是否已经秒杀到了
		MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(user.getId(), goodsId);
		if (order != null) {
			return;
		}
		// 减库存 下订单 写入秒杀订单
		miaoshaService.miaosha(user, goods);
	}

}
