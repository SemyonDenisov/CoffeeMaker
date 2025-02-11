package ru.coffemaker.CoffeeMaker.Configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.username}")
    private String username;

    @Bean
    public DataSource getDataSource() {
        System.out.println(username + ":" + password + " url: " + url);
        DataSourceBuilder<?> dataSourceBuilder =
                DataSourceBuilder.create()
                        .username(username)
                        .password(password)
                        .url(url);
        return dataSourceBuilder.build();
    }
}