package com.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.entity.Dept;
import com.jun.service.DeptClientService;

/**
 * Eureka + Ribbon + Feign
 * Feign通过接口的方法调用Rest服务（之前是Ribbon+RestTemplate），通过Feign直接找到服务接口，由于在进行服务调用的时候融合了Ribbon技术，所以也支持负载均衡作用
 * @Author Jun
 * @date 2019年12月6日 上午10:21:54
 */
@RestController
public class DeptController {

	@Autowired
	private DeptClientService deptClientService;

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return deptClientService.get(id);
	}

	@GetMapping("/dept/list")
	public List<Dept> list() {
		return deptClientService.list();
	}

}
