package com.dms.oa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.TaskDao;
import com.dms.oa.dao.TaskUserDao;
import com.dms.oa.po.Log;
import com.dms.oa.po.Task;
import com.dms.oa.po.Taskmembers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Component
public class TaskService {
	
	@Resource
	private TaskDao taskDao;
	@Resource
	private TaskUserDao taskUserDao;
	
	public List<Task> getTask(String projectid_search,String userid_search,
			String state_search,String department_search,String parentid){
		//taskUserDao.selectByUserid(Integer.parseInt(userid_search));
/*		List<Integer> taskids=new ArrayList<Integer>();
		for(int i=0;i<taskusers.size();i++){
			taskids.add(taskusers.get(i).getTaskid());
			System.out.printf(taskusers.get(i).getTaskid()+",");
		}
		
		List<Task> task1=taskDao.selectByTaskids(taskids);//分配的任务 要查重
		List<Task> task2=taskDao.selectByExample(projectid_search,userid_search,state_search,department_search,parentid);
		List<Task> newtask=new ArrayList<Task>();*/
	//	newtask.addAll(task1);
	//	newtask.addAll(task2);
		//taskDao.selectByExample();
		List<Task> list=taskDao.selectByExample(projectid_search,userid_search,state_search,department_search,parentid);
		return list;
	}
	
	public List<Task> getAllTask(){
		return taskDao.selectByExample();	
	}
	
	public List<Task> selectByProjectid(int projectid){
		return taskDao.selectByProjectid(projectid);
	}
	
	 public PageInfo<Task> queryByPage(Integer pageNo,Integer pageSize,
			 String projectid_search,String userid_search,String state_search,String department_search,String parentid) {
		    pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Task> list = getTask(projectid_search,userid_search,state_search,department_search,parentid);
		    //用PageInfo对结果进行包装
		    System.out.println("--------------"+list.size());
		    PageInfo<Task> page = new PageInfo<Task>(list);
		    return page;
		}
	
	 public int countByExample(String projectid_search,String userid_search,String state_search,String department_search,String parentid){
		 return taskDao.countByExample(projectid_search, userid_search, state_search,department_search,parentid);
	 }
	 
	public Task selectByPrimaryKey(int taskid){
		return taskDao.selectByPrimaryKey(taskid);	 
	 }
	 
	
	public int insertTask(Task task) {
		
		return taskDao.insertProject(task);
	}
	
public int deleteByPrimaryKey(int i) {
		
		return taskDao.deleteByPrimaryKey(i);
	}

public int updateState(int id,int state){
	
	return taskDao.updateState(id,state);
}

public int recordTime(int id,float recordtime,int Completion){
	Task task=taskDao.selectByPrimaryKey(id);
	float currenttime=0;
	if(task.getCurrenttime()==null){
		currenttime=0;
	}else{
		currenttime=task.getCurrenttime();
	}
	float time=currenttime+recordtime;
	return taskDao.updateTime(id, time,Completion);
}



public int countByParentid(int parentid){
	return taskDao.countByParentid(parentid);
}
	
public List<Task> selectByParentid(int parentid){
	return taskDao.selectByParentid(parentid);
}
}
