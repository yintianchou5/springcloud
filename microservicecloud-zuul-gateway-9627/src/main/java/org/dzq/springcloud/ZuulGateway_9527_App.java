package org.dzq.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//http://myzuul.com:9527/microservicecloud-dept/dept/get/1  这样能通过路由访问服务
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableZuulProxy
public class ZuulGateway_9527_App {
	public static void main(String[] args) {
		SpringApplication.run(ZuulGateway_9527_App.class, args);
	}
}
