package com.dms.oa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.ResourcesMapper;
import com.dms.oa.mapper.RoleMapper;
import com.dms.oa.po.Resources;
import com.dms.oa.po.ResourcesExample;
import com.dms.oa.po.Role;
import com.dms.oa.po.RoleExample;

@Component
public class ResourceDao {
	@Autowired
	private ResourcesMapper resourcesMapper;
	
	
	 public List<Resources> selectByExample(){
		 ResourcesExample example =new ResourcesExample();
		 example.setOrderByClause("resourceid");
		return resourcesMapper.selectByExample(example); 
	 }
	 
	 //通过roleids找出role列表
	 public List<Resources> selectByRoleidIn(List<Integer> resourceids){
		 ResourcesExample example =new ResourcesExample();
		// example.setOrderByClause("resourceid");
/*		 List<Integer> value=new ArrayList();
		 Integer i=new Integer(1);
		 value.add(i);*/
		 example.createCriteria().andResourceidIn(resourceids);
		return resourcesMapper.selectByExample(example); 
	 }
	 
	 public int insertResource(Resources resources){
		 return resourcesMapper.insert(resources);
	 }
	 
	 public int deleteByPrimaryKey(int id){
		 return resourcesMapper.deleteByPrimaryKey(id);
	 }
	 
}
