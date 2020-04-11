package com.dms.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.Task;
import com.dms.oa.service.TaskService;

@Controller
@RequestMapping("/analysis")
public class AnalysisController {
	@Resource
	private TaskService taskService;
	
	
	@RequestMapping("/toProjectAnalysis.do")
	//@ResponseBody
	public String tomine(HttpServletRequest request) throws Exception {
		System.out.println("toProjectAnalysis.do");
		return "projectAnalysis/projectAnalysis";
	}
	
	@RequestMapping("/getProjectProgress.do")
	@ResponseBody
	public String getProjectProgress(HttpServletRequest request) throws Exception {
		Map<String,Integer> projectprogress=new HashMap<String,Integer>();
		StringBuilder sb=new StringBuilder();
		
		
		sb.append("[");

		
		
		
		List<Task> tasks=taskService.getTask("1", null, null, null, "0");//查出项目下主任务
		for(int i=0;i<tasks.size();i++){
			List<Task> taskss=taskService.getTask("1", null, null, null, tasks.get(i).getTaskid()+"");//查出项目下主任务
			int completion=0;
			for(int j=0;j<taskss.size();j++){
				if(taskss.get(j).getCompletion()==null){
					
				}else{
					completion+=taskss.get(j).getCompletion();
				}
				
			}
			projectprogress.put(tasks.get(i).getTaskname(), completion);
			
		sb.append("{\"taskname\":\""+tasks.get(i).getTaskname()
				 	+"\",\"value\":\""+completion+""
				 	+"\"}");
		if(i<tasks.size()-1) sb.append(",");
		}
		
		 sb.append("]");
		
		
		String json="[{\"id\":\"0\",\"text\":\"否\"},{\"id\":\"1\",\"text\":\"是\"}]";
		json="[{\"project\": \"蓝牙key\",\"value\": 260},{\"project\": \"M2M\",\"value\": 201}]";
		json="[{\"country\": \"USA\",\"visits\": 4025}, {\"country\": \"China\",\"visits\": 1882}]";
		
		
		
		return sb.toString();
	}

}
