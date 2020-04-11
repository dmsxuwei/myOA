package com.dms.oa.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import com.dms.oa.mapper.UserMapper;
import com.dms.oa.po.User;
import com.dms.oa.po.UserExample;


/**
 * 
 * @author Administrator
 * 
 */
@Component
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public User selectByPrimaryKey(Integer userid) {
		return userMapper.selectByPrimaryKey(userid);
	}

	public List<User> selectByUsername(String username){
		UserExample example =new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		return userMapper.selectByExample(example);
	}
	
	public User selectByUsername(Integer userid){
		
		return userMapper.selectByPrimaryKey(userid);
	}
	
	public List<User> selectByExample(){
		UserExample example =new UserExample();
		return userMapper.selectByExample(example);
	}
	
	
	
	public int insertSelective(User record){
		return userMapper.insertSelective(record);
	}
	
	public int deleteByPrimaryKey(Integer userid){
		return userMapper.deleteByPrimaryKey(userid);
	}
	
	public int updateByPrimaryKeySelective(User user){
		return userMapper.updateByPrimaryKeySelective(user);
	}
	
}
