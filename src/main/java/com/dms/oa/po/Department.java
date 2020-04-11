package com.dms.oa.po;

public class Department {
    private Integer id;

    private String name;

    private Integer manage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getManage() {
        return manage;
    }

    public void setManage(Integer manage) {
        this.manage = manage;
    }
}