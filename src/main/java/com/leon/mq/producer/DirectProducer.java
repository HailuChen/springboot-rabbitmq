package com.leon.mq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenhailu
 * @date 2018/7/10 14:52
 */

@Component
public class DirectProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue.direct}")
    private String directQueue;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void send() {
        String ask = "direct : Hi ! what time ?   ";
        LOGGER.info("<<<<<<<<<<< direct send" + ask);
        this.rabbitTemplate.convertAndSend(directQueue, ask);
    }
}
