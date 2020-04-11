package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.DepartmentDao;
import com.dms.oa.po.Department;

@Component
public class DepartmentService {
	
	@Resource
	private DepartmentDao departmentDao;
	
	public List<Department> getDepartment(){
		return departmentDao.selectAllDepartment();	
	}
	
	
	

}
