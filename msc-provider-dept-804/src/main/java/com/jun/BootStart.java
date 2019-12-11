package com.jun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient // 本服务启动后会自动注册进Eureka服务中
//@EnableCircuitBreaker // 启动对Hystrix熔断机制的支持
@EnableHystrix
public class BootStart {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootStart.class, args);
	}

	/*
	 * @Bean public ServletRegistrationBean getServlet() {
	 *
	 * HystrixMetricsStreamServlet streamServlet = new
	 * HystrixMetricsStreamServlet(); ServletRegistrationBean registrationBean = new
	 * ServletRegistrationBean(streamServlet);
	 * registrationBean.setLoadOnStartup(1);// 系统启动时加载顺序
	 * registrationBean.addUrlMappings("/hystrix.stream");// 路径
	 * registrationBean.setName("HystrixMetricsStreamServlet"); return
	 * registrationBean; }
	 */

}
