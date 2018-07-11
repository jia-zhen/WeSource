package com.we.service;

import com.we.model.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {



	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
