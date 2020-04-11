package com.dms.oa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.User;
import com.dms.oa.util.TimeUtil;

/**
 * Created on 2015锟�?2锟�?4锟�?by caiming
 */

/**
 * @Title 
 * @Description 
 * @Copyright <p>Copyright (c) 2015</p>
 * @Company <p>婧愭湰淇℃伅绉戞妧鏈夐檺鍏徃 Co., Ltd.</p>
 * @author caiming
 * @version 1.0
 * @淇敼璁板綍
 * @淇敼搴忓彿锛屼慨鏀规棩鏈燂紝淇敼浜猴紝淇敼鍐呭
 */
@Controller
@RequestMapping("/base")
public class BaseController {

	@RequestMapping("/yesorno.do")
	@ResponseBody
	public String yesOrno(HttpServletRequest request) throws Exception {
		System.out.println("yesOrno.do");
		String json="[{\"id\":\"0\",\"text\":\"否\"},{\"id\":\"1\",\"text\":\"是\"}]";
		return json;
	}
	
	@RequestMapping("/timeclass.do")
	@ResponseBody
	public String timeclass(HttpServletRequest request) throws Exception {
		System.out.println("timeclass.do");
		String json="[{\"id\":\"0\",\"text\":\"项目工时\"},{\"id\":\"1\",\"text\":\"管理工时\"}]";
		return json;
	}
	
	@RequestMapping("/completion.do")
	@ResponseBody
	public String completion(HttpServletRequest request) throws Exception {
		System.out.println("completion.do");
		//List<Map<String,Object>> list=new ArrayList();
		
		
		
		//JSONObject object=JSONObject.fromObject(users.get(0));
		String json="[{\"id\":\"5\",\"text\":\"5%\"},{\"id\":\"10\",\"text\":\"10%\"},"
				+ "{\"id\":\"15\",\"text\":\"15%\"},{\"id\":\"20\",\"text\":\"20%\"},"
				+ "{\"id\":\"25\",\"text\":\"25%\"},{\"id\":\"30\",\"text\":\"30%\"},"
				+ "{\"id\":\"35\",\"text\":\"35%\"},{\"id\":\"40\",\"text\":\"40%\"},"
				+ "{\"id\":\"45\",\"text\":\"45%\"},{\"id\":\"50\",\"text\":\"50%\"},"
				+ "{\"id\":\"55\",\"text\":\"55%\"},{\"id\":\"60\",\"text\":\"60%\"},"
				+ "{\"id\":\"65\",\"text\":\"65%\"},{\"id\":\"70\",\"text\":\"70%\"},"
				+ "{\"id\":\"75\",\"text\":\"75%\"},{\"id\":\"80\",\"text\":\"80%\"},"
				+ "{\"id\":\"85\",\"text\":\"85%\"},{\"id\":\"90\",\"text\":\"90%\"},"
				+ "{\"id\":\"95\",\"text\":\"95%\"},{\"id\":\"100\",\"text\":\"100%\"}"
				+ "]";
		return json;
	}
	
		
	@RequestMapping("/getThisWeek.do")
	@ResponseBody
	public String getThisWeek(HttpServletRequest request) throws Exception {
		System.out.println("getThisWeek.do");
		int thisweek=TimeUtil.getWeek(new Date());
		System.out.println("thisweek="+thisweek);
		String json="{\"thisweek\":\""+thisweek+"\"}";
		return json;
	}		
	@RequestMapping("/getsex.do")
	@ResponseBody
	public String getsex(HttpServletRequest request) throws Exception {
		System.out.println("getsex.do");
		String json="[{\"id\":\"0\",\"text\":\"男\"},{\"id\":\"1\",\"text\":\"女\"}]";
		return json;
	}
	
	@RequestMapping("/case.do")
	@ResponseBody
	public String getCase(HttpServletRequest request) throws Exception {
		System.out.println("getCase.do");
		String json="[{\"id\":\"1\",\"text\":\"加班\"},{\"id\":\"2\",\"text\":\"请假\"},{\"id\":\"2\",\"text\":\"延时\"},{\"id\":\"3\",\"text\":\"其它\"}]";
		return json;
	}
	
	@RequestMapping("/state.do")
	@ResponseBody
	public String state(HttpServletRequest request) throws Exception {
		System.out.println("state.do");
		String json="[{\"id\":\"0\",\"text\":\"未开始\"},{\"id\":\"1\",\"text\":\"进行中\"},{\"id\":\"2\",\"text\":\"已完成\"},{\"id\":\"3\",\"text\":\"暂停\"}]";
		return json;
	}
	
	@RequestMapping("/worktime.do")
	@ResponseBody
	public String worktime(HttpServletRequest request) throws Exception {
		System.out.println("worktime.do");
		String json="[{\"id\":\"0.5\",\"text\":\"0.5\"},{\"id\":\"1\",\"text\":\"1\"},{\"id\":\"1.5\",\"text\":\"1.5\"},"
				+ "{\"id\":\"2\",\"text\":\"2\"},{\"id\":\"2.5\",\"text\":\"2.5\"},"
				+ "{\"id\":\"3\",\"text\":\"3\"},{\"id\":\"3.5\",\"text\":\"3.5\"},"
				+ "{\"id\":\"4\",\"text\":\"4\"},{\"id\":\"4.5\",\"text\":\"4.5\"},"
				+ "{\"id\":\"5\",\"text\":\"5\"},{\"id\":\"5.5\",\"text\":\"5.5\"},"
				+ "{\"id\":\"6\",\"text\":\"6\"},{\"id\":\"6.5\",\"text\":\"6.5\"}]";
//		String json="[{\"id\":\"1\",\"text\":\"0.5\"},"
//				+ "{\"id\":\"2\",\"text\":\"1\"},"
//				+ "{\"id\":\"3\",\"text\":\"1.5\"},"
//				+ "{\"id\":\"4\",\"text\":\"2\"},"
//				+ "{\"id\":\"5\",\"text\":\"2.5\"},"
//				+ "{\"id\":\"6\",\"text\":\"3\",}"
//				+ "{\"id\":\"7\",\"text\":\"3.5\"},"
//				+ "{\"id\":\"8\",\"text\":\"4\"},"
//				+ "{\"id\":\"9\",\"text\":\"4.5\"},"
//				+ "{\"id\":\"10\",\"text\":\"5\"},"
//				+ "{\"id\":\"11\",\"text\":\"5.5\"},"
//				+ "{\"id\":\"12\",\"text\":\"6\"},"
//				+ "{\"id\":\"13\",\"text\":\"6.5\"},"
//				+ "{\"id\":\"14\",\"text\":\"7\"}"
//				+ "]";
		return json;
	}
	
	
	
	@RequestMapping("/getUserid.do")
	@ResponseBody
	public String getUserid(HttpServletRequest request) throws Exception {
		System.out.println("getUserid.do");
		HttpSession session = request.getSession();
		int userid=(Integer) session.getAttribute("userid");
		return "[{\"userid\":\""+userid+"\"}]";
	}
	
	@RequestMapping("/getUser.do")
	@ResponseBody
	public String getUser(HttpServletRequest request) throws Exception {
		System.out.println("getUser.do");
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		return "{\"realname\":\""+user.getRealname()+"\",\"username\":\""+user.getUsername()+"\"}";
	}
	
	@RequestMapping("/mainclass.do")
	@ResponseBody
	public String mainclass(HttpServletRequest request) throws Exception {
		System.out.println("mainclass.do");
		String json="[{\"id\":\"1\",\"text\":\"1技术开发类(预研)\"},{\"id\":\"2\",\"text\":\"2产品开发类\"},{\"id\":\"3\",\"text\":\"3工程与服务定制类\"},{\"id\":\"其它\",\"text\":\"其它\"}]";
		return json;
	}
	

	
	@RequestMapping("/subclass.do")
	@ResponseBody
	public String subclass(HttpServletRequest request) throws Exception {
		System.out.println("subclass.do");
		String json="[{\"id\":\"1\",\"text\":\"1.1可行性分析\"},{\"id\":\"2\",\"text\":\"1.2技术报告\"},{\"id\":\"3\",\"text\":\"1.3算法研究\"},"
				+ "{\"id\":\"4\",\"text\":\"1.4技术方案\"},{\"id\":\"5\",\"text\":\"1.5行业解决方案\"},{\"id\":\"6\",\"text\":\"1.6知识产权\"},"
				+ "{\"id\":\"7\",\"text\":\"2.1硬件开发\"},{\"id\":\"8\",\"text\":\"2.2接口开发\"},{\"id\":\"9\",\"text\":\"2.3应用服务\"},"
				+ "{\"id\":\"10\",\"text\":\"2.4平台开发\"},{\"id\":\"11\",\"text\":\"3.1工程订单项目\"},{\"id\":\"12\",\"text\":\"3.2服务订单项目\"},{\"id\":\"其它\",\"text\":\"其它\"}"
				+ "]";
		return json;
	}
	
	@RequestMapping("/projectsource.do")
	@ResponseBody
	public String projectsource(HttpServletRequest request) throws Exception {
		System.out.println("projectsource.do");
		String json="[{\"id\":\"1\",\"text\":\"总部指令型\"},{\"id\":\"2\",\"text\":\"产品开发类\"},{\"id\":\"3\",\"text\":\"自主立项型\"},{\"id\":\"其它\",\"text\":\"其它\"}]";
		return json;
	}
	
	
	
	
	@RequestMapping("/getPrivilege.do")
	@ResponseBody
	public String getPrivilege(HttpServletRequest request) throws Exception {
		System.out.println("getPrivilege.do");
		
		HttpSession session = request.getSession();
		int userid=(Integer) session.getAttribute("userid");
		String json="";
		if(userid==2){
			json="{\"result\":\"0\"}";
		}else{
			json="{\"result\":\"1\"}";
		}
		return json;
	}
	
	
}

