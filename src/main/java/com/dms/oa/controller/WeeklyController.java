package com.dms.oa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.base.Basedata;
import com.dms.oa.base.Excelopertion;
import com.dms.oa.po.Department;
import com.dms.oa.po.Log;
import com.dms.oa.po.Project;
import com.dms.oa.po.Task;
import com.dms.oa.po.Tasktime;
import com.dms.oa.po.User;
import com.dms.oa.service.DepartmentService;
import com.dms.oa.service.ProjectService;
import com.dms.oa.service.RollbackService;
import com.dms.oa.service.TaskService;
import com.dms.oa.service.TasktimeService;
import com.dms.oa.service.UserService;
import com.dms.oa.service.WeekService;
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
@RequestMapping("/weekly")
public class WeeklyController {
	
	@Resource
	private WeekService weekService;
	@Resource
	private UserService userService;
	@Resource
	private ProjectService projectService;
	@Resource
	private TaskService taskService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private TasktimeService tasktimeService;
	@Resource
	private RollbackService rollbackService;
	
	
	@RequestMapping("/toweekly.do")
	public String toweekly(HttpServletRequest request) throws Exception {
		System.out.println("toweekly.do");
		return "weekly/weekly";
	}

	
	@RequestMapping("/getWeekly.do")
	@ResponseBody
	public String getWeekly(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  String projectid_search=request.getParameter("projectid_search"); 
		  String userid_search=request.getParameter("userid_search"); 
		  String week_search=request.getParameter("week_search"); 
		  System.out.println("projectid_search===>:"+projectid_search);
		  System.out.println("userid_search===>:"+userid_search);
		  System.out.println("week_search===>:"+week_search);
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);
		
		  Map userMap=new HashMap();
		     List<User> users=userService.getUser();
		     for(int i=0;i<users.size();i++){
		    	 userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		   }
		     
			 Map projectMap=new HashMap();
		     List<Project> projects=projectService.getProject();
		     for(int i=0;i<projects.size();i++){
		    	 projectMap.put(projects.get(i).getProjectid(), projects.get(i).getProjectname());
		     }
			 Map taskMap=new HashMap();
		     List<Task> tasks=taskService.getAllTask();
		     for(int i=0;i<tasks.size();i++){
		    	 taskMap.put(tasks.get(i).getTaskid(), tasks.get(i).getTaskname());
		     }
		     
			 Map departmentMap=new HashMap();
		     List<Department> departments=departmentService.getDepartment();
		     for(int i=0;i<departments.size();i++){
		    	 departmentMap.put(departments.get(i).getId(), departments.get(i).getName());
		     }	
		     
	 List<Log> weeklys= weekService.queryByPage("", null, Integer.parseInt(page), 
			 Integer.parseInt(rows),projectid_search,userid_search,week_search,null).getList();
	 System.out.println("getGrid.do"+weeklys.size());
	 int total=weekService.countByExample(projectid_search, userid_search, week_search,null);
	 
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":"+total+",\"rows\":");
	 sb.append("[");
	 for(int i=0;i<weeklys.size();i++){
			Task currenttask = taskService.selectByPrimaryKey(weeklys.get(i)
					.getTaskid());
			Task task = taskService.selectByPrimaryKey(currenttask
					.getParentid());
			String taskname = "";
			if (task == null) {
				taskname = "";
			} else {
				taskname = task.getTaskname();
			}
			
	 sb.append("{\"week\":\""+"第"+weeklys.get(i).getWeek()+"周"
			 	+"\",\"recordtime\":\""+weeklys.get(i).getRecordtime()
			 	+"\",\"content\":\""+weeklys.get(i).getContent()
			 	+"\",\"opertor\":\""+weeklys.get(i).getOpertor()+","+userMap.get(weeklys.get(i).getOpertor())
			 	+"\",\"id\":\""+weeklys.get(i).getId()
			 	+"\",\"projectid\":\""+projectMap.get(weeklys.get(i).getProjectid()) 
			 	+"\",\"taskid\":\""+weeklys.get(i).getTaskid()+","+taskMap.get(weeklys.get(i).getTaskid())
			 	+"\",\"usetime\":\""+weeklys.get(i).getUsetime()
			 	+"\",\"weekday\":\""+TimeUtil.getWeekOfDate(weeklys.get(i).getRecordtime())
	/*		 	+"\",\"department\":\""+departmentMap.get(weeklys.get(i).getDepartmentid())*/
			 	+"\",\"completion\":\""+weeklys.get(i).getCompletion()+"%"
			/* 	+"\",\"timeclass\":\""+Basedata.getTimeclass(weeklys.get(i).getTimeclass())*/
			 	+ "\",\"taskname\":\"" + taskname + "\"}");
	if(i<weeklys.size()-1) sb.append(",");
	 }
	 sb.append("]}");

	return sb.toString();
	}
	
	
	//搜索
	@RequestMapping("/Export.do")
	@ResponseBody
	public String Timetaskstatic(HttpServletRequest request) throws Exception {
		System.out.println("Export.do");
		String projectid_search=request.getParameter("projectid_search"); 
		String userid_search=request.getParameter("userid_search"); 
		String week_search=request.getParameter("week_search"); 
		 String department_search=request.getParameter("department_search");
		  System.out.println("projectid_search===>:"+projectid_search);
		  System.out.println("userid_search===>:"+userid_search);
		  System.out.println("week_search===>:"+week_search);
		  System.out.println("department_search===>:"+department_search);
		  
		  Map userMap=new HashMap();
		     List<User> users=userService.getUser();
		     for(int i=0;i<users.size();i++){
		    	 userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		   }
		     
			 Map projectMap=new HashMap();
		     List<Project> projects=projectService.getProject();
		     for(int i=0;i<projects.size();i++){
		    	 projectMap.put(projects.get(i).getProjectid(), projects.get(i).getProjectname());
		     }
		     
			 Map taskMap=new HashMap();
		     List<Task> tasks=taskService.getAllTask();
		     for(int i=0;i<tasks.size();i++){
		    	 taskMap.put(tasks.get(i).getTaskid(), tasks.get(i).getTaskname());
		     }

		  
		  List<Log> weeklys= weekService.selectWeekly(projectid_search, userid_search, week_search,department_search);
		  List<List<String>> list=new ArrayList();
		  for(int i=0;i<weeklys.size();i++){
			  
				Task currenttask = taskService.selectByPrimaryKey(weeklys.get(i)
						.getTaskid());
				Task task = taskService.selectByPrimaryKey(currenttask
						.getParentid());
				String taskname = "";
				if (task == null) {
					taskname = "";
				} else {
					taskname = task.getTaskname();
				}
				
			  List<String> strlist=new ArrayList();
			  strlist.add(projectMap.get(weeklys.get(i).getProjectid())+"");//项目名称
			  strlist.add("第"+weeklys.get(i).getWeek()+"周");//第几周
			  strlist.add(TimeUtil.getWeekOfDate(weeklys.get(i).getRecordtime()));//星期几
			  strlist.add(taskname);//父任务名称
			  strlist.add(taskMap.get(weeklys.get(i).getTaskid())+"");//任务名称
			  strlist.add(weeklys.get(i).getContent());//内容
			  strlist.add(weeklys.get(i).getUsetime()+"");//用时
			  strlist.add(weeklys.get(i).getCompletion()+"%");//用时
			  strlist.add(weeklys.get(i).getRecordtime().toString());//记录时间
			  strlist.add(userMap.get(weeklys.get(i).getOpertor())+"");//负责人
			  list.add(strlist);
		  }
		  
		  
		  String[] title = { "项目名称","第几周","星期几","父任务", "任务名称","内容", "用时","完成度","记录时间","负责人" };
		  Excelopertion.excelWritebyList(request.getSession().getServletContext().getRealPath("")   +"/report/report.xls",list,title);
		  
		return "report/report";
	}
	
	
	@RequestMapping("/dellog.do")
	@ResponseBody
	public String dellog(HttpServletRequest request) throws Exception {
		System.out.println("dellog");
		String taskid = null;
		int opertor = 0;
		int id = 0;
		Float usetime = null;
		String completion = null;
		try {
			taskid = request.getParameter("taskid").split(",")[0];
			opertor = Integer.parseInt(request.getParameter("opertor").split(",")[0]);
			id = Integer.parseInt(request.getParameter("id"));
			usetime = Float.parseFloat(request.getParameter("usetime"));
			completion = request.getParameter("completion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "[{\"result\":\"ERROR\"}]";
		}
		
		System.out.println("id:"+id);
		System.out.println("taskid:"+taskid);
		System.out.println("opertor"+opertor);
		System.out.println("usetime:"+usetime);
		System.out.println("completion:"+completion);
		
		rollbackService.deleteWeekly(id);
		
/*		weekService.deleteByPrimaryKey(id);
		
		
		taskService.recordTime(Integer.parseInt(taskid), usetime-2*usetime, Integer.parseInt(completion.replace("%", "")));
		
		tasktimeService.selectByUser(opertor);
		Tasktime tasktime=tasktimeService.selectByUser(opertor);
		tasktime.setTime(tasktime.getTime()+usetime);
		tasktimeService.updateTasktime(tasktime);*/
		
		
	//int rs=projectService.deleteByPrimaryKey(Integer.parseInt(id));
	return "[{\"result\":\"OK\"}]";
	}	
	
	
}

