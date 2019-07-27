package org.dzq.springcloud.service;

import java.util.List;

import org.dzq.springcloud.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "MICROSERVICECLOUD-DEOT")
public interface DeptClientService {
	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long deptno);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();
}
