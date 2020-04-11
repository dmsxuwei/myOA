package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.RoleDao;
import com.dms.oa.po.Role;

@Component
public class RoleService {
	
	@Resource
	private RoleDao roleDao;
	
	public List<Role> getRole(){
		return roleDao.selectByExample();
	}
	
	public int insertRole(Role role) {
		
		return roleDao.insertRole(role);
	}
	
public int deleteByPrimaryKey(int i) {
		
		return roleDao.deleteByPrimaryKey(i);
	}

public List<Role> selectByRoleidIn(List<Integer> roleids){
	return roleDao.selectByRoleidIn(roleids);
	
}
	
}
