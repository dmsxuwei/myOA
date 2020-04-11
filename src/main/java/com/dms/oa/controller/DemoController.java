package com.dms.oa.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.dao.UserDao;
import com.dms.oa.po.User;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {
	
	@Resource
	private UserDao userDao;


	@RequestMapping("/test.do")
	@ResponseBody
	public String test(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("a", 1);
		User user=userDao.selectByPrimaryKey(1);
		System.out.println(user.getUsername());
		System.out.println(request.getParameter("name")); 
		//pCItestService.selfCheck();
		return "[{\"key\",\"value\"}]";
	}
}

