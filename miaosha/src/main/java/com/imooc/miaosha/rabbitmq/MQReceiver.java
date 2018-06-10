package com.imooc.miaosha.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MQReceiver {

    private static Logger LOG = LoggerFactory.getLogger(MQReceiver.class);

    @RabbitListener(queues = MQConfig.QUEUE_NAME)
    public void receive(String msg) {
        LOG.warn(msg);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE_1)
    public void receiveTopic1(String msg) {
        LOG.warn(msg);
    }

    @RabbitListener(queues = MQConfig.TOPIC_QUEUE_2)
    public void receiveTopic2(String msg) {
        LOG.warn(msg);
    }

    @RabbitListener(queues=MQConfig.HEADER_QUEUE)
    public void receiveHeaderQueue(byte[] message) {
        LOG.warn(" header  queue message:"+new String(message));
    }
}
