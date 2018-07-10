package com.leon.mq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenhailu
 * @date 2018/7/10 14:58
 */

@Configuration
public class DirectRabbitConfig {

    @Value("${spring.rabbitmq.queue.direct}")
    private String directQueue;

    @Bean
    public Queue directQueue() {
        return new Queue(directQueue);
    }

}
