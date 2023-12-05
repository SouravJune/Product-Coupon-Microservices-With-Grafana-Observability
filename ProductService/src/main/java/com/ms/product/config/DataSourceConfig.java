package com.ms.product.config;

import com.zaxxer.hikari.HikariDataSource;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static net.ttddyy.dsproxy.listener.logging.SLF4JLogLevel.INFO;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {

        HikariDataSource originalDataSource = new HikariDataSource();
        originalDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/microservices");
        originalDataSource.setUsername("root");
        originalDataSource.setPassword("Sourav#8699");

        return ProxyDataSourceBuilder
                .create(originalDataSource)
                .logQueryBySlf4j(INFO)
                .build();

    }
}

