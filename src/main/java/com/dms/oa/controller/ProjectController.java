package com.dms.oa.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
import com.dms.oa.po.Log;
import com.dms.oa.po.Project;
import com.dms.oa.po.Projectmembers;
import com.dms.oa.po.Role;
import com.dms.oa.po.Task;
import com.dms.oa.po.Taskmembers;
import com.dms.oa.po.Tasktime;
import com.dms.oa.po.Timeupdate;
import com.dms.oa.po.User;
import com.dms.oa.po.UserRole;
import com.dms.oa.service.LogService;
import com.dms.oa.service.ProjectService;
import com.dms.oa.service.ProjectUserService;
import com.dms.oa.service.RollbackService;
import com.dms.oa.service.TaskService;
import com.dms.oa.service.TaskUserService;
import com.dms.oa.service.TasktimeService;
import com.dms.oa.service.TimeupdateService;
import com.dms.oa.service.UserService;
import com.dms.oa.service.WeekService;
import com.dms.oa.util.StringUtil;
import com.dms.oa.util.TimeUtil;

@Controller
public class ProjectController {
	
	@Resource
	private ProjectService projectService;
	@Resource
	private TaskService taskService;
	@Resource
	private UserService userService;
	@Resource
	private TasktimeService tasktimeService;
	@Resource
	private TimeupdateService timeupdateService;
	
	@Resource
	private LogService logservice;
	@Resource
	private ProjectUserService projectUserService;
	
	@Resource
	private TaskUserService taskUserService;
	
	@Resource
	private WeekService weekservice;
	@Resource
	private RollbackService rollbackService;
	
	@RequestMapping("/toProject.do")
	//@ResponseBody
	public String toProject(HttpServletRequest request) throws Exception {
		System.out.println("toProject.do");
		return "project/project";
	}
	
	
	@RequestMapping("/projects.do")
	@ResponseBody
	public String projects(HttpServletRequest request) throws Exception {
		List<Project> projects=projectService.getProject();
		StringBuilder sb=new StringBuilder();
		 sb.append("[");
		 
		for(int i=0;i<projects.size();i++){
			sb.append("{\"id\":"+"\""+projects.get(i).getProjectid()+"\","
					  +"\"text\":"+"\""+projects.get(i).getProjectname()+"\"}");
			if(i<projects.size()-1) sb.append(",");
		}
		 sb.append("]");
		//String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	@RequestMapping("/getProjectsByUser.do")
	@ResponseBody
	public String getProjectsByUser(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		List<Project> projects=projectService.getProject();
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0;i<projects.size();i++){
			map.put(projects.get(i).getProjectid().toString(), projects.get(i).getProjectname());
		}
		
		List<Projectmembers> projectmembers=projectUserService.selectByUserid(Integer.parseInt(session.getAttribute("userid")+""));
		
		List<Project> newprojects=new ArrayList<Project>();	
		for(int i=0;i<projectmembers.size();i++){
			Project project=new Project();
			project.setProjectid(projectmembers.get(i).getProjectid());
			project.setProjectname(map.get(projectmembers.get(i).getProjectid().toString()));
			newprojects.add(project);
		}
		
		
		StringBuilder sb=new StringBuilder();
		 sb.append("[");
		for(int i=0;i<newprojects.size();i++){
			sb.append("{\"id\":"+"\""+newprojects.get(i).getProjectid()+"\","
					  +"\"text\":"+"\""+newprojects.get(i).getProjectname()+"\"}");
			if(i<newprojects.size()-1) sb.append(",");
		}
		 sb.append("]");
		//String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		System.out.println(sb.toString());
		return sb.toString();
	}	
	
	
	@RequestMapping("/getProject.do")
	@ResponseBody
	public String getProject(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);

			 //查出物料分类
			 Map userMap=new HashMap();
		     List<User> users=userService.getUser();
		     for(int i=0;i<users.size();i++){
		    	 userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		     }		
		
	 List<Project> projects= projectService.queryByPage(Integer.parseInt(page), Integer.parseInt(rows)).getList();
	 
	 System.out.println("getProject.do"+projects.size());
	 int total=projectService.countByExample();
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":"+total+",\"rows\":");
	 sb.append("[");
	 for(int i=0;i<projects.size();i++){

	 sb.append("{\"projectid\":\""+projects.get(i).getProjectid()
			 	+"\",\"userid\":\""+userMap.get(projects.get(i).getUserid())
			 	+"\",\"projectname\":\""+projects.get(i).getProjectname()
			 	+"\",\"projectdescripton\":\""+projects.get(i).getProjectdescripton()
			 	+"\",\"projectstate\":\""+Basedata.stateMap.get(projects.get(i).getProjectstate())
			 	+"\",\"createtime\":\""+projects.get(i).getCreatetime()
			 	+"\",\"begintime\":\""+projects.get(i).getBegintime()
	/*		 	+"\",\"num\":\""+projects.get(i).getNum()
			 	+"\",\"mainclass\":\""+Basedata.getMainclass(projects.get(i).getMainclass())
			 	+"\",\"subclass\":\""+Basedata.getSubclass(projects.get(i).getSubclass())
			 	+"\",\"projectsource\":\""+Basedata.getProjectsource(projects.get(i).getProjectsource())*/
			 	
			 	+"\"}");
	if(i<projects.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
	@RequestMapping("/delProject.do")
	@ResponseBody
	public String delProject(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		
	int rs=rollbackService.deleteProject(Integer.parseInt(id));
	return "[{\"result\":\"OK\"}]";
	}
	
	
	
	
	@RequestMapping("/addproject.do")
	@ResponseBody
	public String addproject(HttpServletRequest request) throws Exception {
		System.out.println("addproject.do");
		Project project=new Project();
		
		project.setUserid(Integer.parseInt(request.getParameter("userid")));
		project.setProjectname(request.getParameter("projectname"));
		project.setProjectdescripton(request.getParameter("projectdescripton"));
		project.setProjectstate(0);
		

		/*project.setNum(request.getParameter("projectcode"));
		project.setMainclass(Integer.parseInt(request.getParameter("mainclass")));
		project.setSubclass(Integer.parseInt(request.getParameter("subclass")));
		project.setProjectsource(Integer.parseInt(request.getParameter("projectsource")));*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		String createtime=request.getParameter("createtime");
		System.out.println(createtime);
		Date createdate=new Date();
		createdate=sdf.parse(createtime);
		project.setCreatetime(createdate);
		
		String begintime=request.getParameter("begintime");
		System.out.println(begintime);
		Date begindate=new Date();
		begindate=sdf.parse(begintime);
		project.setBegintime(begindate);
		
		
		projectService.insertProject(project);
		
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}

	
	
	
	
//任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理任务管理
	
	@RequestMapping("/toTask.do")
	//@ResponseBody
	public String toTask(HttpServletRequest request) throws Exception {
		System.out.println("toTask.do");
		return "project/task";
	}
	
	
	@RequestMapping("/getTask.do")
	@ResponseBody
	public String getTask(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  String projectid_search=request.getParameter("projectid_search"); 
		  String userid_search=request.getParameter("userid_search");
		  String state_search=request.getParameter("state_search");
		  String department_search=request.getParameter("department_search");


		  System.out.println("projectid_search===>:"+projectid_search);
		  System.out.println("userid_search===>:"+userid_search);
		  System.out.println("state_search===>:"+state_search);
		  System.out.println("department_search===>:"+department_search);
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);

			 //查出用户
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
		
	 List<Task> tasks= taskService.queryByPage(Integer.parseInt(page),Integer.parseInt(rows),projectid_search,userid_search,state_search,department_search,"0").getList();
	 System.out.println("getTask.do=="+tasks.size());
	 int total= taskService.countByExample(projectid_search, userid_search, state_search,department_search,null);
	 
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":"+total+",\"rows\":");
	 sb.append("[");
	 for(int i=0;i<tasks.size();i++){
		 String completeness="0";
		 if(null!=tasks.get(i).getCurrenttime())
			 {
			 //float price=1.2;
			 DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			 String p=decimalFormat.format((Float.parseFloat(tasks.get(i).getCurrenttime().toString())/Float.parseFloat(tasks.get(i).getAlltime().toString()))*100);//format 返回的是字符串 
			 completeness=p+"%";
			 }
		 
		String state="未开始";
		if(tasks.get(i).getState()!=null){
			state=Basedata.stateMap.get(tasks.get(i).getState())+"";
		}
		
		String currenttime="0";
		if(tasks.get(i).getCurrenttime()!=null){		
			currenttime=tasks.get(i).getCurrenttime()+"";
		}
		
		int Completion=	0;
		float currentcount=0;
		
		
		List<Task> list=taskService.selectByParentid(tasks.get(i).getTaskid());
		if(list.size()>0){
			int completioncount=0;
			int completion=0;
			for(int j=0;j<list.size();j++){
				
				if(list.get(j).getCompletion()==null){
					completion=0;
				}else{
					completion=list.get(j).getCompletion();
				}
				completioncount+=completion;
				
				if(list.get(j).getCurrenttime()==null){
					currentcount+=0;
				}else{
					currentcount+=list.get(j).getCurrenttime();
				}
			}
			Completion=completioncount/list.size();
		}else{
			if(null!=tasks.get(i).getCompletion()){
				Completion=tasks.get(i).getCompletion();
			}	
		}
		currenttime=currentcount+"";
		
		Task task=taskService.selectByPrimaryKey(tasks.get(i).getParentid());
		String taskname="";
		if(task==null){
			taskname="";
		}else{
			taskname=task.getTaskname();	
		}
		
	
	int chirldrencount=taskService.countByParentid(tasks.get(i).getTaskid());
	 sb.append("{\"taskid\":\""+tasks.get(i).getTaskid()
			 	+"\",\"userid\":\""+tasks.get(i).getUserid()+","+userMap.get(tasks.get(i).getUserid())
			 	+"\",\"projectid\":\""+projectMap.get(tasks.get(i).getProjectid())
			 	+"\",\"taskname\":\""+tasks.get(i).getTaskname()
			 	+"\",\"taskdescription\":\""+tasks.get(i).getTaskdescription()
			 	+"\",\"alltime\":\""+tasks.get(i).getAlltime()
			 	+"\",\"currenttime\":\""+currenttime
			 	+"\",\"completeness\":\""+ completeness
			 	+"\",\"state\":\""+state
			 	+"\",\"createtime\":\""+tasks.get(i).getCreatetime()
			 	+"\",\"begintime\":\""+tasks.get(i).getBegintime()
			 	+"\",\"allocateid\":\""+userMap.get(tasks.get(i).getAllocateid())
			 	+"\",\"isvalidity\":\""+tasks.get(i).getIsvalidity()
			 	+"\",\"auditor\":\""+userMap.get(tasks.get(i).getAuditor()) 
			 	+"\",\"Completion\":\""+Completion+"%" 
			 	+"\",\"emergencydegree\":\""+tasks.get(i).getEmergencydegree()
			 	+"\",\"parent\":\""+taskname
			 	+"\",\"chirldrencount\":\""+chirldrencount
			 	+"\"}");
	if(i<tasks.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}


	
	@RequestMapping("/getsubTask.do")
	@ResponseBody
	public String getsubTask(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  String projectid_search=request.getParameter("projectid_search"); 
		  String userid_search=request.getParameter("userid_search");
		  String state_search=request.getParameter("state_search");
		  String department_search=request.getParameter("department_search");
		  String parentid=request.getParameter("parentid");
		  
		  if(parentid==null)parentid="8888888";
		  
		  userid_search=session.getAttribute("userid").toString();//从session中取
		  User user=(User)session.getAttribute("user");
		  department_search=user.getDepartmentid().toString();
		  

		  System.out.println("projectid_search===>:"+projectid_search);
		  System.out.println("userid_search===>:"+userid_search);
		  System.out.println("state_search===>:"+state_search);
		  System.out.println("department_search===>:"+department_search);
		  System.out.println("parentid===>:"+parentid);
		  
		  
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);

			 //查出用户
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
		
	 List<Task> tasks= taskService.queryByPage(Integer.parseInt(page),Integer.parseInt(rows),projectid_search,null,state_search,department_search,parentid).getList();
	 System.out.println("getTask.do=="+tasks.size());
	 int total= taskService.countByExample(projectid_search, null, state_search,department_search,parentid);
	 
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":"+total+",\"rows\":");
	 sb.append("[");
	 for(int i=0;i<tasks.size();i++){
		 String completeness="0";
		 if(null!=tasks.get(i).getCurrenttime())
			 {
			 //float price=1.2;
			 DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
			 String p=decimalFormat.format((Float.parseFloat(tasks.get(i).getCurrenttime().toString())/Float.parseFloat(tasks.get(i).getAlltime().toString()))*100);//format 返回的是字符串 
			 completeness=p+"%";
			 }
		 
		String state="未开始";
		if(tasks.get(i).getState()!=null){
			state=Basedata.stateMap.get(tasks.get(i).getState())+"";
		}
		
		String currenttime="0";
		if(tasks.get(i).getCurrenttime()!=null){		
			currenttime=tasks.get(i).getCurrenttime()+"";
		}
		
		int Completion=	0;
		if(null!=tasks.get(i).getCompletion()){
			Completion=tasks.get(i).getCompletion();
		}
	 
	Task task=taskService.selectByPrimaryKey(tasks.get(i).getParentid());
	String taskname="";
	if(task==null){
		taskname="";
	}else{
		taskname=task.getTaskname();		
	}
	
	int chirldrencount=taskService.countByParentid(tasks.get(i).getTaskid());
	 sb.append("{\"taskid\":\""+tasks.get(i).getTaskid()
			 	+"\",\"userid\":\""+tasks.get(i).getUserid()+","+userMap.get(tasks.get(i).getUserid())
			 	+"\",\"projectid\":\""+projectMap.get(tasks.get(i).getProjectid())
			 	+"\",\"taskname\":\""+tasks.get(i).getTaskname()
			 	+"\",\"taskdescription\":\""+tasks.get(i).getTaskdescription()
			 	+"\",\"alltime\":\""+tasks.get(i).getAlltime()
			 	+"\",\"currenttime\":\""+currenttime
			 	+"\",\"completeness\":\""+ completeness
			 	+"\",\"state\":\""+state
			 	+"\",\"createtime\":\""+tasks.get(i).getCreatetime()
			 	+"\",\"begintime\":\""+tasks.get(i).getBegintime()
			 	+"\",\"allocateid\":\""+userMap.get(tasks.get(i).getAllocateid())
			 	+"\",\"isvalidity\":\""+tasks.get(i).getIsvalidity()
			 	+"\",\"auditor\":\""+userMap.get(tasks.get(i).getAuditor()) 
			 	+"\",\"Completion\":\""+Completion+"%" 
			 	+"\",\"emergencydegree\":\""+tasks.get(i).getEmergencydegree()
			 	+"\",\"parentid\":\""+tasks.get(i).getParentid()
			 	+"\",\"parent\":\""+taskname
			 	+"\",\"chirldrencount\":\""+chirldrencount
			 	+"\"}");
	if(i<tasks.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}

	@RequestMapping("/addtask.do")
	@ResponseBody
	public String addtask(HttpServletRequest request) throws Exception {
		System.out.println("addtask.do");
		Task task=new Task();

		task.setUserid(Integer.parseInt(request.getParameter("userid")));
		task.setProjectid(Integer.parseInt(request.getParameter("projectid")));
		task.setTaskname(request.getParameter("taskname"));
		task.setTaskdescription(request.getParameter("taskdescripton"));
		task.setAlltime(Float.parseFloat(request.getParameter("alltime")));
		task.setState(0);
		task.setParentid(0);
		User user=userService.selectByPrimaryKey(Integer.parseInt(request.getParameter("userid")));
		task.setDepartmentid(user.getDepartmentid());
		task.setParentid(Integer.parseInt(request.getParameter("parentid")));
		//task.setCurrenttime(Integer.parseInt(request.getParameter("currenttime")));
		//任务状态
		//创建时间
		//开始时间
		//分配人
		//task.setAuditor(Integer.parseInt(request.getParameter("auditor")));
		taskService.insertTask(task);
		
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}
	
	@RequestMapping("/delTask.do")
	@ResponseBody
	public String delTask(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		
		int count=taskService.countByParentid(Integer.parseInt(id));
		System.out.println("count:"+count);
		if(count>0)return "[{\"result\":\"ERROR\"}]";
		
		int rs=rollbackService.deleteTask(Integer.parseInt(id));
	
	if(rs==0){
		System.out.println("ERROR");
		return "[{\"result\":\"ERROR\"}]";
	}
	return "[{\"result\":\"OK\"}]";
	}
	
	
	
	@RequestMapping("/startTask.do")
	@ResponseBody
	public String startTask(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		String style=request.getParameter("style");
	int rs=taskService.updateState(Integer.parseInt(id),Integer.parseInt(style));
	return "[{\"result\":\"OK\"}]";
	}
	
//记工时	
	@RequestMapping("/recordtime.do")
	@ResponseBody
	public String recordtime(HttpServletRequest request) throws Exception {
		System.out.println("recordtime："+request.getParameter("recordtime"));
		
		System.out.println("record_taskid："+request.getParameter("record_taskid"));
		System.out.println("consumption："+request.getParameter("consumption"));
		System.out.println("completion："+request.getParameter("completion"));
		System.out.println("log："+request.getParameter("log"));
		System.out.println("userid："+request.getParameter("userid"));
		

		String recordtime=request.getParameter("recordtime"); //任务ID
		String record_taskid=request.getParameter("record_taskid"); //任务ID
		String consumption=request.getParameter("consumption");
		String Completion=request.getParameter("completion");
		String logs=request.getParameter("log");
		String userid=request.getParameter("userid");

		int err=0;
		Date date=null;
		try {
			Float.parseFloat(consumption);
			Integer.parseInt(Completion.replace("%", ""));
			Integer.parseInt(userid.split(",")[0]);
			SimpleDateFormat sdf  =  new  SimpleDateFormat("MM/dd/yyyy HH:mm"); 
			date = sdf.parse(recordtime);
		} catch (Exception e) {
			e.printStackTrace();
			return "[{\"result\":\"ERROR\"}]";
		}
		

	//记工时	UPDATE
	int rs=taskService.recordTime(Integer.parseInt(record_taskid), Float.parseFloat(consumption),Integer.parseInt(Completion.replace("%", "")));
	
	//计任务时间表
	Task task=taskService.selectByPrimaryKey(Integer.parseInt(record_taskid));//根据任务ID得到任务
	
/*	Tasktime tasktime=tasktimeService.selectByUser(task.getUserid());
	tasktime.setTime(tasktime.getTime()-Float.parseFloat(recordtime));
	tasktimeService.updateTasktime(tasktime);*/
	
	//记日志
	HttpSession session = request.getSession();
	Log log =new Log();
	log.setType(1);//1表示工时日志
	log.setContent(logs);
	log.setWeek(TimeUtil.getWeek(date)+"");
	log.setRecordtime(date);
	log.setAddr("");
	log.setOpertor(Integer.parseInt(userid.split(",")[0]));//(Integer) session.getAttribute("userid") 0,xuwei
	log.setTaskid(task.getTaskid());
	log.setProjectid(task.getProjectid());
	log.setUsetime(Float.parseFloat(consumption));
	SimpleDateFormat formatter=new SimpleDateFormat ("yyyyMMdd"); 
	log.setTimeindex(formatter.format(date));
	User user=userService.selectByPrimaryKey(Integer.parseInt(userid.split(",")[0]));
	log.setDepartmentid(user.getDepartmentid());
	log.setCompletion(Integer.parseInt(Completion.replace("%", "")));
	//log.setTimeclass(Integer.parseInt(timeclass));
	logservice.insertLog(log);
	return "[{\"result\":\"OK\"}]";
	}
	
	
//任务时间管理
	@RequestMapping("/toTasktime.do")
	//@ResponseBody
	public String toTasktime(HttpServletRequest request) throws Exception {
		System.out.println("toTasktime.do");
		return "project/tasktime";
	}
	
	@RequestMapping("/getTasktime.do")
	@ResponseBody
	public String getTasktime(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);

		//查出用户
			 Map userMap=new HashMap();
		     List<User> users=userService.getUser();
		     for(int i=0;i<users.size();i++){
		    	 userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		     }	
		
	 List<Tasktime> tasktimes= tasktimeService.getTask();
	 System.out.println("getProject.do"+tasktimes.size());
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
	 for(int i=0;i<tasktimes.size();i++){

	 sb.append("{\"id\":\""+tasktimes.get(i).getId()
			 	+"\",\"userid\":\""+userMap.get(tasktimes.get(i).getUserid())
			 	+"\",\"time\":\""+tasktimes.get(i).getTime()
			 	+"\",\"alltime\":\""+tasktimes.get(i).getAlltime()
			 	+"\"}");
	if(i<tasktimes.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
		
	
	@RequestMapping("/addTasktime.do")
	@ResponseBody
	public int addTasktime(HttpServletRequest request){
		String id=request.getParameter("id");
		Tasktime tasktime=tasktimeService.selectByPrimaryKey(Integer.parseInt(id));
		tasktime.setTime(tasktime.getTime()+Basedata.daytime);
		tasktime.setAlltime(tasktime.getAlltime()+Basedata.daytime);
		return tasktimeService.updateTasktime(tasktime);
	}
	
	@RequestMapping("/decTasktime.do")
	@ResponseBody
	public int decTasktime(HttpServletRequest request){
		String id=request.getParameter("id");
		Tasktime tasktime=tasktimeService.selectByPrimaryKey(Integer.parseInt(id));
		tasktime.setTime(tasktime.getTime()-Basedata.daytime);
		tasktime.setAlltime(tasktime.getAlltime()-Basedata.daytime);
		return tasktimeService.updateTasktime(tasktime);
	}
	
	
	@RequestMapping("/distributabletime.do")
	@ResponseBody
	public String distributabletime(HttpServletRequest request) throws Exception {
		String userid=request.getParameter("userid");
		Tasktime tasktime=tasktimeService.selectByUser(Integer.parseInt(userid.split(",")[0]));
		Float result=tasktime.getTime();
	return "[{\"result\":\""+result+"\"}]";
	}

	//调整工时
	@RequestMapping("/adjustmenttime.do")
	@ResponseBody
	public String adjustmenttime(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		String timeflag=request.getParameter("timeflag");
		String worktime=request.getParameter("worktime");
		String cased=request.getParameter("cased");
		String bak=request.getParameter("bak");
		System.out.println("id"+id);
		System.out.println("timeflag"+timeflag);
		System.out.println("worktime"+worktime);
		System.out.println("cased"+cased);
		System.out.println("bak"+bak);
	List<Integer> timetaskidlist=StringUtil.jsonToList(id);	
	for(int i=0;i<timetaskidlist.size();i++){
	if(timeflag.equals("0")){//增加工时
			Tasktime tasktime=tasktimeService.selectByPrimaryKey(timetaskidlist.get(i));
			tasktime.setTime(tasktime.getTime()+Float.parseFloat(worktime));
			tasktime.setAlltime(tasktime.getAlltime()+Float.parseFloat(worktime));
			
			tasktimeService.updateTasktime(tasktime);
			Timeupdate timeupdate=new Timeupdate();
			timeupdate.setId(tasktime.getId());//任务时间ID
			timeupdate.setRecordtime(new Date());
			timeupdate.setTime(TimeUtil.getTimestr(new Date()));
			timeupdate.setBak(bak);
			timeupdate.setType(Integer.parseInt(cased));
			timeupdate.setChangetime(Float.parseFloat(worktime));
			timeupdate.setUserid(tasktime.getUserid());
			timeupdateService.insertTimeupdate(timeupdate);
			
		}else if(timeflag.equals("1")){//减少工时
			Tasktime tasktime=tasktimeService.selectByPrimaryKey(timetaskidlist.get(i));
			tasktime.setTime(tasktime.getTime()-Float.parseFloat(worktime));
			tasktime.setAlltime(tasktime.getAlltime()-Float.parseFloat(worktime));
			tasktimeService.updateTasktime(tasktime);
			
			Timeupdate timeupdate=new Timeupdate();
			timeupdate.setId(tasktime.getId());//任务时间ID
			timeupdate.setRecordtime(new Date());
			timeupdate.setTime(TimeUtil.getTimestr(new Date()));
			timeupdate.setBak(bak);
			timeupdate.setType(Integer.parseInt(cased));
			timeupdate.setChangetime(Float.parseFloat(worktime));
			timeupdate.setUserid(tasktime.getUserid());
			timeupdateService.insertTimeupdate(timeupdate);
	}
	}
		
		
	return "[{\"result\":\""+1+"\"}]";
	}
	
	@RequestMapping("/inittime.do")
	@ResponseBody
	public String inittime(HttpServletRequest request) throws Exception {
	List<User> users =userService.getUser();
	List<Tasktime> tasktimes=tasktimeService.getTask();
	for(int i=0;i<users.size();i++){
		boolean b=false;
		for(int j=0;j<tasktimes.size();j++){
			if(users.get(i).getUserid()==tasktimes.get(j).getUserid()){
				System.out.println("已存在");
				b=true;
				break;
			}
		}
		if(b==false){
		Tasktime tasktime=new Tasktime();
		tasktime.setUserid(users.get(i).getUserid());
		tasktime.setTime((float) 0.0);
		tasktime.setAlltime((float)0.0);
		tasktimeService.insertTasktime(tasktime);
		}
	}
	
		
		
	return "[{\"result\":\""+"ok"+"\"}]";
	}
	
//项目成员===============================================================================	
	
	//返回用户下已有的角色
		@RequestMapping("/getNoHavedUser.do")
		@ResponseBody
		public String getNoHavedUser(HttpServletRequest request) throws Exception {
			System.out.println("getNoHavedUser");
			String page=request.getParameter("page");
			  //每页显示的记录数
			  String rows=request.getParameter("rows"); 
			  
			  System.out.println("page===>:"+page);
			  System.out.println("rows===>:"+rows);
			  
			  String projectid=request.getParameter("projectid");
			  System.out.println("projectid====="+projectid);
		
			  //根据用户ID查出所有角色
		 List<Projectmembers> projectusers =projectUserService.selectUseridByProject(Integer.parseInt(projectid));
			  
		 List<User> users= userService.getUser();
		 System.out.println("getGrid.do"+users.size());
		 
		 List<User> haveusers=new ArrayList<User>();
		 for(int i=0;i<users.size();i++){
			 int userid=users.get(i).getUserid();
			 for(int j=0;j<projectusers.size();j++){
				 if(userid==projectusers.get(j).getUserid()){
					 haveusers.add(users.get(i));
					 System.out.println("------------------"+i);
				 }
			 }
			 
		 }
		 
		 users.removeAll(haveusers);
		 StringBuilder sb=new StringBuilder();
		 sb.append("{\"total\":9,\"rows\":");
		 sb.append("[");
		 for(int i=0;i<users.size();i++){
		 sb.append("{\"realname\":\""+users.get(i).getRealname()
				 	+"\",\"userid\":\""+users.get(i).getUserid()
				 	+"\"}");
		if(i<users.size()-1) sb.append(",");
		 }
		// sb.append(",");
		 sb.append("]}");

		return sb.toString();
			//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
			//return json;
		}

//返回任务下没用的用户		
		@RequestMapping("/getTaskNoHavedUser.do")
		@ResponseBody
		public String getTaskNoHavedUser(HttpServletRequest request) throws Exception {
			System.out.println("getTaskNoHavedUser");
			String page=request.getParameter("page");
			  //每页显示的记录数
			  String rows=request.getParameter("rows"); 
			  
			  System.out.println("page===>:"+page);
			  System.out.println("rows===>:"+rows);
			  
			  String taskid=request.getParameter("taskid");
			  System.out.println("taskid====="+taskid);
		
			  //根据用户ID查出所有角色
		 List<Taskmembers> taskusers =taskUserService.selectUseridByTask(Integer.parseInt(taskid));
		 	
		 List<User> users= userService.getUser();
		 System.out.println("getGrid.do"+users.size());
		 
		 List<User> haveusers=new ArrayList<User>();
		 for(int i=0;i<users.size();i++){
			 int userid=users.get(i).getUserid();
			 for(int j=0;j<taskusers.size();j++){
				 if(userid==taskusers.get(j).getUserid()){
					 haveusers.add(users.get(i));
					 System.out.println("------------------"+i);
				 }
			 }
			 
		 }
		 
		 users.removeAll(haveusers);
		 StringBuilder sb=new StringBuilder();
		 sb.append("{\"total\":9,\"rows\":");
		 sb.append("[");
		 for(int i=0;i<users.size();i++){
		 sb.append("{\"realname\":\""+users.get(i).getRealname()
				 	+"\",\"userid\":\""+users.get(i).getUserid()
				 	+"\"}");
		if(i<users.size()-1) sb.append(",");
		 }
		// sb.append(",");
		 sb.append("]}");

		return sb.toString();
			//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
			//return json;
		}
		
		
		
		//返回用户下已有的角色
		@RequestMapping("/getHavedUser.do")
		@ResponseBody
		public String getHavedUser(HttpServletRequest request) throws Exception {
			System.out.println("getHavedUser");
			  String page=request.getParameter("page");
			  //每页显示的记录数
			  String rows=request.getParameter("rows"); 
			  
			  System.out.println("page===>:"+page);
			  System.out.println("rows===>:"+rows);
			  
			  String projectid=request.getParameter("projectid");
			  System.out.println("projectid====="+projectid);
		
			  //根据用户ID查出所有角色
		 List<Projectmembers> projectusers =projectUserService.selectUseridByProject(Integer.parseInt(projectid));
			  
		 List<User> users= userService.getUser();
		 System.out.println("getGrid.do"+users.size());
		 
		 List<User> haveusers=new ArrayList<User>();
		 for(int i=0;i<users.size();i++){
			 int userid=users.get(i).getUserid();
			 for(int j=0;j<projectusers.size();j++){
				 if(userid==projectusers.get(j).getUserid()){
					 haveusers.add(users.get(i));
					 System.out.println("+++++++++++++++++++++"+i);
				 }
			 }
			 
		 }
		 
		 
		 StringBuilder sb=new StringBuilder();
		 sb.append("{\"total\":9,\"rows\":");
		 sb.append("[");
		 for(int i=0;i<haveusers.size();i++){
		 sb.append("{\"realname\":\""+haveusers.get(i).getRealname()
				 	+"\",\"userid\":\""+haveusers.get(i).getUserid()
				 	+"\"}");
		if(i<haveusers.size()-1) sb.append(",");
		 }
		// sb.append(",");
		 sb.append("]}");

		return sb.toString();
			//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
			//return json;
		}	
		
		
		@RequestMapping("/getTaskHavedUser.do")
		@ResponseBody
		public String getTaskHavedUser(HttpServletRequest request) throws Exception {
			System.out.println("getHavedUser");
			  String page=request.getParameter("page");
			  //每页显示的记录数
			  String rows=request.getParameter("rows"); 
			  
			  System.out.println("page===>:"+page);
			  System.out.println("rows===>:"+rows);
			  
			  String taskid=request.getParameter("taskid");
			  System.out.println("projectid====="+taskid);
		
			  //根据用户ID查出所有角色
		 List<Taskmembers> taskusers =taskUserService.selectUseridByTask(Integer.parseInt(taskid));
			  
		 List<User> users= userService.getUser();
		 System.out.println("getGrid.do"+users.size());
		 
		 List<User> haveusers=new ArrayList<User>();
		 for(int i=0;i<users.size();i++){
			 int userid=users.get(i).getUserid();
			 for(int j=0;j<taskusers.size();j++){
				 if(userid==taskusers.get(j).getUserid()){
					 haveusers.add(users.get(i));
					 System.out.println("+++++++++++++++++++++"+i);
				 }
			 }
			 
		 }
		 
		 
		 StringBuilder sb=new StringBuilder();
		 sb.append("{\"total\":9,\"rows\":");
		 sb.append("[");
		 for(int i=0;i<haveusers.size();i++){
		 sb.append("{\"realname\":\""+haveusers.get(i).getRealname()
				 	+"\",\"userid\":\""+haveusers.get(i).getUserid()
				 	+"\"}");
		if(i<haveusers.size()-1) sb.append(",");
		 }
		// sb.append(",");
		 sb.append("]}");

		return sb.toString();
			//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
			//return json;
		}		
		

		@RequestMapping("/ProjectAddUser.do")
		@ResponseBody
		public String ProjectAddUser(HttpServletRequest request) throws Exception {
		   String projectids=request.getParameter("projectids");
		   String userids=request.getParameter("userids");
		   System.out.println("projectids:="+projectids);
		   System.out.println("userids:="+userids);
		   List<Integer> projectidlist=StringUtil.jsonToList(projectids);
		   List<Integer> useridlist=StringUtil.jsonToList(userids);
		   
		   for(int i=0;i<projectidlist.size();i++){
			   Projectmembers projectmembers=new Projectmembers();
			   projectmembers.setProjectid(projectidlist.get(i));
			   for(int j=0;j<useridlist.size();j++){
				   projectmembers.setUserid(useridlist.get(j));
				   projectUserService.insertProjectUser(projectmembers);
			   }
		   }
		   
		   
		   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
		 return "[{\"result\":\"OK\"}]";
		}

		
		@RequestMapping("/TaskAddUser.do")
		@ResponseBody
		public String TaskAddUser(HttpServletRequest request) throws Exception {
		   String taskids=request.getParameter("taskids");
		   String userids=request.getParameter("userids");
		   System.out.println("projectids:="+taskids);
		   System.out.println("userids:="+userids);
		   List<Integer> taskidlist=StringUtil.jsonToList(taskids);
		   List<Integer> useridlist=StringUtil.jsonToList(userids);
		   
		   for(int i=0;i<taskidlist.size();i++){
			   Taskmembers taskmembers=new Taskmembers();
			   taskmembers.setTaskid(taskidlist.get(i));
			   for(int j=0;j<useridlist.size();j++){
				   taskmembers.setUserid(useridlist.get(j));
				   taskUserService.insertTaskUser(taskmembers);
			   }
		   }
		   
		   
		   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
		 return "[{\"result\":\"OK\"}]";
		}		
		
		
		@RequestMapping("/ProjectRemoveUser.do")
		@ResponseBody
		public String UserRemoveRole(HttpServletRequest request) throws Exception {
		String projectids=request.getParameter("projectids");
	    String userids=request.getParameter("userids");
		   System.out.println("userids:="+userids);
		   System.out.println("projectids:="+projectids);
		   List<Integer> projectidlist=StringUtil.jsonToList(projectids);
		   List<Integer> useridlist=StringUtil.jsonToList(userids);
		   
		   for(int i=0;i<projectidlist.size();i++){
			   Projectmembers projectmembers=new Projectmembers();
			   projectmembers.setProjectid(projectidlist.get(i));
			   for(int j=0;j<useridlist.size();j++){
				   projectmembers.setUserid(useridlist.get(j));
				   projectUserService.deleteByExample(projectmembers.getProjectid(), projectmembers.getUserid());
			   }
		   }
		   
		   
		   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
		 return "[{\"result\":\"OK\"}]";
		}	

		
		@RequestMapping("/TaskRemoveUser.do")
		@ResponseBody
		public String TaskRemoveUser(HttpServletRequest request) throws Exception {
		String taskids=request.getParameter("taskids");
	    String userids=request.getParameter("userids");
		   System.out.println("userids:="+userids);
		   System.out.println("projectids:="+taskids);
		   List<Integer> taskidlist=StringUtil.jsonToList(taskids);
		   List<Integer> useridlist=StringUtil.jsonToList(userids);
		   
		   for(int i=0;i<useridlist.size();i++){
			   Taskmembers taskmembers=new Taskmembers();
			   taskmembers.setTaskid(taskidlist.get(i));
			   for(int j=0;j<useridlist.size();j++){
				   taskmembers.setUserid(useridlist.get(j));
				   taskUserService.deleteByExample(taskmembers.getTaskid(), taskmembers.getUserid());
			   }
		   }
		   
		   
		   //int rs=userService.deleteByPrimaryKey(Integer.parseInt(id));
		 return "[{\"result\":\"OK\"}]";
		}	
		
}
