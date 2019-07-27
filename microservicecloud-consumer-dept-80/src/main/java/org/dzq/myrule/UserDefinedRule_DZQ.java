package org.dzq.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
/**
 * 实现一个自定义的轮询，当被服务5次后才换提供者,并且是轮询的方式
 * @author xxx-d2q
 *
 */
public class UserDefinedRule_DZQ extends AbstractLoadBalancerRule{
	private int total=0;//总共被调用的次数
	private int currentIndex=0;//当前提供服务的服务方8001 0，8002 1，8003 2
	
	
	public Server choose(ILoadBalancer lb,Object key) {
		if(lb==null) {
			return null;
		}
		Server server=null;
		while(server==null) {
			if(Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();
			int serverCount=allList.size();
			
			if(total<5) {
				server=upList.get(currentIndex);
				total++;
			}else {
				total=0;
				currentIndex++;
				if(currentIndex>=upList.size()) {
					currentIndex=0;
				}
			}
			
			if(serverCount==0) {
				return null;
			}
			if(server==null) {
				Thread.yield();
				continue;
			}
			if(server.isAlive()) {
				return (server);
			}
			server=null;
			Thread.yield();
		}
		return server;
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(),key);
	}
	
}
