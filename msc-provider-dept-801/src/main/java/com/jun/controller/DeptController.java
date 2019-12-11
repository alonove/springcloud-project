package com.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jun.entity.Dept;
import com.jun.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.getDept(id);
		if(dept == null) {
			throw new RuntimeException();
		}

		return deptService.getDept(id);
	}

	@GetMapping("/dept/list")
	public List<Dept> list() {
		return deptService.findDeptList();
	}

}
