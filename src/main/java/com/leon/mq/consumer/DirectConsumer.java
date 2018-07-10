package com.leon.mq.consumer;

import com.leon.mq.producer.DirectProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenhailu
 * @date 2018/7/10 14:58
 */

@Component
public class DirectConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectProducer.class);

    @RabbitListener(queues = "direct_queue")
    @RabbitHandler
    public void receive(String response) {
        LOGGER.info(">>>>>>>>> direct receive : "+ response +"it's" + new Date());
    }

}




