package org.dzq.springcloud.service.Impl;

import java.util.List;

import org.dzq.springcloud.mapper.DeptMapper;
import org.dzq.springcloud.pojo.Dept;
import org.dzq.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dzq
 * @createTime 30 15:04
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public boolean addDept(Dept dept) {
      return   deptMapper.addDept(dept);
    }

    @Override
    public Dept findById(Long deptno) {
        return  deptMapper.findById(deptno);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}