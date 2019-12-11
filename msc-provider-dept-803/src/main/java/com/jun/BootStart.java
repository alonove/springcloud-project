package com.jun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient  //本服务启动后会自动注册进Eureka服务中
@EnableHystrix
public class BootStart {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BootStart.class, args);
	}

}
