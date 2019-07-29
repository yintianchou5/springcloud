package org.dzq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//将本服务自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
public class DeptGitProvider8001_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptGitProvider8001_App.class, args);
	}

}
