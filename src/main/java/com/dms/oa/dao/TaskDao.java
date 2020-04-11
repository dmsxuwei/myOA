package com.dms.oa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.TaskMapper;
import com.dms.oa.po.Task;
import com.dms.oa.po.TaskExample;
import com.dms.oa.po.TaskExample.Criteria;


@Component
public class TaskDao {
	@Autowired
	private TaskMapper taskMapper;
	
	
	 public List<Task> selectByExample(String projectid_search,String userid_search,
				String state_search,String department_search,String parentid){
		 TaskExample example =new TaskExample();
		 
		 Criteria criteria=example.createCriteria();
		 if(null!=projectid_search&&!"".equals(projectid_search)) criteria.andProjectidEqualTo(Integer.parseInt(projectid_search));
		 if(null!=userid_search&&!"".equals(userid_search)) criteria.andUseridEqualTo(Integer.parseInt(userid_search));
		 if(null!=state_search&&!"".equals(state_search)) criteria.andStateEqualTo(Integer.parseInt(state_search));
		 if(null!=department_search&&!"".equals(department_search)) criteria.andDepartmentidEqualTo(Integer.parseInt(department_search));
		 if(null!=parentid&&!"".equals(parentid)){
			 criteria.andParentidEqualTo(Integer.parseInt(parentid));
		 }else{
			 
		 }
		 //example.createCriteria().andAddrEqualTo("");
		 example.setOrderByClause("projectid");
		 //example.setOrderByClause("parentid");

		 
		// example.setOrderByClause("testtime");
		return taskMapper.selectByExample(example); 
	 }
	 
	 public List<Task> selectByTaskids(List<Integer> taskids){
		 TaskExample example =new TaskExample();
		 Criteria criteria=example.createCriteria();
		 criteria.andTaskidIn(taskids);
		 return taskMapper.selectByExample(example); 
	 }
	 
	 public List<Task> selectByExample(){
		 TaskExample example =new TaskExample();
		return taskMapper.selectByExample(example); 
	 }
	 
	 public List<Task> selectByProjectid(int projectid){
		 TaskExample example =new TaskExample();
		 example.createCriteria().andProjectidEqualTo(projectid);
		return taskMapper.selectByExample(example); 
	 }
	 
	 public int countByExample(String projectid_search,String userid_search,String state_search,String department_search,String parentid){
		 TaskExample example =new TaskExample();
		 
		 Criteria criteria=example.createCriteria();
		 if(null!=projectid_search&&!"".equals(projectid_search)) criteria.andProjectidEqualTo(Integer.parseInt(projectid_search));
		 if(null!=userid_search&&!"".equals(userid_search)) criteria.andUseridEqualTo(Integer.parseInt(userid_search));
		 if(null!=state_search&&!"".equals(state_search)) criteria.andStateEqualTo(Integer.parseInt(state_search));
		 if(null!=department_search&&!"".equals(department_search)) criteria.andDepartmentidEqualTo(Integer.parseInt(department_search));
		 if(null!=parentid&&!"".equals(parentid)){
			 criteria.andParentidEqualTo(Integer.parseInt(parentid));
		 }else{
			 
		 }
		 //example.createCriteria().andAddrEqualTo("");
		 example.setOrderByClause("projectid");
		 //example.setOrderByClause("parentid");

		 
		return taskMapper.countByExample(example);	 
	 }
	 
	 public int insertProject(Task task){
		 return taskMapper.insert(task);
	 }
	 
	 public int deleteByPrimaryKey(int id){
		 return taskMapper.deleteByPrimaryKey(id);
	 }
	 
	 public int updateState(int id,int state){
		 Task task=new Task();
		 task.setTaskid(id);
		 task.setState(state);
		 if(state==1)task.setBegintime(new Date());
		 return taskMapper.updateByPrimaryKeySelective(task);
	 }
	 
	 public Task selectByPrimaryKey(int taskid){
		return taskMapper.selectByPrimaryKey(taskid);	 
	 }
	 
	 public int updateTime(int id,float time,int Completion){
		 Task task=new Task();
		 task.setTaskid(id);
		 task.setCurrenttime(time);
		 task.setCompletion(Completion);
		 return taskMapper.updateByPrimaryKeySelective(task);
	 }
	 
	 public int countByParentid(int parentid){
		 TaskExample example =new TaskExample();
		 Criteria criteria=example.createCriteria();
		 criteria.andParentidEqualTo(parentid);
		return taskMapper.countByExample(example);	 
	 }
	 
	 public List<Task> selectByParentid(int parentid){
		 TaskExample example =new TaskExample();
		 example.createCriteria().andParentidEqualTo(parentid);
		return taskMapper.selectByExample(example); 
	 }
	 
}
