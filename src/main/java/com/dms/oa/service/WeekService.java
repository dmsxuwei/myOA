package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.LogDao;
import com.dms.oa.dao.WeeklyDao;
import com.dms.oa.po.Log;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Component
public class WeekService {
	
	@Resource
	private WeeklyDao weeklyDao;
	@Resource
	private LogDao logDao;
	
	 public List<Log> selectWeekly(String projectid_search,String userid_search,String week_search,String department_search){
/*		 PageInfo<Log> logs=queryByPage(pageNo,pageSize);
		 System.out.println("logs.getList().size():"+logs.getList().size());
		 for(int i=0;i<logs.getList().size();i++){
			System.out.println(logs.getList().get(i).getId()); 
		 }*/
		 return weeklyDao.selectWeekly(projectid_search, userid_search,week_search,department_search);
	 }
	 
	 public int countByExample(String projectid_search,String userid_search,String week_search,String department_search){
		 return weeklyDao.countByExample(projectid_search, userid_search, week_search,department_search);
	 }
	 
	 public PageInfo<Log> queryByPage(String week,Integer opertor,Integer pageNo,Integer pageSize,
			 String projectid_search,String userid_search,String week_search,String department_search) {
		    pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Log> list = selectWeekly(projectid_search,userid_search,week_search,department_search);
		    //用PageInfo对结果进行包装
		    PageInfo<Log> page = new PageInfo<Log>(list);
		    //测试PageInfo全部属性
/*		    System.out.println(page.getPageNum());
		    System.out.println(page.getPageSize());
		    System.out.println(page.getStartRow());
		    System.out.println(page.getEndRow());
		    System.out.println(page.getTotal());
		    System.out.println(page.getPages());
		    System.out.println(page.getFirstPage());
		    System.out.println(page.getLastPage());
		    System.out.println(page.isHasPreviousPage());
		    System.out.println(page.isHasNextPage());*/
		    return page;
		}
	
	 public int deleteByPrimaryKey(int id){
		 return weeklyDao.deleteByPrimaryKey(id);
	 }
	 
	 public int deleteByTaskid(int taskid){
		 return weeklyDao.deleteByTaskid(taskid);
	 }

}
