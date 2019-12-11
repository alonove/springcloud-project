package com.jun.service;

import java.util.List;

import com.jun.entity.Dept;

public interface DeptService {

	Dept getDept(Long id);

	List<Dept> findDeptList();

}
