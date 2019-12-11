package com.jun.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jun.entity.Dept;

@FeignClient("DEPT-SERVER")
public interface DeptService {

	@GetMapping("/dept/get/{id}")
	Dept getDept(@PathVariable("id") Long id);

	@GetMapping("/dept/list")
	List<Dept> findDeptList();

}
