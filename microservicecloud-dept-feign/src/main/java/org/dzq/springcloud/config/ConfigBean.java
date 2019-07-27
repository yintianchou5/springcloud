package org.dzq.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {
	@Bean
	@LoadBalanced // 客户端 负载均衡   (默认是轮询算法)
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	/**
	 * 该方法能更换ribbon提供的负载均衡算法
	 * @return
	 */
	@Bean
	public IRule myRule() {
		//随机算法,ribbon提供了多种，自己百度搜
		//return new RoundRobinRule();//轮询
		//return new RetryRule();//和轮询差不多，但比轮询好一点
		return new RandomRule();//随机
	}
}
