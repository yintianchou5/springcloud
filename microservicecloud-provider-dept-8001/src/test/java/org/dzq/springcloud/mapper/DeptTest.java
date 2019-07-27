package org.dzq.springcloud.mapper;

import org.dzq.springcloud.pojo.Dept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeptTest {
	@Autowired
	private DeptMapper mapper;
	
	public  void testFindById() {
		Long id=1l;
		Dept dept = mapper.findById(id);
		System.out.println(dept.getDb_source());
		
	}
}
