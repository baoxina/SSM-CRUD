package com.baoxina.ssm.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baoxina.ssm.crud.mapper.DepartmentMapper;
import com.baoxina.ssm.crud.mapper.EmployeeMapper;
import com.baoxina.ssm.crud.po.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml","classpath:spring/spring-transaction.xml"})
public class CRUDTest {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Autowired
	private SqlSession batchOperationSqlSession;
	
	@Test
	public void test(){
		/*departmentMapper.insertSelective(new Department(null, "科技部"));
		departmentMapper.insertSelective(new Department(null, "市场部"));
		departmentMapper.insertSelective(new Department(null, "人事部"));
		departmentMapper.insertSelective(new Department(null, "销售部"));
		departmentMapper.insertSelective(new Department(null, "后勤部"));*/
		
		EmployeeMapper mapper = batchOperationSqlSession.getMapper(EmployeeMapper.class);
		for(int i = 1; i <= 1000; i++){
			StringBuffer sb = new StringBuffer().append(UUID.randomUUID().toString().substring(0,5)).append(i);
			mapper.insertSelective(new Employee(null, sb.toString(), i % 2 == 0 ? "M" : "F", sb + "@yilive.com", i % 5 == 0 ? 1 : i % 5));
		}
		
	}

}
