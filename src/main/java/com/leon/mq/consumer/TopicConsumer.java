package com.leon.mq.consumer;

import com.leon.mq.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author chenhailu
 * @date 2018/7/10 16:53
 */

@Component
public class TopicConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicConsumer.class);

    @RabbitListener(queues = "topic_queue.a")
    @RabbitHandler
    public void receive1(User user) {
        LOGGER.info( "********* topic receive queue_a  :" +user.toString());
    }

    @RabbitListener(queues = "topic_queue.b")
    @RabbitHandler
    public void receive2(User user) {
        LOGGER.info( "********* topic receive queue_b  :"+ user.toString());
    }
}
