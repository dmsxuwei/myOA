package com.dms.oa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	public static int getWeek(Date date){
	Calendar cal=Calendar.getInstance(); 
	cal.setTime(date);
	int week=cal.get(Calendar.WEEK_OF_YEAR);
	return week;
	}
	
	public static String getTimestr(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	public static String getWeekOfDate(Date dt){
		String [] weekDays={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		Calendar cal=Calendar.getInstance();
		cal.setTime(dt);
		int w=cal.get(Calendar.DAY_OF_WEEK)-1;
		if(w<0){
			w=0;
		}
		return weekDays[w];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(TimeUtil.getWeekOfDate(new Date()));
	}

}
