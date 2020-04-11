package com.dms.oa.quartz;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.po.Timeupdate;
import com.dms.oa.service.MenuService;
import com.dms.oa.service.TasktimeService;
import com.dms.oa.service.TimeupdateService;
import com.dms.oa.service.UnittestService;
import com.dms.oa.util.TimeUtil;

//@Component
public class CustomTask {
	

@Resource
private TasktimeService tasktimeService;
@Resource
private TimeupdateService timeupdateService;

   static int day=0;
   @PostConstruct
	public void init() {
		System.out.println("==========================init===========================");
		new Thread(new Runnable(){

			public void run() {
				while(true){
					Date d = new Date();
					int hours = d.getHours();
					//System.out.println("week:"+d.getDay()+"day:"+d.getDate()+"hours:"+hours);
					if(hours==6&&d.getMinutes()==0&&d.getSeconds()==0&&d.getDate()!=6&&d.getDate()!=0){
						System.out.println(hours+":"+d.getMinutes()+":"+d.getSeconds()+"---"+d.getDate());
						//day=1;
						System.out.println("excute!");
						tasktimeService.updateAllTasktime();
						//System.out.println("size:"+menuService.getMenu().size());
						//day=d.getDate();
						Timeupdate timeupdate=new Timeupdate();
						//timeupdate.setId(tasktime.getId());//任务时间ID
						timeupdate.setRecordtime(new Date());
						timeupdate.setTime(TimeUtil.getTimestr(new Date()));
						timeupdate.setBak("定时加时=");
						//timeupdate.setType(Integer.parseInt(cased));
						timeupdate.setChangetime((float) 6.5);
						//timeupdate.setUserid(tasktime.getUserid());
						timeupdateService.insertTimeupdate(timeupdate);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
						
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}).start();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
