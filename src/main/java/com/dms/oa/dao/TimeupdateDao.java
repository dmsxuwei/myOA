package com.dms.oa.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.TimeupdateMapper;
import com.dms.oa.po.Timeupdate;

@Component
public class TimeupdateDao {
	@Autowired
	private TimeupdateMapper timeupdateMapper;
	
	
	public int insertTimeupdate(Timeupdate timeupdate){
		int rs=timeupdateMapper.insertSelective(timeupdate);
		return rs;
		
	}

	 

	 
}
