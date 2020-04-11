package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.LogDao;
import com.dms.oa.po.Log;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Component
public class LogService {
	
	@Resource
	private LogDao logDao;
	
	public List<Log> getLog(){
		return logDao.selectAllLog();	
	}
	
	public int insertLog(Log log) {
		
		return logDao.insertLog(log);
	}
	
	
	

}
