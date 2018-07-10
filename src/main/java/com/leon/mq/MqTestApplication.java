package com.leon.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author chenhailu
 * @date 2018/7/10 13:10:00
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "com.leon.mq")
@EnableScheduling
public class MqTestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MqTestApplication.class);
    }



    public static void main(String[] args) {
        SpringApplication.run(MqTestApplication.class, args);
    }
}
