package com.nan.springcloud.controller;

import com.nan.springcloud.pojo.Dept;
import com.nan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptProvider_8003 {
    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long  id){
        return deptService.queryId(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    //注册进来的微服务，可以获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("discovery=>"+services);

        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for(ServiceInstance instance:instances){
            System.out.println(
                    instance.getHost()+"\t"+
                            instance.getHost()+"\t"+
                            instance.getPort()+"\t"+
                            instance.getUri()+"\t"+
                            instance.getServiceId()

            );
        }
        return this.client;
    }





























}
