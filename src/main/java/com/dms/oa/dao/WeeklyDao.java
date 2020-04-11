package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.LogMapper;
import com.dms.oa.po.Log;
import com.dms.oa.po.LogExample;
import com.dms.oa.po.LogExample.Criteria;

@Component
public class WeeklyDao {
	@Autowired
	private LogMapper logMapper;
	
	 public Log selectWeekly(int id){
		Log log= logMapper.selectByPrimaryKey(id);
		return log;
	 }
	
	 public List<Log> selectWeeklybyTaskid(int taskid){ 
		 LogExample example =new LogExample();
		 example.createCriteria().andTaskidEqualTo(taskid);
		 return logMapper.selectByExample(example);
		 
	 }
	 
	 public List<Log> selectWeekly(String projectid_search,String userid_search,String week_search,String department_search){
		LogExample example =new LogExample();
		Criteria criteria=example.createCriteria();
		criteria.andTypeEqualTo(1);
		if(!"".equals(week_search)&&week_search!=null){
			criteria.andWeekEqualTo(week_search+"");
		}
		if(userid_search!=null&&!"".equals(userid_search)){
			criteria.andOpertorEqualTo(Integer.parseInt(userid_search));
		}
		if(projectid_search!=null&&!"".equals(projectid_search)){
			criteria.andProjectidEqualTo(Integer.parseInt(projectid_search));
		}
		if(department_search!=null&&!"".equals(department_search)){
			criteria.andDepartmentidEqualTo(Integer.parseInt(department_search));
		}
		example.setOrderByClause("projectid,taskid,week,completion");
/*		example.setOrderByClause("projectid");
		example.setOrderByClause("taskid");
		example.setOrderByClause("completion")*/;
		return logMapper.selectByExample(example);
	 }
	 
	 public int countByExample(String projectid_search,String userid_search,String week_search,String department_search){
		 LogExample example =new LogExample();
			Criteria criteria=example.createCriteria();
			criteria.andTypeEqualTo(1);
			if(!"".equals(week_search)&&week_search!=null){
				criteria.andWeekEqualTo(week_search+"");
			}
			if(userid_search!=null&&!"".equals(userid_search)){
				criteria.andOpertorEqualTo(Integer.parseInt(userid_search));
			}
			if(projectid_search!=null&&!"".equals(projectid_search)){
				criteria.andProjectidEqualTo(Integer.parseInt(projectid_search));
			}
			if(department_search!=null&&!"".equals(department_search)){
				criteria.andDepartmentidEqualTo(Integer.parseInt(department_search));
			}
			return logMapper.countByExample(example);
			
	 }
	 
	 public int deleteByPrimaryKey(int id){
		
		 return logMapper.deleteByPrimaryKey(id);
	 }
	 
	 public int deleteByTaskid(int taskid){
		 LogExample example =new LogExample();
		 example.createCriteria().andTaskidEqualTo(taskid);
		 return logMapper.deleteByExample(example);
	 }
	 

	 

	 
}
