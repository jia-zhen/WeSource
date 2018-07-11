package com.we.service.impl;

import com.we.model.Dept;
import com.we.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("deptService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl extends BaseService<Dept> implements DeptService {


	@Override
	public List<Dept> findAllDepts(Dept dept) {
		return null;
	}

	@Override
	public Dept findByName(String deptName) {
		return null;
	}

	@Override
	public Dept findById(Long deptId) {
		return null;
	}

	@Override
	public void addDept(Dept dept) {

	}

	@Override
	public void updateDept(Dept dept) {

	}

	@Override
	public void deleteDepts(String deptIds) {

	}
}
