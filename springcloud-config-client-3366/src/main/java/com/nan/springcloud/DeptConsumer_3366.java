package com.nan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer_3366 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_3366.class,args);
    }
}
