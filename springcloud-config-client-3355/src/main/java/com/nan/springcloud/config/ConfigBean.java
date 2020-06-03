package com.nan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {



    //配置负载均衡实现RestTemplate
    //IRule
    //RoundRobinRule 轮训
    //RandomRule 随机
    // RetryRule 先轮训，如果服务器获取失败，经过一段时间后重试
    //AvailabilityFlteringRule：会先过滤掉崩溃的服务，对剩下的进行轮休
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
