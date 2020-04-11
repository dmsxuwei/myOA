package com.dms.oa.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.base.Basedata;
import com.dms.oa.dao.TasktimeDao;
import com.dms.oa.po.Tasktime;
import com.dms.oa.po.Timeupdate;
import com.dms.oa.util.TimeUtil;

@Component
public class TasktimeService {
	
	@Resource
	private TasktimeDao tasktimeDao;
	@Resource
	private TimeupdateService timeupdateService;
	
	public List<Tasktime> getTask(){
		return tasktimeDao.selectByExample();
	}

	 public int insertTasktime(Tasktime tasktime){
		 
		 return tasktimeDao.insertTasktime(tasktime);
	 }
	
	 public Tasktime selectByPrimaryKey(int id){
		 return tasktimeDao.selectByPrimaryKey(id);	 
	 }
	 
	public int updateTasktime(Tasktime tasktime){
		return tasktimeDao.updateTasktime(tasktime);
	}
	
	 public Tasktime selectByUser(int userid){
		 return tasktimeDao.selectByUser(userid);
	 }
	
	public int updateAllTasktime(){
		float daytime=Basedata.daytime;
		List<Tasktime> tasktimes=getTask();
		for(int i=0;i<tasktimes.size();i++){
			tasktimes.get(i).setTime(tasktimes.get(i).getTime()+daytime);
			tasktimes.get(i).setAlltime(tasktimes.get(i).getAlltime()+daytime);
			updateTasktime(tasktimes.get(i));
			
			Timeupdate timeupdate=new Timeupdate();
			timeupdate.setId(tasktimes.get(i).getId());//任务时间ID
			timeupdate.setRecordtime(new Date());
			timeupdate.setTime(TimeUtil.getTimestr(new Date()));
			timeupdate.setBak("定时加时");
			timeupdate.setType(0);//日累加
			timeupdate.setChangetime(daytime);//增量
			timeupdate.setUserid(tasktimes.get(i).getUserid());
			timeupdateService.insertTimeupdate(timeupdate);
			
		}

		return 0;
	}
	 
	
}
