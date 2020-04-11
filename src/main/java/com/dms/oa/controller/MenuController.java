package com.dms.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.model.Menu;
import com.dms.oa.po.Resources;
import com.dms.oa.service.MenuService;




	@Controller
	//@RequestMapping("/demo")
	public class MenuController {
		@Resource
		private MenuService menuService;
		
		@RequestMapping("/getMenu.do")
		@ResponseBody
		public List<Menu> getTreeNode(HttpServletRequest request) throws Exception {
			System.out.println("getMenu.do");
			List<Menu> menus=new ArrayList<Menu>();
			
			
			HttpSession session  = request.getSession();
			List<Resources> resources=(List<Resources>) session.getAttribute("resources");
			//List<Resources> resources=menuService.getMenu();
			//System.out.println(resources.size());
			
			if(request.getParameter("id")==null||request.getParameter("id").equals("")){
				Menu menu1=new Menu();
				menu1.setPid(resources.get(0).getParentid()+"");
				menu1.setId(resources.get(0).getResourceid()+"");
				menu1.setText(resources.get(0).getRosoucename());
				menu1.setIconCls("aaaaa");
				menu1.setUrl(resources.get(0).getAddr());
				menu1.setState("closed");
				menus.add(menu1);
			}else{
				int resourceid=Integer.parseInt(request.getParameter("id"));
				for(int j=0;j<resources.size();j++){
					Menu menu=new Menu();
					if(resources.get(j).getParentid()==resourceid){
						System.out.println("Pid====:"+resources.get(j).getParentid()+"");
					menu.setPid(resources.get(j).getParentid()+"");
					menu.setId(resources.get(j).getResourceid()+"");
					menu.setText(resources.get(j).getRosoucename());
					menu.setIconCls("aaaaa");
					menu.setUrl(resources.get(j).getAddr());
					
					if(resources.get(j).getIsend()==0){
						menu.setState("closed");
					}else{
						menu.setState("open");
					}

					menus.add(menu);
					}
				}
				
			}

			
		//	for(int i=0;i<3;i++){
//		System.out.println("id="+request.getParameter("id"));
//		if(request.getParameter("id")==null||request.getParameter("id").equals("")){
//				Menu menu1=new Menu();
//				menu1.setPid("0");
//				menu1.setId("1");
//				menu1.setText("硬件工程部");
//				menu1.setIconCls("aaaaa");
//				menu1.setUrl("fdfdfd");
//				menu1.setState("closed");
//				menus.add(menu1);
//		}else if(request.getParameter("id").equals("1")){
//			System.out.println(1);
//			Menu menu2=new Menu();
//			menu2.setPid("1");
//			menu2.setId("2");
//			menu2.setText("单元测试");
//			menu2.setIconCls("aaaaa");
//			menu2.setUrl("fdfdfd");
//			menu2.setState("open");
//			menus.add(menu2);
//		}else{
//			System.out.println("last");
//		}
							
			return menus;
		}
		
		
	
	}
