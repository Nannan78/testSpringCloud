package com.nan.springcloud.service;

import com.nan.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

        public boolean addDept(Dept dept);
        public Dept queryId(Long id);
        public List<Dept> queryAll();


}

