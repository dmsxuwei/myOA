package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.ProjectUserDao;
import com.dms.oa.po.Projectmembers;

@Component
public class ProjectUserService {
	
	@Resource
	private ProjectUserDao projectUserDao;
	
	public int insertProjectUser(Projectmembers projectmembers) {
		
		return projectUserDao.insertSelective(projectmembers);
	}
	
	public int deleteByProject(Integer projectid){
		return projectUserDao.deleteByProject(projectid);
	}
	
	public int deleteByExample(Integer projectid,Integer userid){
		return projectUserDao.deleteByExample(projectid,userid);
	}
	
	//根据用户ID查出角色
	 public List<Projectmembers> selectUseridByProject(int projectid){
		 return projectUserDao.selectUseridByProject(projectid);
	 }
	
	 public List<Projectmembers> selectByExample(){
		 return projectUserDao.selectByExample();
	 }
	 
	 public List<Projectmembers> selectByUserid(int userid){
		 return projectUserDao.selectByUserid(userid);
	 }

}
