package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.ProjectDao;
import com.dms.oa.po.Log;
import com.dms.oa.po.Project;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Component
public class ProjectService {
	
	@Resource
	private ProjectDao projectDao;
	
	public List<Project> getProject(){
		return projectDao.selectByExample();	
	}
	
	
	 public PageInfo<Project> queryByPage(Integer pageNo,Integer pageSize) {
		    pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Project> list = getProject();
		    PageInfo<Project> page = new PageInfo<Project>(list);
		    return page;
		}
	
	 public int countByExample(){
		 return projectDao.countByExample();
	 }
	 
	public int insertProject(Project project) {
		
		return projectDao.insertProject(project);
	}
	
public int deleteByPrimaryKey(int i) {
		
		return projectDao.deleteByPrimaryKey(i);
	}
	
}
