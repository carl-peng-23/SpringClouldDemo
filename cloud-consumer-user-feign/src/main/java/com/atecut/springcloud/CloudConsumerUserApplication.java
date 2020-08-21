package com.atecut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableHystrixDashboard //开启可视化监控功能
@EnableCircuitBreaker //启用熔断器功能
@EnableFeignClients	// 启用Feign远程客户端
@EnableDiscoveryClient
@SpringBootApplication
public class CloudConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConsumerUserApplication.class, args);
	}

}
