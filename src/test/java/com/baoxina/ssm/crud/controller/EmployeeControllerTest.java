package com.baoxina.ssm.crud.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.baoxina.ssm.crud.po.Employee;
import com.github.pagehelper.PageInfo;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-transaction.xml","classpath:springmvc/springmvc.xml"})
public class EmployeeControllerTest {

	@Autowired
	WebApplicationContext context;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetEmpsModelInteger() throws Exception {
		//模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emp/getEmps/80")).andReturn();
		//请求成功以后，请求域中会有pageInfo
		MockHttpServletRequest request = result.getRequest();
		PageInfo<Employee> pageInfo = (PageInfo<Employee>)request.getAttribute("pageInfo");
		System.out.println("当前页码：" + pageInfo.getPageNum());
		System.out.println("总页码：" + pageInfo.getPages());
		System.out.println("总记录数：" + pageInfo.getTotal());
		System.out.println("连续显示的页码：");
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		for(int navigatepageNum : navigatepageNums){
			System.out.print(" " + navigatepageNum);
		}
		System.out.println();
		//当前需要显示的数据
		List<Employee> list = pageInfo.getList();
		for(Employee emp : list){
			System.out.println(emp.getEmail());
		}
	}
}
