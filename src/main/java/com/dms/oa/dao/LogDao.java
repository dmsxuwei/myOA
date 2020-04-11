package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.LogMapper;
import com.dms.oa.po.Log;
import com.dms.oa.po.LogExample;

@Component
public class LogDao {
	@Autowired
	private LogMapper logMapper;
	
	
	 public List<Log> selectAllLog(){
		LogExample example =new LogExample();
		return logMapper.selectByExample(example);
	 }
	 
	 public int insertLog(Log log){
		 return logMapper.insert(log);
	 }
	 

	 
}
