package com.baoxina.ssm.crud.service;

import java.util.List;

import com.baoxina.ssm.crud.po.EmployeeExt;

public interface IEmployeeService {
	public List<EmployeeExt> getAll(int pageNum,int pageSize) throws Exception;
	
	public List<EmployeeExt> getEmps(int pageNum,int pageSize) throws Exception;
	
}
