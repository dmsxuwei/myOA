package com.dms.oa.po;

import java.util.Date;

public class Materialmanage {
    private Integer id;

    private Integer matId;

    private String name;

    private String number;

    private Integer count;

    private String addr;

    private String manage;

    private Date warehousingtime;

    private Integer isout;

    private Date outtime;

    private Integer iscompose;

    private Integer composeid;

    private Long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatId() {
        return matId;
    }

    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage == null ? null : manage.trim();
    }

    public Date getWarehousingtime() {
        return warehousingtime;
    }

    public void setWarehousingtime(Date warehousingtime) {
        this.warehousingtime = warehousingtime;
    }

    public Integer getIsout() {
        return isout;
    }

    public void setIsout(Integer isout) {
        this.isout = isout;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Integer getIscompose() {
        return iscompose;
    }

    public void setIscompose(Integer iscompose) {
        this.iscompose = iscompose;
    }

    public Integer getComposeid() {
        return composeid;
    }

    public void setComposeid(Integer composeid) {
        this.composeid = composeid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}