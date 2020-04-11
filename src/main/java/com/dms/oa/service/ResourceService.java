package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.ResourceDao;
import com.dms.oa.po.Resources;

@Component
public class ResourceService {
	
	@Resource
	private ResourceDao resourceDao;
	
	public List<Resources> getResource(){
		return resourceDao.selectByExample();
	}
	
	public int insertResources(Resources resources) {
		
		return resourceDao.insertResource(resources);
	}
	
public int deleteByPrimaryKey(int i) {
		
		return resourceDao.deleteByPrimaryKey(i);
	}
	

public List<Resources> selectByResourceidIn(List<Integer> resourceids){
	return resourceDao.selectByRoleidIn(resourceids);
	
}

}
