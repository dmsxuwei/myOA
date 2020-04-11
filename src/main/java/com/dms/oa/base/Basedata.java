package com.dms.oa.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class Basedata {
	
	public static Map stateMap=new HashMap();
	
	static {
		stateMap.put(0, "未开始");
		stateMap.put(1, "进行中");
		stateMap.put(2, "已完成");
		stateMap.put(3, "暂停中");
	}
	
	public static float daytime=(float)6.5;


	public static String getMainclass(int mainclassid){
		Map<Integer,String> map =new HashMap();
		map.put(1, "技术开发类(预研)");
		map.put(2, "产品开发类");
		map.put(3, "工程与服务定制类");
		return map.get(mainclassid);
	}
	
	public static String getTimeclass(int timeclassid){
		Map<Integer,String> map =new HashMap();
		map.put(0, "项目工时");
		map.put(1, "管理工时");
		return map.get(timeclassid);
	}	
	
	public static String getSubclass(int subclassid){
		Map<Integer,String> map =new HashMap();
		map.put(1, "可行性分析");
		map.put(2, "技术报告");
		map.put(3, "算法研究");
		map.put(4, "技术方案");
		map.put(5, "行业解决方案");
		map.put(6, "知识产权");
		map.put(7, "硬件开发");
		map.put(8, "接口开发");
		map.put(9, "应用服务");
		map.put(10, "平台开发");
		map.put(11, "工程订单项目");
		map.put(12, "服务订单项目");
		return map.get(subclassid);
	}
	
	public static String getProjectsource(int sourceid){
		Map<Integer,String> map =new HashMap();
		map.put(1, "总部指令型");
		map.put(2, "产品开发类");
		map.put(3, "自主立项型");
		return map.get(sourceid);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
