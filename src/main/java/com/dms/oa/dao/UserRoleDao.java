package com.dms.oa.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import com.dms.oa.mapper.UserMapper;
import com.dms.oa.mapper.UserRoleMapper;
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
public class UserRoleDao {

	@Autowired
	private UserRoleMapper userroleMapper;
	
/*	public User selectByPrimaryKey(Integer userid) {
		return userMapper.selectByPrimaryKey(userid);
	}

	public List<User> selectByExample(){
		UserExample example =new UserExample();
		return userMapper.selectByExample(example);
	}
	*/
	public int insertSelective(UserRole record){
		return userroleMapper.insertSelective(record);
	}
	
	public int deleteByExample(Integer userid,Integer roleid){
		UserRoleExample example =new UserRoleExample();
		example.createCriteria().andUseridEqualTo(userid).andRoleidEqualTo(roleid);
		
		return userroleMapper.deleteByExample(example);
	}
	
	 public List<UserRole> selectRolesByUserid(int userid){
		 UserRoleExample example =new UserRoleExample();
		 example.createCriteria().andUseridEqualTo(userid);
		return userroleMapper.selectByExample(example); 
	 }
	
}
