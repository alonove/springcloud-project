package com.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.entity.Dept;
import com.jun.service.DeptClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Hystrix服务熔断
 * @Author Jun
 * @date 2019年12月6日 下午12:15:49
 */
@RestController
public class DeptController {

	@Autowired
	private DeptClientService deptService;

	@GetMapping("/dept/get/{id}")
//	@HystrixCommand(fallbackMethod="doException")
	public Dept get(@PathVariable("id") Long id) {

		Dept dept = deptService.get(id);
		if(dept == null) {
			throw new RuntimeException();
		}

		return deptService.get(id);
	}

	@GetMapping("/dept/list")
	@HystrixCommand(fallbackMethod="doException2")
	public List<Dept> list() {
		System.err.println("==========================");
		return deptService.list();
	}

	/**
	 * 服务熔断回调
	 * @param id
	 * @return
	 */
	public Dept doException(@PathVariable("id") Long id) {
		return Dept.builder().id(id).name("该"+id+"没有对应的信息").source("NO DB SOURCE").build();
	}

	public List<Dept> doException2() {
		return null;
	}

}
