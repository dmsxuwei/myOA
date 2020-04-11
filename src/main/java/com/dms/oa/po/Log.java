package com.dms.oa.po;

import java.util.Date;

public class Log {
    private Integer id;

    private Integer type;

    private String content;

    private String week;

    private Date recordtime;

    private String addr;

    private Integer opertor;

    private Integer projectid;

    private Integer taskid;

    private String timeindex;

    private Float usetime;

    private Integer departmentid;

    private Integer completion;

    private Integer timeclass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week == null ? null : week.trim();
    }

    public Date getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getOpertor() {
        return opertor;
    }

    public void setOpertor(Integer opertor) {
        this.opertor = opertor;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTimeindex() {
        return timeindex;
    }

    public void setTimeindex(String timeindex) {
        this.timeindex = timeindex == null ? null : timeindex.trim();
    }

    public Float getUsetime() {
        return usetime;
    }

    public void setUsetime(Float usetime) {
        this.usetime = usetime;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public Integer getCompletion() {
        return completion;
    }

    public void setCompletion(Integer completion) {
        this.completion = completion;
    }

    public Integer getTimeclass() {
        return timeclass;
    }

    public void setTimeclass(Integer timeclass) {
        this.timeclass = timeclass;
    }
}