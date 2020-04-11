package com.dms.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.Resources;
import com.dms.oa.po.Role;
import com.dms.oa.po.RoleResource;
import com.dms.oa.po.UserRole;
import com.dms.oa.service.ResourceService;
import com.dms.oa.service.RoleResourceService;
import com.dms.oa.service.UserRoleService;

@Controller
public class ResourcesController {
	
	@Resource
	private ResourceService resourceService;
	@Resource
	private RoleResourceService roleResourceService;
	
	
	@RequestMapping("/toResources.do")
	public String tologin(HttpServletRequest request) throws Exception {
		System.out.println("toResources.do");
		return "privilege/resources";
	}
	
	
	@RequestMapping("/getResources.do")
	@ResponseBody
	public String getUnittest(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		
		
	 List<Resources> resources= resourceService.getResource();
	 System.out.println("getGrid.do"+resources.size());
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<resources.size();i++){
	 sb.append("{\"resourceid\":\""+resources.get(i).getResourceid()
			 	+"\",\"resoucename\":\""+resources.get(i).getRosoucename()
			 	+"\",\"addr\":\""+resources.get(i).getAddr()
			 	+"\",\"parentid\":\""+resources.get(i).getParentid()
			 	+"\"}");
	if(i<resources.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	@RequestMapping("/getAddResources.do")
	@ResponseBody
	public String getAddResources(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
	
		  String roleid=request.getParameter("roleid");
		  System.out.println("roleid====="+roleid);
		  //根据用户ID查出所有角色
		  List<RoleResource> roleresources =roleResourceService.selectRolesByRoleid(Integer.parseInt(roleid));
				  
			 List<Resources> resources= resourceService.getResource();
			 System.out.println("getGrid.do"+resources.size());
			 
			 List<Resources> haveresources=new ArrayList<Resources>();
			 for(int i=0;i<resources.size();i++){
				 int resourceid=resources.get(i).getResourceid();
				 for(int j=0;j<roleresources.size();j++){
					 if(resourceid==roleresources.get(j).getResourceid()){//&&!"".equals(resources.get(i).getAddr())
						 haveresources.add(resources.get(i));
						 System.out.println("+++++++++++++++++++++"+i);
					 }
				 }
				 
			 }	  
		  
	 System.out.println("getGrid.do"+haveresources.size());
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<haveresources.size();i++){
	 sb.append("{\"resourceid\":\""+haveresources.get(i).getResourceid()
			 	+"\",\"resoucename\":\""+haveresources.get(i).getRosoucename()
			 	+"\",\"addr\":\""+haveresources.get(i).getAddr()
			 	+"\",\"parentid\":\""+haveresources.get(i).getParentid()
			 	+"\"}");
	if(i<haveresources.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
	@RequestMapping("/getremoveResources.do")
	@ResponseBody
	public String getremoveResources(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
	
		  String roleid=request.getParameter("roleid");
		  System.out.println("roleid====="+roleid);
		  //根据用户ID查出所有角色
		  List<RoleResource> roleresources =roleResourceService.selectRolesByRoleid(Integer.parseInt(roleid));
				  
			 List<Resources> resources= resourceService.getResource();
			 System.out.println("getGrid.do"+resources.size());
			 
			 List<Resources> haveresources=new ArrayList<Resources>();
			 for(int i=0;i<resources.size();i++){
				 int resourceid=resources.get(i).getResourceid();
				 for(int j=0;j<roleresources.size();j++){
					 if(resourceid==roleresources.get(j).getResourceid()){//||"".equals(resources.get(i).getAddr())
						 haveresources.add(resources.get(i));
						 System.out.println("+++++++++++++++++++++"+i);
					 }
				 }
				 
			 }	  
			 resources.removeAll(haveresources);  
	 System.out.println("getGrid.do"+resources.size());
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<resources.size();i++){
	 sb.append("{\"resourceid\":\""+resources.get(i).getResourceid()
			 	+"\",\"resoucename\":\""+resources.get(i).getRosoucename()
			 	+"\",\"addr\":\""+resources.get(i).getAddr()
			 	+"\",\"parentid\":\""+resources.get(i).getParentid()
			 	+"\"}");
	if(i<resources.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
	
	@RequestMapping("/delResources.do")
	@ResponseBody
	public String delResources(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		
		int rs=resourceService.deleteByPrimaryKey(Integer.parseInt(id));
		return "[{\"result\":\"OK\"}]";
	}
	

	
	@RequestMapping("/addResource.do")
	@ResponseBody
	public String addunittest(HttpServletRequest request) throws Exception {
		System.out.println("addResource.do");
		Resources resources=new Resources();
		resources.setResourceid(14);
		resources.setRosoucename(request.getParameter("rosoucename"));
		resources.setAddr(request.getParameter("addr"));
		resources.setParentid(Integer.parseInt(request.getParameter("parentid")));
		resources.setIsend(Integer.parseInt(request.getParameter("isend")));
		resourceService.insertResources(resources);
		
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}
	
	

}
