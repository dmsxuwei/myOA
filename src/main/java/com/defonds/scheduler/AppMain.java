    /** 
     * File Name：AppMain.java 
     * 
     * Copyright Defonds Corporation 2015  
     * All Rights Reserved 
     * 
     */  
    package com.defonds.scheduler;  
      
    import org.springframework.context.support.AbstractApplicationContext;  
    import org.springframework.context.support.ClassPathXmlApplicationContext;  
      
    /** 
     *  
     * Project Name：spring-quartz 
     * Type Name：AppMain 
     * Type Description： 
     * Author：Defonds 
     * Create Date：2015-10-29 
     * @version  
     *  
     */  
    public class AppMain {  
      
        public static void main(String args[]){  
            AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-quartz.xml");  
        }  
      
    }  