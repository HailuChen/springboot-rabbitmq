package com.leon.mq.producer;

import com.leon.mq.model.Jack;
import com.leon.mq.model.Rose;
import com.leon.mq.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chenhailu
 * @date 2018/7/10 16:12
 */

@Component
public class TopicProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicProducer.class);

    @Value("${spring.rabbitmq.exchange.topic}")
    private String topicExchange;

    @Value("${spring.rabbitmq.queue.topicA}")
    private String topicQueueA;

    @Value("${spring.rabbitmq.queue.topicB}")
    private String topicQueueB;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "0 30 9 * * ?")
    public void sendToJack() {
        User jack = new Jack();
        LOGGER.info("**********  topic send queueA : Can you introduce yourself  Jack ? ");
        this.rabbitTemplate.convertAndSend(topicExchange, topicQueueA, jack);
    }

    @Scheduled(cron = "0 0 10 * * ?")
    public void sendToRose() {
        User rose = new Rose();
        LOGGER.info("**********  topic send queueB : Can you introduce yourself  Rose ?");
        this.rabbitTemplate.convertAndSend(topicExchange, topicQueueB, rose);
    }

}
