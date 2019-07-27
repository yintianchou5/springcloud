package org.dzq.springcloud.controller;

import java.util.List;

import org.dzq.springcloud.pojo.Dept;
import org.dzq.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService deptClientService;
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.deptClientService.add(dept);
	}
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.get(id);
	}
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list() {
		return this.list();
	}
	
}
