package com.nan.springcloud.controller;

import com.nan.springcloud.pojo.Dept;
import com.nan.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
   public Dept get(@PathVariable("id") Long id){
       Dept dept = deptService.queryId(id);
       if (dept==null){
           throw new RuntimeException("id=>"+id+"不存在");
       }
       return dept;
   }

    public Dept hystrixGet(@PathVariable("id") Long id){
       return new Dept().setDeptno(id).setDname("id=>"+id+"id不存在").setDb_source("不存在这个数据库");
    }





























}
