package org.dzq.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServices;
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/config")
	public String getConfig() {
		String str="applicationName:"+this.applicationName+"\t eurekaService"+this.eurekaServices+" \t port"+this.port;
		System.out.println("str:::"+str );
		return str;
	}
}
