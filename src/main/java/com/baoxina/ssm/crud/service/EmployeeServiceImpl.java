package com.baoxina.ssm.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baoxina.ssm.crud.mapper.EmployeeMapper;
import com.baoxina.ssm.crud.po.EmployeeExt;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<EmployeeExt> getAll(int pageNum,int pageSize) throws Exception {
		return employeeMapper.selectAllWithDeptPage(pageNum, pageSize);
	}

	@Override
	public List<EmployeeExt> getEmps(int pageNum, int pageSize) throws Exception {
		return employeeMapper.selectByExampleWithDept(null);
	}
}
