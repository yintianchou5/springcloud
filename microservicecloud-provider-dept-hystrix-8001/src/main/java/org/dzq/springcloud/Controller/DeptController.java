package org.dzq.springcloud.Controller;

import java.util.List;

import org.dzq.springcloud.pojo.Dept;
import org.dzq.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author dzq
 * @createTime 30 15:07
 * @description
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean addDept(@RequestBody Dept dept) {
        return   deptService.addDept(dept);
    }
    
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "processHystrix_Get")//服务熔断
    public Dept findById(@PathVariable("id") Long id) {
    	Dept dept = this.deptService.findById(id);
    	if(dept==null) {
    		throw new RuntimeException("该ID"+id+"没有对应信息");
    	}
        return  dept;
    }
    
    public Dept processHystrix_Get(@PathVariable("id") Long id) {
    		return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应信息,null--@HystrixCommand").setDb_source("no this database in MySql");
    }

    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> findAll() {
        return deptService.findAll();
    }
    /**
     * 服务发现
     * @return
     */
    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery() {
    	List<String> list=client.getServices();//可以得到已经注册的微服务列表
    	System.out.println("*******"+list);
    	List<ServiceInstance> serviceInstanceList = client.getInstances("MICROSERVICECLOUD-DEPT");
    	for(ServiceInstance serviceInstance:serviceInstanceList) {
    		System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
    	}
    	return this.client;
    }
    
    

}