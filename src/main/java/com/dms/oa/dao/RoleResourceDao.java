package com.dms.oa.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import com.dms.oa.mapper.RoleResourceMapper;
import com.dms.oa.po.RoleResource;
import com.dms.oa.po.RoleResourceExample;



/**
 * 
 * @author Administrator
 * 
 */
@Component
public class RoleResourceDao {

	@Autowired
	private RoleResourceMapper roleResourceMapper;
	

	public int insertSelective(RoleResource record){
		return roleResourceMapper.insertSelective(record);
	}
	
	public int deleteByExample(Integer roleid,Integer resourceid){
		RoleResourceExample example =new RoleResourceExample();
		example.createCriteria().andRoleidEqualTo(roleid).andResourceidEqualTo(resourceid);
		
		return roleResourceMapper.deleteByExample(example);
	}
	
	 public List<RoleResource> selectResourcesByRoleid(int roleid){
		 RoleResourceExample example =new RoleResourceExample();
		 example.createCriteria().andRoleidEqualTo(roleid);
		return roleResourceMapper.selectByExample(example); 
	 }
	
}
