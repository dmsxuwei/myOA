package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.UserDaoImpl;
import com.dms.oa.po.User;

@Component
public class UserService {
	
	@Resource
	private UserDaoImpl userDaoImpl;
	
	public List<User> getUser(){
		return userDaoImpl.selectByExample();	
	}
	
	public User selectByPrimaryKey(Integer userid){
		return userDaoImpl.selectByPrimaryKey(userid);
	}
	
	public List<User> selectByUsername(String username){
		return userDaoImpl.selectByUsername(username);
	}
	
	public int insertUser(User user) {
	
		return userDaoImpl.insertSelective(user);
	}
	
	public int deleteByPrimaryKey(Integer userid){
		return userDaoImpl.deleteByPrimaryKey(userid);
	}
	
	
	public int updateByPrimaryKeySelective(User user){
		return userDaoImpl.updateByPrimaryKeySelective(user);
	}
	

}
