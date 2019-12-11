package com.jun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jun.dao.DeptDao;
import com.jun.entity.Dept;
import com.jun.service.DeptClientService;

@Service
public class DeptServiceImpl implements DeptClientService {

	@Autowired
	private DeptDao deptDao;

	public Dept get(Long id) {
		return deptDao.get(id);
	}

	public List<Dept> list() {
		return deptDao.findList();
	}

}
