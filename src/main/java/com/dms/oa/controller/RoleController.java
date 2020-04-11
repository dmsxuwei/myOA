package com.dms.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.Role;
import com.dms.oa.po.RoleResource;
import com.dms.oa.po.UserRole;
import com.dms.oa.service.RoleResourceService;
import com.dms.oa.service.RoleService;
import com.dms.oa.service.UserRoleService;
import com.dms.oa.util.StringUtil;

@Controller
public class RoleController {
	
	@Resource
	private RoleService roleService;
	@Resource
	private UserRoleService userRoleService;
	
	@Resource
	private RoleResourceService roleResourceService;
	
	@RequestMapping("/toRole.do")
	public String tologin(HttpServletRequest request) throws Exception {
		System.out.println("toRole.do");
		return "privilege/role";
	}
	
	
	@RequestMapping("/getRole.do")
	@ResponseBody
	public String getUnittest(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		
	 List<Role> roles= roleService.getRole();
	 System.out.println("getGrid.do"+roles.size());
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<roles.size();i++){
	 sb.append("{\"rolename\":\""+roles.get(i).getRolename()
			 	+"\",\"roleid\":\""+roles.get(i).getRoleid()
			 	+"\"}");
	if(i<roles.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
/*	@RequestMapping("/delRole.do")
	@ResponseBody
	public String delRole(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		
	int rs=roleService.deleteByPrimaryKey(Integer.parseInt(id));
		return "[{\"result\":\"OK\"}]";
	}
	*/
	
	//返回用户下已有的角色
	@RequestMapping("/getHavedRole.do")
	@ResponseBody
	public String getHavedRole(HttpServletRequest request) throws Exception {
		System.out.println("getHavedRole");
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		  
		  String userid=request.getParameter("userid");
		  System.out.println("userid====="+userid);
	
		  //根据用户ID查出所有角色
	 List<UserRole> userroles =userRoleService.selectRolesByUserid(Integer.parseInt(userid));
		  
	 List<Role> roles= roleService.getRole();
	 System.out.println("getGrid.do"+roles.size());
	 
	 List<Role> haveroles=new ArrayList<Role>();
	 for(int i=0;i<roles.size();i++){
		 int roleid=roles.get(i).getRoleid();
		 for(int j=0;j<userroles.size();j++){
			 if(roleid==userroles.get(j).getRoleid()){
				 haveroles.add(roles.get(i));
				 System.out.println("+++++++++++++++++++++"+i);
			 }
		 }
		 
	 }
	 
	 
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<haveroles.size();i++){
	 sb.append("{\"rolename\":\""+haveroles.get(i).getRolename()
			 	+"\",\"roleid\":\""+haveroles.get(i).getRoleid()
			 	+"\"}");
	if(i<haveroles.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
	
	//返回用户下已有的角色
	@RequestMapping("/getNoHavedRole.do")
	@ResponseBody
	public String getNoHavedRole(HttpServletRequest request) throws Exception {
		System.out.println("getNoHavedRole");
		String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		  
		  String userid=request.getParameter("userid");
		  System.out.println("userid====="+userid);
	
		  //根据用户ID查出所有角色
	 List<UserRole> userroles =userRoleService.selectRolesByUserid(Integer.parseInt(userid));
		  
	 List<Role> roles= roleService.getRole();
	 System.out.println("getGrid.do"+roles.size());
	 
	 List<Role> haveroles=new ArrayList<Role>();
	 for(int i=0;i<roles.size();i++){
		 int roleid=roles.get(i).getRoleid();
		 for(int j=0;j<userroles.size();j++){
			 if(roleid==userroles.get(j).getRoleid()){
				 haveroles.add(roles.get(i));
				 System.out.println("------------------"+i);
			 }
		 }
		 
	 }
	 
	 roles.removeAll(haveroles);
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<roles.size();i++){
	 sb.append("{\"rolename\":\""+roles.get(i).getRolename()
			 	+"\",\"roleid\":\""+roles.get(i).getRoleid()
			 	+"\"}");
	if(i<roles.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	@RequestMapping("/delRole.do")
	@ResponseBody
	public String delUnittest(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		
	int rs=roleService.deleteByPrimaryKey(Integer.parseInt(id));
		return "[{\"result\":\"OK\"}]";
	}
	

	
	@RequestMapping("/addRole.do")
	@ResponseBody
	public String addunittest(HttpServletRequest request) throws Exception {
		System.out.println("addunittest.do");
		Role role=new Role();
		role.setRolename(request.getParameter("rolename"));
		roleService.insertRole(role);
		
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}
	
	
	@RequestMapping("/RoleAddResource.do")
	@ResponseBody
	public String RoleAddResource(HttpServletRequest request) throws Exception {
	   String roleids=request.getParameter("roleids");
	   String resourceids=request.getParameter("resourceids");
	   System.out.println("roleids:="+roleids);
	   System.out.println("resourceids:="+resourceids);
	   
	   List<Integer> roleidlist=StringUtil.jsonToList(roleids);
	   List<Integer> resourceidlist=StringUtil.jsonToList(resourceids);
	   
	   for(int i=0;i<roleidlist.size();i++){
		   RoleResource roleresource=new RoleResource();
		   roleresource.setRoleid(roleidlist.get(i));
		   for(int j=0;j<resourceidlist.size();j++){
			   roleresource.setResourceid(resourceidlist.get(j));
			   roleResourceService.insertRoleResource(roleresource);
		   }
	   }
	   
	   
	   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
	 return "[{\"result\":\"OK\"}]";
	}
	
	
	
	@RequestMapping("/RoleRemoveResource.do")
	@ResponseBody
	public String RoleRemoveResource(HttpServletRequest request) throws Exception {
		   String roleids=request.getParameter("roleids");
		   String resourceids=request.getParameter("resourceids");
		   System.out.println("roleids:="+roleids);
		   System.out.println("resourceids:="+resourceids);
		   
		   List<Integer> roleidlist=StringUtil.jsonToList(roleids);
		   List<Integer> resourceidlist=StringUtil.jsonToList(resourceids);
		   
		   for(int i=0;i<roleidlist.size();i++){
			   RoleResource roleresource=new RoleResource();
			   roleresource.setRoleid(roleidlist.get(i));
			   for(int j=0;j<resourceidlist.size();j++){
				   roleresource.setResourceid(resourceidlist.get(j));
				   roleResourceService.deleteByExample(roleresource.getRoleid(), roleresource.getResourceid());
			   }
		   }
		   
		   
		   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
		 return "[{\"result\":\"OK\"}]";
	}
		
	
	
	

}
