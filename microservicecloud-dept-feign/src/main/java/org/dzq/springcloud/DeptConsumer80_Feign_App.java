package org.dzq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
//@RibbonClient自定义均衡负荷算法，但是该类不能与@conponentScan在同一包或子包
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"org.dzq.springcloud"})
@ComponentScan("org.dzq.springcloud")
public class DeptConsumer80_Feign_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_Feign_App.class, args);
	}

}
