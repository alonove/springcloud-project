package com.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jun.entity.Dept;

/**
 * Eureka + Ribbon
 * Ribbon其实就是一个软负载均衡的客户端组件，他可以和其他所需请求的客户端结合使用，和eureka结合只是其中的一个实例
 * @Author Jun
 * @date 2019年12月6日 上午10:21:54
 */
@RestController
public class DeptController {

	//通过应用注册名称进行远程访问,对应spring.application.name大写
	private static final String REST_URL_PREFIX = "http://MSC-DEPT-SERVICE";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

}
