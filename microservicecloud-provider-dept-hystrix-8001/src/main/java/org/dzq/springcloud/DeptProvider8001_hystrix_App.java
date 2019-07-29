package org.dzq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//将本服务自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker//增加对hystrix熔断器的启用
public class DeptProvider8001_hystrix_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_hystrix_App.class, args);
	}

}
