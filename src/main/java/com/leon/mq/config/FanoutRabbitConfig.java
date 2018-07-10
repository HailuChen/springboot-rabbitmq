package com.leon.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author chenhailu
 * @date 2018/7/10 14:58
 */

@Configuration
public class FanoutRabbitConfig {

    @Value("${spring.rabbitmq.queue.fanoutA}")
    private String fanoutQueueA;

    @Value("${spring.rabbitmq.queue.fanoutB}")
    private String fanoutQueueB;

    @Value("${spring.rabbitmq.exchange.fanout}")
    private String fanoutExchange;

    @Bean
    public Queue fanoutQueueA() {
        return new Queue(fanoutQueueA);
    }

    @Bean
    public Queue fanoutQueueB() {
        return new Queue(fanoutQueueB);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }
}
