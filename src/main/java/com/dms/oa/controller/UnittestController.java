package com.dms.oa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.Unittest;
import com.dms.oa.service.UnittestService;

@Controller
public class UnittestController {
	
	@Resource
	private UnittestService unittestService;
	
	
	@RequestMapping("/toUnittest.do")
	//@ResponseBody
	public String tologin(HttpServletRequest request) throws Exception {
		System.out.println("toUnittest.do");
		return "unittest";
	}
	
	@RequestMapping("/getUnittest.do")
	@ResponseBody
	public String getUnittest(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		
		
	 List<Unittest> unittests= unittestService.getUnittest(); 
	 System.out.println("getGrid.do"+unittests.size());
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<unittests.size();i++){
		 String result=null;
		 if("".equals(unittests.get(i).getResult())||unittests.get(i).getResult()==null){
			 result="不通过";
		 }else{
			 result="通过";
		 }
	 sb.append("{\"testproject\":\""+unittests.get(i).getTestproject()
			 	+"\",\"testunit\":\""+unittests.get(i).getTestunit()
			 	+"\",\"testtime\":\""+unittests.get(i).getTesttime()
			 	+"\",\"result\":\""+result
			 	+"\",\"user\":\""+unittests.get(i).getUsrid()
			 	+"\",\"bak\":\""+unittests.get(i).getBak()
			 	+"\",\"unittestid\":\""+unittests.get(i).getUnittestid()
			 	+"\"}");
	if(i<unittests.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
	@RequestMapping("/delUnittest.do")
	@ResponseBody
	public String delUnittest(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		
	int rs=unittestService.deleteByPrimaryKey(Integer.parseInt(id));
	return "[{\"result\":\"OK\"}]";
	}
	
	
	@RequestMapping("/result.do")
	@ResponseBody
	public String result(HttpServletRequest request) throws Exception {
		System.out.println("toUnittest.do");
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}
	
	@RequestMapping("/addunittest.do")
	@ResponseBody
	public String addunittest(HttpServletRequest request) throws Exception {
		System.out.println("addunittest.do");
		Unittest unittest=new Unittest();
		
		unittest.setUsrid(1);
		
		unittest.setTestproject(request.getParameter("testproject"));
		unittest.setTestunit(request.getParameter("testunit"));
		
		//System.out.println("testproject"+request.getParameter("testproject"));
		if("通过".equals(request.getParameter("result"))){
			unittest.setResult(1);
		}else if("不通过".equals(request.getParameter("result"))){
			unittest.setResult(0);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		String testtime=request.getParameter("testtime");
		System.out.println(testtime);
		Date date=new Date();
		date=sdf.parse(testtime);
		unittest.setTesttime(date);
		
		unittest.setBak(request.getParameter("bak"));
		
		
		unittestService.insertUnittest(unittest);
		
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}
	
	

}
