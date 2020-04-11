package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.UserDaoImpl;
import com.dms.oa.dao.UserRoleDao;
import com.dms.oa.po.Task;
import com.dms.oa.po.User;
import com.dms.oa.po.UserRole;

@Component
public class UserRoleService {
	
	@Resource
	private UserRoleDao userroleDao;
	
	public int insertUserRole(UserRole userrole) {
		
		return userroleDao.insertSelective(userrole);
	}
	
	public int deleteByExample(Integer userid,Integer roleid){
		return userroleDao.deleteByExample(userid,roleid);
	}
	
	//根据用户ID查出角色
	 public List<UserRole> selectRolesByUserid(int userid){
		 return userroleDao.selectRolesByUserid(userid);
	 }
	

}
