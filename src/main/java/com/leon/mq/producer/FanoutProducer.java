package com.leon.mq.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chenhailu
 * @date 2018/7/10 17:22
 */

@Component
public class FanoutProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(FanoutProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange.fanout}")
    private String fanoutExchange;

    @Scheduled(cron = "0 0 11 * * ?")
    public void send() {
        LOGGER.info("##########  fanout send : 各位同学报一下自己的学号！");
        this.rabbitTemplate.convertAndSend(fanoutExchange, "","学号:");
    }

}
