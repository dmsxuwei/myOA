package com.dms.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dms.oa.jdbc.Timetaskstatic;
import com.dms.oa.po.Resources;
import com.dms.oa.po.Role;
import com.dms.oa.po.RoleResource;
import com.dms.oa.po.User;
import com.dms.oa.po.UserRole;
import com.dms.oa.service.ResourceService;
import com.dms.oa.service.RoleResourceService;
import com.dms.oa.service.RoleService;
import com.dms.oa.service.UserRoleService;
import com.dms.oa.service.UserService;


@Controller
//@RequestMapping("/demo")
public class Login {
	
	@Resource
	private UserService userService;
	
	@Resource
	private UserRoleService userRoleService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private RoleResourceService roleresourceService;
	
	@Resource
	private ResourceService resourceService;
	
	@Resource
	private Timetaskstatic timetaskstatic;
	
	@Resource
	private UserRoleService userroleService;
	
	@RequestMapping("/tologin.do")
	//@ResponseBody
	public String tologin(HttpServletRequest request) throws Exception {
			return "login";
	}
	
	@RequestMapping("/toRegister.do")
	//@ResponseBody
	public String toRegister(HttpServletRequest request) throws Exception {
			return "register";
	}
	
	@RequestMapping("/login.do")
	//@ResponseBody
	public String login(HttpServletRequest request) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		if("".equals(username)||username==null||"".equals(password)||password==null){
			return "login";
		}
		List<User> users=userService.selectByUsername(username);
		if(users.size()!=1)return "login";
		System.out.println(users.get(0).getPassword());
		
		if(password.equals(users.get(0).getPassword())){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userid", users.get(0).getUserid());
			session.setAttribute("user", users.get(0));
			
			//根据USERID查出所有角色
			List<UserRole> userroles=userRoleService.selectRolesByUserid(users.get(0).getUserid());
			List<Integer> roleids=new ArrayList();
			for(int i=0;i<userroles.size();i++){
				roleids.add(new Integer(userroles.get(i).getRoleid()));
			}
			List<Role> roles =roleService.selectByRoleidIn(roleids);
			
			//根据所有角色找到rolesources
			List<RoleResource> roleresources=new ArrayList();
			for(int i=0;i<roles.size();i++){
				List<RoleResource> roleresource=roleresourceService.selectRolesByRoleid(roles.get(i).getRoleid());
				roleresources.addAll(roleresource);
			}
			
			
			//根据rolesources总集合找出所有Resources.
			List<Integer> resourcesids=new ArrayList();
			for(int i=0;i<roleresources.size();i++){
				resourcesids.add(new Integer(roleresources.get(i).getResourceid()));
			}			
			List<Resources> resources=resourceService.selectByResourceidIn(resourcesids);
			
			//循环资源
			for(int i=0;i<resources.size();i++){
				//System.out.println(resources.get(i).getRosoucename());
			}
			
			session.setAttribute("resources", resources);
		
			
			
			System.out.println("登陆成功！");
			return "index";
		}else{
			return "login";
		}

	}

	
	@RequestMapping("/loginout.do")
	//@ResponseBody
	public String loginout(HttpServletRequest request) throws Exception {
			HttpSession session = request.getSession();
			session.removeAttribute("username");
			session.removeAttribute("userid");
			//session.setAttribute("username", "xuwei");
			//session.setAttribute("userid", users.get(0).getUserid());
			return "login";
	}
	
	@RequestMapping("/register.do")
	//@ResponseBody
	public String register(HttpServletRequest request) throws Exception {
		if(!request.getParameter("username").equals("")){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//String realname=request.getParameter("realname");
			//System.out.println(realname);
			User user =new User();
			user.setUsername(username);
			//user.setRealname(realname);
			user.setPassword(password);
			int r=userService.insertUser(user);
			List<User> users=userService.selectByUsername(user.getUsername());
			
			UserRole userrole=new UserRole();
			userrole.setUserid(users.get(0).getUserid());
		    userrole.setRoleid(2);
		    userroleService.insertUserRole(userrole);

			
			return "login";
		}else{
			return "register";
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
