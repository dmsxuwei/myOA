package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.TasktimeMapper;
import com.dms.oa.po.Tasktime;
import com.dms.oa.po.TasktimeExample;


@Component
public class TasktimeDao {
	@Autowired
	private TasktimeMapper tasktimeMapper;
	
	
	 public List<Tasktime> selectByExample(){
		 TasktimeExample example =new TasktimeExample();
		return tasktimeMapper.selectByExample(example);
	 }
	 
	 public int insertTasktime(Tasktime tasktime){
		 return tasktimeMapper.insertSelective(tasktime);
	 }
	 
/*	 public int deleteByPrimaryKey(int id){
		 return taskMapper.deleteByPrimaryKey(id);
	 }*/
	 
	 
	 public Tasktime selectByPrimaryKey(int id){
		return tasktimeMapper.selectByPrimaryKey(id);
	 }
	 
	 public int updateTasktime(Tasktime tasktime){
		 return tasktimeMapper.updateByPrimaryKeySelective(tasktime);
	 }
	 
	 public Tasktime selectByUser(int userid){
		 TasktimeExample example =new TasktimeExample();
		 example.createCriteria().andUseridEqualTo(userid);
		 List<Tasktime> tasktimes=tasktimeMapper.selectByExample(example);
		 return tasktimes.get(0);
	 }
	 
}
