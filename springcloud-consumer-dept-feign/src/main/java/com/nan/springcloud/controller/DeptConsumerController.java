package com.nan.springcloud.controller;

import com.nan.springcloud.pojo.Dept;
import com.nan.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private RestTemplate restTemplate;//提供多种便捷访问http服务的方式，是简单的Restful服务模板

    //Ribbon中这里的地址应该是一个变量
    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.queryId(id);

    }
    @RequestMapping("/consumer/dept/add")
    public boolean add( Dept dept){
        return this.deptClientService.addDept(dept);

    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.deptClientService.queryAll();

    }














}
