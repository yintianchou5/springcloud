package org.dzq.springcloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dzq.springcloud.pojo.Dept;

@Mapper
public interface DeptMapper {
	public boolean addDept(Dept dept);
	public Dept findById(Long id);
	public List<Dept> findAll();
}
