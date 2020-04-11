package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.ProjectUserDao;
import com.dms.oa.dao.TaskUserDao;
import com.dms.oa.po.Projectmembers;
import com.dms.oa.po.Taskmembers;

@Component
public class TaskUserService {
	
	@Resource
	private TaskUserDao taskUserDao;
	
	public int insertTaskUser(Taskmembers taskmembers) {
		
		return taskUserDao.insertSelective(taskmembers);
	}
	
	public int deleteByTask(Integer taskid){
		return taskUserDao.deleteByProject(taskid);
	}
	
	public int deleteByExample(Integer taskid,Integer userid){
		return taskUserDao.deleteByExample(taskid,userid);
	}
	
	//根据用户ID查出角色
	 public List<Taskmembers> selectUseridByTask(int taskid){
		 return taskUserDao.selectUseridByProject(taskid);
	 }
	
	 public List<Taskmembers> selectByExample(){
		 return taskUserDao.selectByExample();
	 }
	 
	 public List<Taskmembers> selectByUserid(int userid){
		 return taskUserDao.selectByUserid(userid);
	 }

}
