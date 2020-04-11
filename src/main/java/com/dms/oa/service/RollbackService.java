package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.LogDao;
import com.dms.oa.dao.WeeklyDao;
import com.dms.oa.po.Log;
import com.dms.oa.po.Task;
import com.dms.oa.po.Tasktime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Component
public class RollbackService {
	
	@Resource
	private WeeklyDao weeklyDao;
	@Resource
	private TaskService taskService;
	@Resource
	private LogDao logDao;
	@Resource
	private TasktimeService tasktimeService;
	@Resource
	private ProjectService projectService;
	@Resource
	private ProjectUserService projectUserService;
	
	
	//删除周报
	public int deleteWeekly(int weeklyid){
    System.out.println("deleteWeekly id="+weeklyid);
	Log log=weeklyDao.selectWeekly(weeklyid);
	
	Float usetime=log.getUsetime()-log.getUsetime()*2;
	taskService.recordTime(log.getTaskid(), usetime, log.getCompletion());
	

	Tasktime tasktime=tasktimeService.selectByUser(log.getOpertor());
	tasktime.setTime(tasktime.getTime()+log.getUsetime());
	System.out.println("tasktime.getTime()+log.getUsetime()::::::"+tasktime.getTime()+log.getUsetime());
	tasktimeService.updateTasktime(tasktime);
	
	weeklyDao.deleteByPrimaryKey(weeklyid);
    return 0;		
	}
	
	
	public int deleteTask(int taskid){
		System.out.println("deleteTask taskid="+taskid);
		List<Log> logs=weeklyDao.selectWeeklybyTaskid(taskid);
		System.out.println("logs.size():"+logs.size());
		for(int i=0;i<logs.size();i++){
			deleteWeekly(logs.get(i).getId());		
		}
		taskService.deleteByPrimaryKey(taskid);
		return taskid;

	}
	
	public int deleteProject(int projectid){
		List<Task> tasks=taskService.selectByProjectid(projectid);
		for(int i=0;i<tasks.size();i++){
			deleteTask(tasks.get(i).getTaskid());
		}
		
		projectUserService.deleteByProject(projectid);
		return projectService.deleteByPrimaryKey(projectid);	
	}

}
