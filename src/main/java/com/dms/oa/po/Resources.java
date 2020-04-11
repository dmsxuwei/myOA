package com.dms.oa.po;

public class Resources {
    private Integer resourceid;

    private String rosoucename;

    private String addr;

    private Integer parentid;

    private Integer isend;

    private Integer catagory;

    public Integer getResourceid() {
        return resourceid;
    }

    public void setResourceid(Integer resourceid) {
        this.resourceid = resourceid;
    }

    public String getRosoucename() {
        return rosoucename;
    }

    public void setRosoucename(String rosoucename) {
        this.rosoucename = rosoucename == null ? null : rosoucename.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getIsend() {
        return isend;
    }

    public void setIsend(Integer isend) {
        this.isend = isend;
    }

    public Integer getCatagory() {
        return catagory;
    }

    public void setCatagory(Integer catagory) {
        this.catagory = catagory;
    }
}