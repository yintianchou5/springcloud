package org.dzq.springcloud.service;

import java.util.List;

import org.dzq.springcloud.pojo.Dept;

/**
 * @author dzq
 * @createTime 30 15:03
 * @description
 */
public interface DeptService {

    /**
     * 插入
     * @param dept
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 根据id查找
     * @param deptno
     * @return
     */
    Dept findById(Long deptno);

    /**
     * 查询全部
     * @return
     */
    List<Dept> findAll();
}