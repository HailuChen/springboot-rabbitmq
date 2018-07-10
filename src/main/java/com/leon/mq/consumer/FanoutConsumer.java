package com.leon.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author chenhailu
 * @date 2018/7/10 17:31
 */
@Component
public class FanoutConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutConsumer.class);

    @RabbitListener(queues = "fanout_queue.a")
    @RabbitHandler
    public void receive1(String msg) {
        LOGGER.info(msg + "chen : NO.1");
    }

    @RabbitListener(queues = "fanout_queue.b")
    @RabbitHandler
    public void receive2(String msg) {
        LOGGER.info(msg + "lin : NO.2");
    }

}
