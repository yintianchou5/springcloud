package org.dzq.springcloud.service;

import java.util.List;

import org.dzq.springcloud.pojo.Dept;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
@Component//这个不能丢
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Dept get(long deptno) {
				return new Dept().setDeptno(deptno).setDname("该ID"+deptno+"没有对应信息,该服务已经关闭").setDb_source("no this database in MySql");
			}
			
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

}
