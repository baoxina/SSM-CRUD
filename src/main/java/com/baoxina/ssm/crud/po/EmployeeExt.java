package com.baoxina.ssm.crud.po;

public class EmployeeExt extends Employee{

	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
