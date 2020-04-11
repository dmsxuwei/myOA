package com.dms.oa.po;

import java.util.Date;

public class Task {
    private Integer taskid;

    private Integer userid;

    private Integer projectid;

    private String taskname;

    private String taskdescription;

    private Float alltime;

    private Float currenttime;

    private Integer state;

    private Date createtime;

    private Date begintime;

    private Integer allocateid;

    private Integer isvalidity;

    private Integer auditor;

    private Integer emergencydegree;

    private String week;

    private Integer completion;

    private Integer departmentid;

    private Integer parentid;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription == null ? null : taskdescription.trim();
    }

    public Float getAlltime() {
        return alltime;
    }

    public void setAlltime(Float alltime) {
        this.alltime = alltime;
    }

    public Float getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(Float currenttime) {
        this.currenttime = currenttime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Integer getAllocateid() {
        return allocateid;
    }

    public void setAllocateid(Integer allocateid) {
        this.allocateid = allocateid;
    }

    public Integer getIsvalidity() {
        return isvalidity;
    }

    public void setIsvalidity(Integer isvalidity) {
        this.isvalidity = isvalidity;
    }

    public Integer getAuditor() {
        return auditor;
    }

    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    public Integer getEmergencydegree() {
        return emergencydegree;
    }

    public void setEmergencydegree(Integer emergencydegree) {
        this.emergencydegree = emergencydegree;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}