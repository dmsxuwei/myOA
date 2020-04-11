package com.dms.oa.po;

public class Materielcatagory {
    private Integer id;

    private String catagoryname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCatagoryname() {
        return catagoryname;
    }

    public void setCatagoryname(String catagoryname) {
        this.catagoryname = catagoryname == null ? null : catagoryname.trim();
    }
}