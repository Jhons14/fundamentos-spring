package com.fundamentos.spring.fundamentos.configuration;

import com.fundamentos.spring.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.spring.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentos.spring.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.nombre}")
    private String nombre;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(nombre, apellido);
    }

    @Bean
    public DataSource dataSource (){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("jhon");
        dataSourceBuilder.password("");

        return dataSourceBuilder.build();
    }
}
