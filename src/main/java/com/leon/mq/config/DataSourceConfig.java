package com.leon.mq.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author chenhailu
 * @date 2018/7/10 15:10
 */
@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new HikariDataSource();
        return dataSource;
    }
}
