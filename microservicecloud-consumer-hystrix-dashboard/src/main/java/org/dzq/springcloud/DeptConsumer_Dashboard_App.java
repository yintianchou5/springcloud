package org.dzq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//访问dashboard（豪猪）是localhost:9001/hystrix
@SpringBootApplication
@EnableHystrixDashboard//需要provider依赖中有actuator
public class DeptConsumer_Dashboard_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_Dashboard_App.class, args);
	}
}
