package com.dms.oa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.jdbc.Timetaskstatic;
import com.dms.oa.po.Log;
import com.dms.oa.po.Project;
import com.dms.oa.po.Resources;
import com.dms.oa.po.Role;
import com.dms.oa.po.RoleResource;
import com.dms.oa.po.User;
import com.dms.oa.po.UserRole;
import com.dms.oa.service.ProjectService;
import com.dms.oa.service.ResourceService;
import com.dms.oa.service.RoleResourceService;
import com.dms.oa.service.RoleService;
import com.dms.oa.service.UserRoleService;
import com.dms.oa.service.UserService;


@Controller
@RequestMapping("/report")
public class ReportController {
	@Resource
	private Timetaskstatic Timetaskstatic;
	@Resource
	private UserService userService;
	@Resource
	private ProjectService projectService;
	
	@RequestMapping("/toreport.do")
	public String toProject(HttpServletRequest request) throws Exception {
		System.out.println("toreport.do");
		return "report/report";
	}
	
	//搜索
	@RequestMapping("/Export.do")
	@ResponseBody
	public String Timetaskstatic(HttpServletRequest request) throws Exception {
		System.out.println("Export.do");
		String date=request.getParameter("date"); 
		List<Map<String, Object>> list=Timetaskstatic.getWorktimebyopertor(date,true);
		return "report/report";
	}
	
	
	//
	@RequestMapping("/opertortimestatic.do")
	@ResponseBody
	public String opertortimestatic(HttpServletRequest request) throws Exception {
		System.out.println("opertortimestatic.do");

	
		String page=request.getParameter("page");
		  //每页显示的记录数
		 String rows=request.getParameter("rows"); 
		  
		  String date=request.getParameter("date"); 
		  System.out.println("date====>>>>>>>>>>>>>>>>>>>>.>:"+date);
		  if(date.equals("")||date==null)return "";
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		
		  Map userMap=new HashMap();
		     List<User> users=userService.getUser();
		     for(int i=0;i<users.size();i++){
		    	 userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		   }
		     
			 Map projectMap=new HashMap();
		     List<Project> projects=projectService.getProject();
		     for(int i=0;i<projects.size();i++){
		    	 projectMap.put(projects.get(i).getProjectid(), projects.get(i).getProjectname());
		     }
		     

	 
	List<Map<String, Object>> list=Timetaskstatic.getWorktimebyopertor(date,false);
	 
	// int total=weekService.countByExample(projectid_search, userid_search, week_search);
	 StringBuilder sb=new StringBuilder();
	 System.out.println("size"+list.size());
	 sb.append("{\"total\":"+list.size()+",\"rows\":");
	 sb.append("[");
	 for(int i=0;i<list.size();i++){
	 sb.append("{\"week\":\""+"第"+list.get(i).get("projectname")+"周"
			 	+"\",\"projectname\":\""+list.get(i).get("projectname")
			 	+"\",\"realname\":\""+list.get(i).get("realname")
			 	+"\",\"usetime\":\""+list.get(i).get("usetime") 
			 	+"\"}");
	if(i<list.size()-1) sb.append(",");
	 }
	 sb.append("]}");

	return sb.toString();
	}

}
