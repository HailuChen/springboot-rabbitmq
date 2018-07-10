package com.leon.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author chenhailu
 * @date 2018/7/10 14:58
 */

@Configuration
public class TopicRabbitConfig {

    @Value("${spring.rabbitmq.queue.topicA}")
    private String topicA;
    @Value("${spring.rabbitmq.queue.topicB}")
    private String topicB;
    @Value("${spring.rabbitmq.exchange.topic}")
    private String topicExchange;

    @Bean
    public Queue topicQueueA() {
        return new Queue(topicA);
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(topicB);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding bindingExchangeTopicA(Queue topicQueueA, TopicExchange exchange){
        return  BindingBuilder.bind(topicQueueA).to(exchange).with(topicA);
    }

    @Bean
    public Binding bindingExchangeTopicB(Queue topicQueueB, TopicExchange exchange){
        return  BindingBuilder.bind(topicQueueB).to(exchange).with("topic_queue.#");
    }

}
