package com.dms.oa.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import com.dms.oa.mapper.ProjectmembersMapper;
import com.dms.oa.mapper.UserMapper;
import com.dms.oa.mapper.UserRoleMapper;
import com.dms.oa.po.Projectmembers;
import com.dms.oa.po.ProjectmembersExample;
import com.dms.oa.po.Task;
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
public class ProjectUserDao {

	@Autowired
	private ProjectmembersMapper projectmembersMapper;
	
/*	public User selectByPrimaryKey(Integer userid) {
		return userMapper.selectByPrimaryKey(userid);
	}*/

	public List<Projectmembers> selectByExample(){
		ProjectmembersExample example =new ProjectmembersExample();
		return projectmembersMapper.selectByExample(example);
	}
	
	public int insertSelective(Projectmembers record){
		return projectmembersMapper.insertSelective(record);
	}
	
	public int deleteByExample(Integer projectid,Integer userid){
		ProjectmembersExample example =new ProjectmembersExample();
		example.createCriteria().andProjectidEqualTo(projectid).andUseridEqualTo(userid);
		return projectmembersMapper.deleteByExample(example);
	}
	
	
	public int deleteByProject(Integer projectid){
		ProjectmembersExample example =new ProjectmembersExample();
		example.createCriteria().andProjectidEqualTo(projectid);
		return projectmembersMapper.deleteByExample(example);
	}
	
	
	 public List<Projectmembers> selectUseridByProject(int projectid){
		 ProjectmembersExample example =new ProjectmembersExample();
		 example.createCriteria().andProjectidEqualTo(projectid);
		return projectmembersMapper.selectByExample(example); 
	 }
	 
	 public List<Projectmembers> selectByUserid(int userid){
		 ProjectmembersExample example =new ProjectmembersExample();
		 example.createCriteria().andUseridEqualTo(userid);
		return projectmembersMapper.selectByExample(example); 
	 }
	
}
