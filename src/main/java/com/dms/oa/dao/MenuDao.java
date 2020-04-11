package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.ResourcesMapper;
import com.dms.oa.po.Resources;
import com.dms.oa.po.ResourcesExample;



@Component
public class MenuDao {
	@Autowired
	private ResourcesMapper resourcesMapper;
	
	public List<Resources> selectByExample(){
		ResourcesExample example =new ResourcesExample();
		example.setOrderByClause("parentid");
		return resourcesMapper.selectByExample(example);
	}
}
