package com.nan.springcloud.controller;

import com.nan.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;
    @Value("${server.port}")
    private String port;
    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问http服务的方式，是简单的Restful服务模板


    //Ribbon中这里的地址应该是一个变量

    /* private static final String REST_URL_PREFIX="http://localhost:8001";*/
 /*   private static final String REST_URL_PREFIX="http://localhost:8001";*/
    private static final String REST_URL_PREFIX="http://SPRINGCLOUD-CONFIG-DEV";
    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);

    }
    @RequestMapping("/consumer/dept/add")
    public boolean add( Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);

    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);

    }

    @RequestMapping("/config")
    public String  getConfig(){

        return "application"+applicationName+
                "service"+eurekaServer+
                "port"+port;
    }

}
