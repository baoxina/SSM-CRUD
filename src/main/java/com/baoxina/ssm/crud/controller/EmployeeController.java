package com.baoxina.ssm.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baoxina.ssm.crud.po.EmployeeExt;
import com.baoxina.ssm.crud.service.IEmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@RequestMapping("/emp")
@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	private final int DEFAULT_PAGE_SIZE = 10;
	
	@RequestMapping("/getEmps/{pageNum}/{pageSize}")
	public String getEmps(Model model,
			@PathVariable("pageNum") Integer pageNum,
			@PathVariable("pageSize")Integer pageSize) throws Exception{
		List<EmployeeExt> emps = employeeService.getAll(pageNum, pageSize);
		model.addAttribute("emps", emps);
		return "list";
	}
	
	@RequestMapping(value="/getEmps/{pageNum}")
	public String getEmps(Model model,@PathVariable("pageNum") Integer pageNum) throws Exception{
		//引入PageHelper分页插件
		//在查询之前只需要调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNum, DEFAULT_PAGE_SIZE);
		//startPage后面要紧跟的查询就是一个分页查询
		List<EmployeeExt> emps = employeeService.getEmps(pageNum, DEFAULT_PAGE_SIZE);
		//使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
		//pageInfo封装了详细的分页信息，包括我们查询出来的数据。
		//pageInfo还可以传入连续显示的页数
		PageInfo<EmployeeExt> pageInfo = new PageInfo<EmployeeExt>(emps, 5);
		model.addAttribute("pageInfo", pageInfo);
		return "list";
	}
	
	
}
