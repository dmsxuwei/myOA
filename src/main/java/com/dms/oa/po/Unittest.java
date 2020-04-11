package com.dms.oa.po;

import java.util.Date;

public class Unittest {
    private Integer unittestid;

    private Integer usrid;

    private String testproject;

    private String testunit;

    private Integer result;

    private Date testtime;

    private String bak;

    private Date createtime;

    public Integer getUnittestid() {
        return unittestid;
    }

    public void setUnittestid(Integer unittestid) {
        this.unittestid = unittestid;
    }

    public Integer getUsrid() {
        return usrid;
    }

    public void setUsrid(Integer usrid) {
        this.usrid = usrid;
    }

    public String getTestproject() {
        return testproject;
    }

    public void setTestproject(String testproject) {
        this.testproject = testproject == null ? null : testproject.trim();
    }

    public String getTestunit() {
        return testunit;
    }

    public void setTestunit(String testunit) {
        this.testunit = testunit == null ? null : testunit.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Date getTesttime() {
        return testtime;
    }

    public void setTesttime(Date testtime) {
        this.testtime = testtime;
    }

    public String getBak() {
        return bak;
    }

    public void setBak(String bak) {
        this.bak = bak == null ? null : bak.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}