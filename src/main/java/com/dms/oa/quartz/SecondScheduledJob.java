    /** 
     * File Name：SecondScheduledJob.java 
     * 
     * Copyright Defonds Corporation 2015  
     * All Rights Reserved 
     * 
     */  
    package com.dms.oa.quartz;  
      
    import java.util.Date;

import javax.annotation.Resource;

import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
import org.springframework.scheduling.quartz.QuartzJobBean;  
import org.springframework.stereotype.Component;

import com.dms.oa.po.Timeupdate;
import com.dms.oa.service.TasktimeService;
import com.dms.oa.service.TimeupdateService;
import com.dms.oa.util.TimeUtil;
      
    /** 
     *  
     * Project Name：spring-quartz 
     * Type Name：SecondScheduledJob 
     * Type Description： 
     * Author：Defonds 
     * Create Date：2015-10-29 
     * @version  
     *  
     */  
@Component("secondScheduledJob") 
    public class SecondScheduledJob  {  
    	@Resource
    	private TasktimeService tasktimeService;
    	@Resource
    	private TimeupdateService timeupdateService;
      
   	 public void printMessage() {  
   		Date d = new Date();
		//System.out.println("week:"+d.getDay()+"day:"+d.getDate()+"hours:"+hours);
		if(d.getDate()!=6&&d.getDate()!=0){
		 System.out.println("I am SecondScheduledJob");  
         tasktimeService.updateAllTasktime();
			Timeupdate timeupdate=new Timeupdate();
			//timeupdate.setId(tasktime.getId());//任务时间ID
			timeupdate.setRecordtime(new Date());
			timeupdate.setTime(TimeUtil.getTimestr(new Date()));
			timeupdate.setBak("定时加时=");
			//timeupdate.setType(Integer.parseInt(cased));
			timeupdate.setChangetime((float) 6.5);
			//timeupdate.setUserid(tasktime.getUserid());
         timeupdateService.insertTimeupdate(timeupdate);  
     }else{
    	 System.out.println("=============================周末============================");
     }
		}
      
    }  