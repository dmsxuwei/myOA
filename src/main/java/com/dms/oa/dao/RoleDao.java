package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.RoleMapper;
import com.dms.oa.po.Role;
import com.dms.oa.po.RoleExample;

@Component
public class RoleDao {
	@Autowired
	private RoleMapper roleMapper;
	
	
	 public List<Role> selectByExample(){
		RoleExample example =new RoleExample();
		example.setOrderByClause("roleid");
		return roleMapper.selectByExample(example); 
	 }
	
	 //通过roleids找出role列表
	 public List<Role> selectByRoleidIn(List<Integer> roleids){
		RoleExample example =new RoleExample();
		//example.setOrderByClause("roleid");
		example.createCriteria().andRoleidIn(roleids);
		return roleMapper.selectByExample(example); 
	 }
	 
	 public int insertRole(Role role){
		 return roleMapper.insert(role);
	 }
	 
	 public int deleteByPrimaryKey(int id){
		 return roleMapper.deleteByPrimaryKey(id);
	 }
	 

	 
}
