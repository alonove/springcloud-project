package com.jun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jun.entity.Dept;

@Mapper
public interface DeptDao {

	Dept get(Long id);

	List<Dept> findList();

}
