package com.example.redispubsub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.redispubsub"})
@PropertySource("classpath:application.properties")
public class RedisPubsubApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RedisPubsubApplication.class, args);

    }

}
