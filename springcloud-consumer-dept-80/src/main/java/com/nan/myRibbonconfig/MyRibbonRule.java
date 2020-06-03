//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nan.myRibbonconfig;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class MyRibbonRule extends AbstractLoadBalancerRule {
    public MyRibbonRule() {
    }

    private int totol=0;
    private int current=0;


    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();//获取所有活着的服务
                List<Server> allList = lb.getAllServers();//获取所有服务
                int serverCount = allList.size(); //所有服务的数目
                if (serverCount == 0) {
                    return null;
                }

                //设置一个服务器提供五次服务后转跳至下一服务
                if(totol<5){
                    server=(Server)upList.get(current);
                    totol++;
                    if (server.isAlive()) { //服务可用 就返回
                        return server;
                    }
                }else{
                    totol=0;
                    current++;
                    if(current<upList.size()){
                        server=(Server)upList.get(current);
                        if (server.isAlive()) { //服务可用 就返回
                            return server;
                        }
                    }else{
                        current=0;
                        server=(Server)upList.get(current);
                        if (server.isAlive()) { //服务可用 就返回
                            return server;
                        }
                    }

                }

         /*       server = (Server)upList.get(index); //得到随机的服务
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) { //服务可用 就返回
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }*/
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
