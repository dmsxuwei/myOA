package com.dms.oa.model;

import com.dms.oa.util.TimeUtil;

/*map.put("projectid", projectMap.get(weeklys.get(i).getProjectid()));
map.put("taskid", taskMap.get(weeklys.get(i).getTaskid()));
map.put("week", "第"+weeklys.get(i).getWeek()+"周");
map.put("weekday", TimeUtil.getWeekOfDate(weeklys.get(i).getRecordtime()));
map.put("content", weeklys.get(i).getContent());
//map.put("recordtime", weeklys.get(i).getRecordtime());
map.put("opertor", userMap.get(weeklys.get(i).getOpertor()));*/

public class WeeklyReport {
	private String projectid;
	private String taskid;
	private String week;
	private String weekday;
	private String content;
	private String recordtime;
	private String opertor;
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getWeekday() {
		return weekday;
	}
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRecordtime() {
		return recordtime;
	}
	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}
	public String getOpertor() {
		return opertor;
	}
	public void setOpertor(String opertor) {
		this.opertor = opertor;
	}
	
	
}
