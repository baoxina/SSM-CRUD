package com.baoxina.ssm.crud.mapper;

import com.baoxina.ssm.crud.po.Employee;
import com.baoxina.ssm.crud.po.EmployeeExample;
import com.baoxina.ssm.crud.po.EmployeeExt;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);
    
    List<EmployeeExt> selectByExampleWithDept(EmployeeExample example);

    EmployeeExt selectByPrimaryKeyWithDept(Integer empId);
    
    //参数方法调用 执行分页查询，不需要在 xml 处理后两个参数，需要配置PageInterceptor的属性 supportMethodsArguments=true
    List<EmployeeExt> selectAllWithDeptPage(@Param("pageNumKey") int pageNum,@Param("pageSizeKey") int pageSize);
    
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}