package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.DepartmentMapper;
import com.dms.oa.po.Department;
import com.dms.oa.po.DepartmentExample;

@Component
public class DepartmentDao {
	@Autowired
	private DepartmentMapper departmentMapper;

	 
	 public List<Department> selectAllDepartment(){
		 DepartmentExample example =new DepartmentExample();
		 return departmentMapper.selectByExample(example);
	 }

}
