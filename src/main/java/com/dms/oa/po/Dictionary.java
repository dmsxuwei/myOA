package com.dms.oa.po;

public class Dictionary {
    private Integer id;

    private Integer dkey;

    private String dvalue;

    private Integer dtype;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDkey() {
        return dkey;
    }

    public void setDkey(Integer dkey) {
        this.dkey = dkey;
    }

    public String getDvalue() {
        return dvalue;
    }

    public void setDvalue(String dvalue) {
        this.dvalue = dvalue == null ? null : dvalue.trim();
    }

    public Integer getDtype() {
        return dtype;
    }

    public void setDtype(Integer dtype) {
        this.dtype = dtype;
    }
}