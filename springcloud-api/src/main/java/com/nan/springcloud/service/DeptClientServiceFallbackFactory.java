package com.nan.springcloud.service;

import com.nan.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
//降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryId(Long id) {
                return new Dept().
                        setDeptno(id).
                        setDname("id=>"+id+"服务关闭了").
                        setDb_source("不存在这个数据库");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
