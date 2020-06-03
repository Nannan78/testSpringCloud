package com.nan.myRibbonconfig;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    @Bean
    public IRule DIYRule(){
        return new MyRibbonRule();
    }
}
