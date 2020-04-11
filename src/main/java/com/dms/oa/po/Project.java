package com.dms.oa.po;

import java.util.Date;

public class Project {
    private Integer projectid;

    private Integer userid;

    private String projectname;

    private String projectdescripton;

    private Integer projectstate;

    private Date createtime;

    private Date begintime;

    private String num;

    private Integer mainclass;

    private Integer subclass;

    private Integer projectsource;

    private String bak;

    private Integer parentid;

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public String getProjectdescripton() {
        return projectdescripton;
    }

    public void setProjectdescripton(String projectdescripton) {
        this.projectdescripton = projectdescripton == null ? null : projectdescripton.trim();
    }

    public Integer getProjectstate() {
        return projectstate;
    }

    public void setProjectstate(Integer projectstate) {
        this.projectstate = projectstate;
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public Integer getMainclass() {
        return mainclass;
    }

    public void setMainclass(Integer mainclass) {
        this.mainclass = mainclass;
    }

    public Integer getSubclass() {
        return subclass;
    }

    public void setSubclass(Integer subclass) {
        this.subclass = subclass;
    }

    public Integer getProjectsource() {
        return projectsource;
    }

    public void setProjectsource(Integer projectsource) {
        this.projectsource = projectsource;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak == null ? null : bak.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}