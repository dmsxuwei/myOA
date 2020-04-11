package com.dms.oa.model;

public class Menu {
    
    private String pid;//父菜单ID
    private String pText;//父菜单名称
    private String id;//子菜单Id
    private String text;//子菜单名称
    private String iconCls;//子菜单图标
    private String url;//子菜单路径
    private String state;
    
    //---------------set/get--------------
    
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    
    public String getpText() {
        return pText;
    }
    public void setpText(String pText) {
        this.pText = pText;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getIconCls() {
        return iconCls;
    }
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    
    
}