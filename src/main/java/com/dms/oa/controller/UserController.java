package com.dms.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.Department;
import com.dms.oa.po.User;
import com.dms.oa.po.UserRole;
import com.dms.oa.service.DepartmentService;
import com.dms.oa.service.UserRoleService;
import com.dms.oa.service.UserService;
import com.dms.oa.util.StringUtil;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	@Resource
	private UserRoleService userroleService;
	@Resource
	private DepartmentService departmentService;
	
	
	@RequestMapping("/toUser.do")
	//@ResponseBody
	public String tologin(HttpServletRequest request) throws Exception {
		System.out.println("toUser.do");
		return "privilege/user";
	}
	
	@RequestMapping("/users.do")
	@ResponseBody
	public String users(HttpServletRequest request) throws Exception {
		List<User> users=userService.getUser();
		StringBuilder sb=new StringBuilder();
		 sb.append("[");
		 
		for(int i=0;i<users.size();i++){
			sb.append("{\"id\":"+"\""+users.get(i).getUserid()+"\","
					  +"\"text\":"+"\""+users.get(i).getRealname()+"\"}");
			if(i<users.size()-1) sb.append(",");
		}
		 sb.append("]");
		//String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	@RequestMapping("/getUser.do")
	@ResponseBody
	public String getUser(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		
		
	 List<User> users= userService.getUser();
	 System.out.println("getGrid.do"+users.size());
	 StringBuilder sb=new StringBuilder();
	 
	 //查出物料分类
	 Map departmentMap=new HashMap();
     List<Department> departments=departmentService.getDepartment();
     for(int i=0;i<departments.size();i++){
    	 departmentMap.put(departments.get(i).getId(), departments.get(i).getName());
     } 
	 
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<users.size();i++){
		 String result=null;
		 if(users.get(i).getSex()==null){
			 result="";  
		 }else if(users.get(i).getSex()==0){
				 result="男";
		 }else if(users.get(i).getSex()==1){
				 result="女";
		 }
	 sb.append("{\"username\":\""+users.get(i).getUsername()
			 	+"\",\"age\":\""+users.get(i).getAge()
			 	+"\",\"realname\":\""+users.get(i).getRealname()
			 	+"\",\"sex\":\""+result
			 	+"\",\"tel\":\""+users.get(i).getTel()
			 	+"\",\"mail\":\""+users.get(i).getMail()
			 	+"\",\"department\":\""+departmentMap.get(users.get(i).getDepartmentid())
			 	+"\",\"userid\":\""+users.get(i).getUserid()
			 	+"\"}");
	if(i<users.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
	@RequestMapping("/delUser.do")
	@ResponseBody
	public String delUnittest(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
	   int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
	 return "[{\"result\":\"OK\"}]";
	}	
	
	
	@RequestMapping("/UserAddRole.do")
	@ResponseBody
	public String UserAddRole(HttpServletRequest request) throws Exception {
	   String userids=request.getParameter("userids");
	   String roleids=request.getParameter("roleids");
	   System.out.println("userids:="+userids);
	   System.out.println("roleids:="+roleids);
	   List<Integer> useridlist=StringUtil.jsonToList(userids);
	   List<Integer> roleidlist=StringUtil.jsonToList(roleids);
	   
	   for(int i=0;i<useridlist.size();i++){
		   UserRole userrole=new UserRole();
		   userrole.setUserid(useridlist.get(i));
		   for(int j=0;j<roleidlist.size();j++){
			   userrole.setRoleid(roleidlist.get(j));
			   userroleService.insertUserRole(userrole);
		   }
	   }
	   
	   
	   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
	 return "[{\"result\":\"OK\"}]";
	}
	
	@RequestMapping("/UserRemoveRole.do")
	@ResponseBody
	public String UserRemoveRole(HttpServletRequest request) throws Exception {
	   String userids=request.getParameter("userids");
	   String roleids=request.getParameter("roleids");
	   System.out.println("userids:="+userids);
	   System.out.println("roleids:="+roleids);
	   List<Integer> useridlist=StringUtil.jsonToList(userids);
	   List<Integer> roleidlist=StringUtil.jsonToList(roleids);
	   
	   for(int i=0;i<useridlist.size();i++){
		   UserRole userrole=new UserRole();
		   userrole.setUserid(useridlist.get(i));
		   for(int j=0;j<roleidlist.size();j++){
			   userrole.setRoleid(roleidlist.get(j));
			   userroleService.deleteByExample(userrole.getUserid(), userrole.getRoleid());
		   }
	   }
	   
	   
	   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
	 return "[{\"result\":\"OK\"}]";
	}
	
	
	

}
