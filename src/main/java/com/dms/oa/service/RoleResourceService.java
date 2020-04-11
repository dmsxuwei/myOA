package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.RoleResourceDao;
import com.dms.oa.po.RoleResource;

@Component
public class RoleResourceService {
	
	@Resource
	private RoleResourceDao roleresourceDao;
	
	public int insertRoleResource(RoleResource roleresource) {
		
		return roleresourceDao.insertSelective(roleresource);
	}
	
	public int deleteByExample(Integer roleid,Integer resourceid){
		return roleresourceDao.deleteByExample(roleid,resourceid);
	}
	
	//根据用户ID查出角色
	 public List<RoleResource> selectRolesByRoleid(int roleid){
		 return roleresourceDao.selectResourcesByRoleid(roleid);
	 }
	
	
}
