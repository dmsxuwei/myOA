package com.dms.oa.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import com.dms.oa.mapper.ProjectmembersMapper;
import com.dms.oa.mapper.TaskmembersMapper;
import com.dms.oa.mapper.UserMapper;
import com.dms.oa.mapper.UserRoleMapper;
import com.dms.oa.po.Projectmembers;
import com.dms.oa.po.ProjectmembersExample;
import com.dms.oa.po.Task;
import com.dms.oa.po.Taskmembers;
import com.dms.oa.po.TaskmembersExample;
import com.dms.oa.po.User;
import com.dms.oa.po.UserExample;
import com.dms.oa.po.UserRole;
import com.dms.oa.po.UserRoleExample;


/**
 * 
 * @author Administrator
 * 
 */
@Component
public class TaskUserDao {

	@Autowired
	private TaskmembersMapper taskmembersMapper;
	
/*	public User selectByPrimaryKey(Integer userid) {
		return userMapper.selectByPrimaryKey(userid);
	}*/

	public List<Taskmembers> selectByExample(){
		TaskmembersExample example =new TaskmembersExample();
		return taskmembersMapper.selectByExample(example);
	}
	
	public int insertSelective(Taskmembers record){
		return taskmembersMapper.insertSelective(record);
	}
	
	public int deleteByExample(Integer taskid,Integer userid){
		TaskmembersExample example =new TaskmembersExample();
		example.createCriteria().andTaskidEqualTo(taskid).andUseridEqualTo(userid);
		return taskmembersMapper.deleteByExample(example);
	}
	
	
	public int deleteByProject(Integer taskid){
		TaskmembersExample example =new TaskmembersExample();
		example.createCriteria().andTaskidEqualTo(taskid);
		return taskmembersMapper.deleteByExample(example);
	}
	
	
	 public List<Taskmembers> selectUseridByProject(int taskid){
		 TaskmembersExample example =new TaskmembersExample();
		 example.createCriteria().andTaskidEqualTo(taskid);
		return taskmembersMapper.selectByExample(example); 
	 }
	 
	 public List<Taskmembers> selectByUserid(int userid){
		 TaskmembersExample example =new TaskmembersExample();
		 example.createCriteria().andUseridEqualTo(userid);
		return taskmembersMapper.selectByExample(example); 
	 }
	
}
