package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.DepartmentDao;
import com.dms.oa.dao.TimeupdateDao;
import com.dms.oa.po.Department;
import com.dms.oa.po.Timeupdate;

@Component
public class TimeupdateService {
	
	@Resource
	private TimeupdateDao timeupdateDao;
	
	public int insertTimeupdate(Timeupdate timeupdate){
		return timeupdateDao.insertTimeupdate(timeupdate);
	}
	
	
	

}
