package com.jun.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jun.entity.Dept;
import com.jun.service.fallback.DeptClientServiceFallbackFactory;

//@FeignClient(value = "MSC-DEPT-SERVICE")
@FeignClient(value = "MSC-DEPT-SERVICE", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@GetMapping("/dept/get/{id}")
	Dept get(@PathVariable("id") Long id);

	@GetMapping("/dept/list")
	List<Dept> list();
}
