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

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.base.Basedata;
import com.dms.oa.base.Excelopertion;
import com.dms.oa.po.Department;
import com.dms.oa.po.Log;
import com.dms.oa.po.Project;
import com.dms.oa.po.Task;
import com.dms.oa.po.Unittest;
import com.dms.oa.po.User;
import com.dms.oa.service.DepartmentService;
import com.dms.oa.service.ProjectService;
import com.dms.oa.service.TaskService;
import com.dms.oa.service.UnittestService;
import com.dms.oa.service.UserService;
import com.dms.oa.service.WeekService;
import com.dms.oa.util.TimeUtil;

@Controller
@RequestMapping("/mine")
public class mineController {

	@Resource
	private UserService userService;
	@Resource
	private TaskService taskService;
	@Resource
	private ProjectService projectService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private WeekService weekService;

	@RequestMapping("/tomine.do")
	// @ResponseBody
	public String tomine(HttpServletRequest request) throws Exception {
		System.out.println("tomine.do");
		return "mine/mine";
	}

	@RequestMapping("/getmine.do")
	@ResponseBody
	public String getmine(HttpServletRequest request) throws Exception {
		System.out.println("tomine.do");
		HttpSession session = request.getSession();
		System.out.println("sessionusername:"
				+ session.getAttribute("username"));
		List<User> users = userService.selectByUsername((String) session
				.getAttribute("username"));

		JSONObject object = JSONObject.fromObject(users.get(0));
		return object.toString();
	}

	@RequestMapping("/modifymine.do")
	@ResponseBody
	public String modifymine(HttpServletRequest request) throws Exception {
		System.out.println("modifymine.do");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String realname = request.getParameter("realname");
		String sex = request.getParameter("sex");
		String departmentid = request.getParameter("departmentid");
		String tel = request.getParameter("tel");
		System.out.println(userid);
		System.out.println(username);
		System.out.println(password);
		System.out.println(age);
		System.out.println(realname);
		System.out.println(sex);
		System.out.println(departmentid);
		System.out.println(tel);
		User user = new User();
		user.setUserid(Integer.parseInt(userid));
		user.setUsername(username);
		user.setPassword(password);
		user.setAge(Integer.parseInt(age));
		user.setRealname(realname);
		user.setSex(Integer.parseInt(sex));
		user.setTel(tel);
		user.setDepartmentid(Integer.parseInt(departmentid));
		userService.updateByPrimaryKeySelective(user);
		String json = "[{\"result\":\"OK\"}]";
		return json;
	}

	// ================================================================================================
	@RequestMapping("/mytask.do")
	// @ResponseBody
	public String mytask(HttpServletRequest request) throws Exception {
		System.out.println("mytask.do");
		return "mine/mytask";
	}

	@RequestMapping("/getTask.do")
	@ResponseBody
	public String getTask(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		// 每页显示的记录数
		String rows = request.getParameter("rows");

		String projectid_search = request.getParameter("projectid_search");
		String userid_search = request.getParameter("userid_search");
		String state_search = request.getParameter("state_search");
		String department_search = request.getParameter("department_search");
		String parentid = request.getParameter("parentid");

		if (parentid == null)
			parentid = "0";

		//userid_search = session.getAttribute("userid").toString();// 从session中取
		User user = (User) session.getAttribute("user");
		department_search = user.getDepartmentid().toString();
		department_search=null;//部门不参与查询

		System.out.println("projectid_search===>:" + projectid_search);
		System.out.println("userid_search===>:" + userid_search);
		System.out.println("state_search===>:" + state_search);
		System.out.println("department_search===>:" + department_search);
		System.out.println("parentid===>:" + parentid);

		System.out.println("page===>:" + page);
		System.out.println("rows===>:" + rows);

		// 查出用户
		Map userMap = new HashMap();
		List<User> users = userService.getUser();
		for (int i = 0; i < users.size(); i++) {
			userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		}

		Map projectMap = new HashMap();
		List<Project> projects = projectService.getProject();
		for (int i = 0; i < projects.size(); i++) {
			projectMap.put(projects.get(i).getProjectid(), projects.get(i)
					.getProjectname());
		}

		List<Task> tasks = taskService.queryByPage(Integer.parseInt(page),
				Integer.parseInt(rows), projectid_search, userid_search,
				state_search, department_search, parentid).getList();
		System.out.println("getTask.do==" + tasks.size());
		int total = taskService.countByExample(projectid_search, userid_search,
				state_search, department_search, parentid);

		StringBuilder sb = new StringBuilder();
		sb.append("{\"total\":" + total + ",\"rows\":");
		sb.append("[");
		for (int i = 0; i < tasks.size(); i++) {
			String completeness = "0";
			if (null != tasks.get(i).getCurrenttime()) {
				// float price=1.2;
				DecimalFormat decimalFormat = new DecimalFormat(".00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
				String p = decimalFormat.format((Float.parseFloat(tasks.get(i)
						.getCurrenttime().toString()) / Float.parseFloat(tasks
						.get(i).getAlltime().toString())) * 100);// format
																	// 返回的是字符串
				completeness = p + "%";
			}

			String state = "未开始";
			if (tasks.get(i).getState() != null) {
				state = Basedata.stateMap.get(tasks.get(i).getState()) + "";
			}

			String currenttime = "0";
			if (tasks.get(i).getCurrenttime() != null) {
				currenttime = tasks.get(i).getCurrenttime() + "";
			}

			int Completion = 0;
			float currentcount = 0;

			List<Task> list = taskService.selectByParentid(tasks.get(i)
					.getTaskid());
			if (list.size() > 0) {
				int completioncount = 0;
				int completion = 0;
				for (int j = 0; j < list.size(); j++) {

					if (list.get(j).getCompletion() == null) {
						completion = 0;
					} else {
						completion = list.get(j).getCompletion();
					}
					completioncount += completion;

					if (list.get(j).getCurrenttime() == null) {
						currentcount += 0;
					} else {
						currentcount += list.get(j).getCurrenttime();
					}

				}
				Completion = completioncount / list.size();
			} else {
				if (null != tasks.get(i).getCompletion()) {
					Completion = tasks.get(i).getCompletion();
				}
			}
			currenttime = currentcount + "";

			Task task = taskService.selectByPrimaryKey(tasks.get(i)
					.getParentid());
			String taskname = "";
			if (task == null) {
				taskname = "";
			} else {
				taskname = task.getTaskname();
			}

			int chirldrencount = taskService.countByParentid(tasks.get(i)
					.getTaskid());
			sb.append("{\"taskid\":\"" + tasks.get(i).getTaskid()
					+ "\",\"userid\":\"" + tasks.get(i).getUserid() + ","
					+ userMap.get(tasks.get(i).getUserid())
					+ "\",\"projectid\":\""
					+ projectMap.get(tasks.get(i).getProjectid())
					+ "\",\"taskname\":\"" + tasks.get(i).getTaskname()
					+ "\",\"taskdescription\":\""
					+ tasks.get(i).getTaskdescription() + "\",\"alltime\":\""
					+ tasks.get(i).getAlltime() + "\",\"currenttime\":\""
					+ currenttime + "\",\"completeness\":\"" + completeness
					+ "\",\"state\":\"" + state + "\",\"createtime\":\""
					+ tasks.get(i).getCreatetime() + "\",\"begintime\":\""
					+ tasks.get(i).getBegintime() + "\",\"allocateid\":\""
					+ userMap.get(tasks.get(i).getAllocateid())
					+ "\",\"isvalidity\":\"" + tasks.get(i).getIsvalidity()
					+ "\",\"auditor\":\""
					+ userMap.get(tasks.get(i).getAuditor())
					+ "\",\"Completion\":\"" + Completion + "%"
					+ "\",\"emergencydegree\":\""
					+ tasks.get(i).getEmergencydegree() + "\",\"parentid\":\""
					+ tasks.get(i).getParentid() + "\",\"parent\":\""
					+ taskname + "\",\"chirldrencount\":\"" + chirldrencount
					+ "\"}");
			if (i < tasks.size() - 1)
				sb.append(",");
		}
		// sb.append(",");
		sb.append("]}");

		return sb.toString();
		// String
		// json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		// return json;
	}

	@RequestMapping("/getsubTask.do")
	@ResponseBody
	public String getsubTask(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		// 每页显示的记录数
		String rows = request.getParameter("rows");

		String projectid_search = request.getParameter("projectid_search");
		String userid_search = request.getParameter("userid_search");
		String state_search = request.getParameter("state_search");
		String department_search = request.getParameter("department_search");
		String parentid = request.getParameter("parentid");

		if (parentid == null)
			parentid = "8888888";

		userid_search = session.getAttribute("userid").toString();// 从session中取
		User user = (User) session.getAttribute("user");
		department_search = user.getDepartmentid().toString();

		System.out.println("projectid_search===>:" + projectid_search);
		System.out.println("userid_search===>:" + userid_search);
		System.out.println("state_search===>:" + state_search);
		System.out.println("department_search===>:" + department_search);
		System.out.println("parentid===>:" + parentid);

		System.out.println("page===>:" + page);
		System.out.println("rows===>:" + rows);

		// 查出用户
		Map userMap = new HashMap();
		List<User> users = userService.getUser();
		for (int i = 0; i < users.size(); i++) {
			userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		}

		Map projectMap = new HashMap();
		List<Project> projects = projectService.getProject();
		for (int i = 0; i < projects.size(); i++) {
			projectMap.put(projects.get(i).getProjectid(), projects.get(i)
					.getProjectname());
		}

		List<Task> tasks = taskService.queryByPage(Integer.parseInt(page),
				Integer.parseInt(rows), projectid_search, userid_search,
				state_search, department_search, parentid).getList();
		System.out.println("getTask.do==" + tasks.size());
		int total = taskService.countByExample(projectid_search, userid_search,
				state_search, department_search, parentid);

		StringBuilder sb = new StringBuilder();
		sb.append("{\"total\":" + total + ",\"rows\":");
		sb.append("[");
		for (int i = 0; i < tasks.size(); i++) {
			String completeness = "0";
			if (null != tasks.get(i).getCurrenttime()) {
				// float price=1.2;
				DecimalFormat decimalFormat = new DecimalFormat(".00");// 构造方法的字符格式这里如果小数不足2位,会以0补足.
				String p = decimalFormat.format((Float.parseFloat(tasks.get(i)
						.getCurrenttime().toString()) / Float.parseFloat(tasks
						.get(i).getAlltime().toString())) * 100);// format
																	// 返回的是字符串
				completeness = p + "%";
			}

			String state = "未开始";
			if (tasks.get(i).getState() != null) {
				state = Basedata.stateMap.get(tasks.get(i).getState()) + "";
			}

			String currenttime = "0";
			if (tasks.get(i).getCurrenttime() != null) {
				currenttime = tasks.get(i).getCurrenttime() + "";
			}

			int Completion = 0;
			if (null != tasks.get(i).getCompletion()) {
				Completion = tasks.get(i).getCompletion();
			}

			Task task = taskService.selectByPrimaryKey(tasks.get(i)
					.getParentid());
			String taskname = "";
			if (task == null) {
				taskname = "";
			} else {
				taskname = task.getTaskname();
			}

			int chirldrencount = taskService.countByParentid(tasks.get(i)
					.getTaskid());
			sb.append("{\"taskid\":\"" + tasks.get(i).getTaskid()
					+ "\",\"userid\":\"" + tasks.get(i).getUserid() + ","
					+ userMap.get(tasks.get(i).getUserid())
					+ "\",\"projectid\":\""
					+ projectMap.get(tasks.get(i).getProjectid())
					+ "\",\"taskname\":\"" + tasks.get(i).getTaskname()
					+ "\",\"taskdescription\":\""
					+ tasks.get(i).getTaskdescription() + "\",\"alltime\":\""
					+ tasks.get(i).getAlltime() + "\",\"currenttime\":\""
					+ currenttime + "\",\"completeness\":\"" + completeness
					+ "\",\"state\":\"" + state + "\",\"createtime\":\""
					+ tasks.get(i).getCreatetime() + "\",\"begintime\":\""
					+ tasks.get(i).getBegintime() + "\",\"allocateid\":\""
					+ userMap.get(tasks.get(i).getAllocateid())
					+ "\",\"isvalidity\":\"" + tasks.get(i).getIsvalidity()
					+ "\",\"auditor\":\""
					+ userMap.get(tasks.get(i).getAuditor())
					+ "\",\"Completion\":\"" + Completion + "%"
					+ "\",\"emergencydegree\":\""
					+ tasks.get(i).getEmergencydegree() + "\",\"parentid\":\""
					+ tasks.get(i).getParentid() + "\",\"parent\":\""
					+ taskname + "\",\"chirldrencount\":\"" + chirldrencount
					+ "\"}");
			if (i < tasks.size() - 1)
				sb.append(",");
		}
		// sb.append(",");
		sb.append("]}");

		return sb.toString();
		// String
		// json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		// return json;
	}

	@RequestMapping("/addtask.do")
	@ResponseBody
	public String addtask(HttpServletRequest request) throws Exception {
		System.out.println("addtask.do");
		// HttpSession session = request.getSession();
		// User user=(User)session.getAttribute("user");
		Task task = new Task();

		User user = userService.selectByPrimaryKey(Integer.parseInt(request
				.getParameter("userid")));
		task.setUserid(Integer.parseInt(request.getParameter("userid")));
		// task.setUserid(user.getUserid());
		task.setProjectid(Integer.parseInt(request.getParameter("projectid")));
		task.setTaskname(request.getParameter("taskname"));
		task.setTaskdescription(request.getParameter("taskdescripton"));
		task.setAlltime(Float.parseFloat(request.getParameter("alltime")));
		task.setState(0);
		// User
		// user=userService.selectByPrimaryKey(Integer.parseInt(request.getParameter("userid")));
		task.setDepartmentid(user.getDepartmentid());
		task.setParentid(Integer.parseInt(request.getParameter("parentid")));

		// task.setCurrenttime(Integer.parseInt(request.getParameter("currenttime")));
		// 任务状态
		// 创建时间
		// 开始时间
		// 分配人
		// task.setAuditor(Integer.parseInt(request.getParameter("auditor")));
		taskService.insertTask(task);

		String json = "[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}

	// ===============================================================================
	@RequestMapping("/myweekly.do")
	public String toweekly(HttpServletRequest request) throws Exception {
		System.out.println("myweekly.do");
		return "mine/myweekly";
	}

	@RequestMapping("/getWeekly.do")
	@ResponseBody
	public String getWeekly(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		// 每页显示的记录数
		String rows = request.getParameter("rows");

		String projectid_search = request.getParameter("projectid_search");
		String userid_search = request.getParameter("userid_search");
		String week_search = request.getParameter("week_search");
		String department_search = request.getParameter("department_search");

		userid_search = session.getAttribute("userid").toString();// 从session中取
		User user = (User) session.getAttribute("user");
		department_search = user.getDepartmentid().toString();

		System.out.println("projectid_search===>:" + projectid_search);
		System.out.println("userid_search===>:" + userid_search);
		System.out.println("week_search===>:" + week_search);
		System.out.println("department_search===>:" + department_search);

		System.out.println("page===>:" + page);
		System.out.println("rows===>:" + rows);

		Map userMap = new HashMap();
		List<User> users = userService.getUser();
		for (int i = 0; i < users.size(); i++) {
			userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		}

		Map projectMap = new HashMap();
		List<Project> projects = projectService.getProject();
		for (int i = 0; i < projects.size(); i++) {
			projectMap.put(projects.get(i).getProjectid(), projects.get(i)
					.getProjectname());
		}
		Map taskMap = new HashMap();
		List<Task> tasks = taskService.getAllTask();
		for (int i = 0; i < tasks.size(); i++) {
			taskMap.put(tasks.get(i).getTaskid(), tasks.get(i).getTaskname());
		}

		Map departmentMap = new HashMap();
		List<Department> departments = departmentService.getDepartment();
		for (int i = 0; i < departments.size(); i++) {
			departmentMap.put(departments.get(i).getId(), departments.get(i)
					.getName());
		}

		List<Log> weeklys = weekService
				.queryByPage("", null, Integer.parseInt(page),
						Integer.parseInt(rows), projectid_search,
						userid_search, week_search, department_search)
				.getList();
		System.out.println("getGrid.do" + weeklys.size());
		int total = weekService.countByExample(projectid_search, userid_search,
				week_search, department_search);
		System.out.println("total:"+total);

		StringBuilder sb = new StringBuilder();
		sb.append("{\"total\":" + total + ",\"rows\":");
		sb.append("[");
		for (int i = 0; i < weeklys.size(); i++) {
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

			sb.append("{\"week\":\"" + "第" + weeklys.get(i).getWeek() + "周"
					+ "\",\"recordtime\":\"" + weeklys.get(i).getRecordtime()
					+ "\",\"content\":\"" + weeklys.get(i).getContent()
					+ "\",\"opertor\":\""
					+ userMap.get(weeklys.get(i).getOpertor()) + "\",\"id\":\""
					+ weeklys.get(i).getId() + "\",\"projectid\":\""
					+ projectMap.get(weeklys.get(i).getProjectid())
					+ "\",\"taskid\":\""
					+ taskMap.get(weeklys.get(i).getTaskid())
					+ "\",\"usetime\":\"" + weeklys.get(i).getUsetime()
					+ "\",\"weekday\":\""
					+ TimeUtil.getWeekOfDate(weeklys.get(i).getRecordtime())
					+ "\",\"department\":\""
					+ departmentMap.get(weeklys.get(i).getDepartmentid())
					+ "\",\"completion\":\"" + weeklys.get(i).getCompletion()
					+ "%" + "\",\"timeclass\":\""
					+ Basedata.getTimeclass(weeklys.get(i).getTimeclass())
					+ "\",\"taskname\":\"" + taskname + "\"}");
			if (i < weeklys.size() - 1)
				sb.append(",");
		}
		sb.append("]}");
System.out.println(sb.toString());
		return sb.toString();
	}

	// 搜索
	@RequestMapping("/Export.do")
	@ResponseBody
	public String Timetaskstatic(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		System.out.println("Export.do");
		String projectid_search = request.getParameter("projectid_search");
		String userid_search = request.getParameter("userid_search");
		String week_search = request.getParameter("week_search");
		String department_search = request.getParameter("department_search");

		userid_search = session.getAttribute("userid").toString();// 从session中取
		User user = (User) session.getAttribute("user");
		department_search = user.getDepartmentid().toString();

		System.out.println("projectid_search===>:" + projectid_search);
		System.out.println("userid_search===>:" + userid_search);
		System.out.println("week_search===>:" + week_search);
		System.out.println("department_search===>:" + department_search);

		Map userMap = new HashMap();
		List<User> users = userService.getUser();
		for (int i = 0; i < users.size(); i++) {
			userMap.put(users.get(i).getUserid(), users.get(i).getRealname());
		}

		Map projectMap = new HashMap();
		List<Project> projects = projectService.getProject();
		for (int i = 0; i < projects.size(); i++) {
			projectMap.put(projects.get(i).getProjectid(), projects.get(i)
					.getProjectname());
		}
		Map taskMap = new HashMap();
		List<Task> tasks = taskService.getAllTask();
		for (int i = 0; i < tasks.size(); i++) {
			taskMap.put(tasks.get(i).getTaskid(), tasks.get(i).getTaskname());
		}

		Map departmentMap = new HashMap();
		List<Department> departments = departmentService.getDepartment();
		for (int i = 0; i < departments.size(); i++) {
			departmentMap.put(departments.get(i).getId(), departments.get(i)
					.getName());
		}
		/*
		 * {field:'projectid',title:'所属项目',width:fixWidth(0.083)},
		 * {field:'taskid',title:'所属任务',width:fixWidth(0.083)},
		 * {field:'week',title:'第几周',width:fixWidth(0.058)},
		 * {field:'weekday',title:'星期几',width:fixWidth(0.058)},
		 * {field:'content',title:'内容',width:fixWidth(0.40)}, { field:
		 * 'recordtime', title: '记录时间', sortable: true,width:fixWidth(0.12),
		 * {field:'opertor',title:'记录人',width:fixWidth(0.083)},
		 */

		List<Log> weeklys = weekService.selectWeekly(projectid_search,
				userid_search, week_search, department_search);
		List<List<String>> list = new ArrayList();
		for (int i = 0; i < weeklys.size(); i++) {
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
			
			List<String> strlist = new ArrayList();
			strlist.add(projectMap.get(weeklys.get(i).getProjectid()) + "");// 项目名称
			strlist.add(taskname);
			strlist.add(taskMap.get(weeklys.get(i).getTaskid()) + "");// 任务名称
			strlist.add("第" + weeklys.get(i).getWeek() + "周");// 第几周
			strlist.add(TimeUtil.getWeekOfDate(weeklys.get(i).getRecordtime()));// 星期几
			strlist.add(weeklys.get(i).getUsetime() + "");// 用时
			strlist.add(Basedata.getTimeclass(weeklys.get(i).getTimeclass()));
			strlist.add(weeklys.get(i).getCompletion() + "%");// 用时
			strlist.add(weeklys.get(i).getContent());// 内容
			strlist.add(weeklys.get(i).getRecordtime().toString());// 记录时间
			strlist.add(userMap.get(weeklys.get(i).getOpertor()) + "");// 负责人
			strlist.add(departmentMap.get(weeklys.get(i).getDepartmentid())
					+ "");// 负责人
			list.add(strlist);
		}

		String[] title = { "项目名称","父任务", "任务名称", "第几周", "星期几", "用时", "工时分类", "完成度",
				"内容", "记录时间", "负责人", "所属部门" };
		Excelopertion.excelWritebyList(request.getSession().getServletContext().getRealPath("")   +"/report/"+user.getUsername()+".xls", list, title);

		return "report/report";
	}

}
