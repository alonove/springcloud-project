package com.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.entity.Dept;
import com.jun.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@GetMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod="doException")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.getDept(id);
		if(dept == null) {
			throw new RuntimeException();
		}
		return dept;
	}

	@GetMapping("/dept/list")
	public List<Dept> list() {
		return deptService.findDeptList();
	}

	/**
	 * 服务熔断回调
	 * @param id
	 * @return
	 */
	public Dept doException(@PathVariable("id") Long id) {
		return Dept.builder().id(id).name("该"+id+"没有对应的信息").source("NO========").build();
	}

}
