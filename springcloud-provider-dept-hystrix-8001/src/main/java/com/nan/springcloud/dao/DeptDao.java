package com.nan.springcloud.dao;


import com.nan.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {
    public boolean addDept(Dept dept);
    public Dept queryId(Long id);
    public List<Dept> queryAll();
}
