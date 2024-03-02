package com.practise.multiple.datasource.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.practise.multiple.datasource.*" })
public class MultipleDataSourcesWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDataSourcesWithSpringBootApplication.class, args);
    }
}