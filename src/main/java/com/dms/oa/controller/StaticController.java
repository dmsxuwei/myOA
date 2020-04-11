package com.dms.oa.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.jdbc.Timetaskstatic;

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
@RequestMapping("/static")
public class StaticController {
	@Resource
	private Timetaskstatic Timetaskstatic;
	
	@RequestMapping("/getProjectTimeProportion.do")
	@ResponseBody
	public String getProjectTimeProportion(HttpServletRequest request) throws Exception {
		System.out.println("getProjectTimeProportion.do");
		List<Map<String, Object>> list=Timetaskstatic.getProjectTimeProportion("");
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(int i=0;i<list.size();i++){
			sb.append("{\"project\":\""+list.get(i).get("projectname")
				 	+"\",\"value\":\""+list.get(i).get("alltime")
				 	+"\"}");
		if(i<list.size()-1) sb.append(",");
		}
		 sb.append("]");
		String json="[{\"id\":\"0\",\"text\":\"否\"},{\"id\":\"1\",\"text\":\"是\"}]";
		json="[{\"project\": \"蓝牙key\",\"value\": 260},{\"project\": \"M2M\",\"value\": 201}]";
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	
}

