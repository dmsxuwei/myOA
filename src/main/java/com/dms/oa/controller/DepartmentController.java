package com.dms.oa.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.Department;
import com.dms.oa.po.User;
import com.dms.oa.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Resource
	private DepartmentService departmentService;
	
	
/*	@RequestMapping("/tomine.do")
	//@ResponseBody
	public String tomine(HttpServletRequest request) throws Exception {
		System.out.println("tomine.do");
		return "mine/mine";
	}*/
	
	@RequestMapping("/department.do")
	@ResponseBody
	public String users(HttpServletRequest request) throws Exception {
		List<Department> departments=departmentService.getDepartment();
		StringBuilder sb=new StringBuilder();
		 sb.append("[");
		 
		for(int i=0;i<departments.size();i++){
			sb.append("{\"id\":"+"\""+departments.get(i).getId()+"\","
					  +"\"text\":"+"\""+departments.get(i).getName()+"\"}");
			if(i<departments.size()-1) sb.append(",");
		}
		 sb.append("]");
		//String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	

}
