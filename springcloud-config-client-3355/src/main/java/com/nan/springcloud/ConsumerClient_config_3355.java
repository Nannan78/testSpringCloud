package com.nan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerClient_config_3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerClient_config_3355.class,args);
    }
}
