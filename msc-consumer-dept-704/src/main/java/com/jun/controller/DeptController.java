package com.jun.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.entity.Dept;
import com.jun.service.DeptClientService;
import com.jun.service.DeptService;

/**
 * Eureka + Ribbon + Feign + hystrix-dashboard
 * Feign通过接口的方法调用Rest服务（之前是Ribbon+RestTemplate），通过Feign直接找到服务接口，由于在进行服务调用的时候融合了Ribbon技术，所以也支持负载均衡作用
 * @Author Jun
 * @date 2019年12月6日 上午10:21:54
 */
@RestController
public class DeptController {

	@Autowired
	private DeptClientService deptClientService;

	@Autowired
	private DeptService deptService;

	@GetMapping("/dept/get/{id}")
	public void get(@PathVariable("id") Long id) throws InterruptedException {
		while(true) {
			Dept dept = deptClientService.get(Long.valueOf(new Random().nextInt(10)));
			System.err.println(dept);
			Thread.sleep(new Random().nextInt(2000));
			dept = deptService.getDept(Long.valueOf(new Random().nextInt(10)));
			System.err.println(dept);
		}
	}

	@GetMapping("/dept/list")
	public void list() throws InterruptedException {

		while(true) {
			deptClientService.list();
			Thread.sleep(new Random().nextInt(2000));
		}

	}

}
